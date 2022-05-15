package execution;

import ast.AST;
import ast.ASTStack;
import ast.expr.AssignmentAST;
import ast.stmt.BreakableStmtAST;
import ast.stmt.ConditionalStmtAST;
import ast.stmt.FinalTestConditionalStmtAST;
import ast.stmt.RepeatUntilAST;
import execution.exhaustive.EnvironmentMapper;
import execution.exhaustive.ExecutionStateMapper;
import execution.exhaustive.SplitMapper;
import execution.parser.AlkParser;
import execution.parser.exceptions.UnwindException;
import execution.state.ExecutionState;
import execution.parser.env.LocationMapper;
import execution.state.FinalCheckLoopingState;
import execution.state.LoopingState;
import execution.state.statement.DoWhileState;
import execution.state.statement.IfStmtState;
import execution.state.statement.RepeatUntilState;
import execution.types.alkBool.AlkBool;
import execution.utils.Stepper;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ParseTreeGlobals;
import state.Result;
import util.Configuration;
import util.exception.AlkDebugTerminateException;
import util.types.Storable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExecutionStack extends ASTStack<ExecutionState>
{
    private final HashMap<String, ArrayList<String>> helpMessages = new HashMap<String, ArrayList<String>>() {{
        put("help", new ArrayList<String>(){{
            add("help [<command>]");
            add("prints the usage and description of the command given as argument, or of all the commands if no argument is given.");
        }});
        put("run", new ArrayList<String>(){{
            add("run");
            add("continues the execution to the end of the program.");
        }});
        put("continue", new ArrayList<String>(){{
            add("continue");
            add("continues the execution until encountering a breakpoint.");
        }});
        put("step", new ArrayList<String>(){{
            add("step");
            add("executes a debug step.");
        }});
        put("next", new ArrayList<String>(){{
            add("next");
            add("executes a succession of debug steps until execution reaches a level lower or equal in the callstack.");
        }});
        put("backtrace", new ArrayList<String>(){{
            add("backtrace");
            add("prints the callstack.");
        }});
        put("print", new ArrayList<String>(){{
            add("print <expression>");
            add("evaluates an expression in the context of the current execution and prints the result.");
        }});
        put("break", new ArrayList<String>(){{
            add("break <line_number>");
            add("creates a breakpoint at the specified line.");
        }});
        put("breakpoints", new ArrayList<String>(){{
            add("breakpoints");
            add("prints all the breakpoints that currently exist.");
        }});
        put("clear", new ArrayList<String>(){{
            add("clear [<line_number>]");
            add("deletes the breakpoint at the specified line, or all of them if no argument is given.");
        }});
        put("back", new ArrayList<String>(){{
            add("back");
            add("goes back in the execution to a previous checkpoint.");
        }});
        put("checkpoints", new ArrayList<String>(){{
            add("checkpoints");
            add("prints all the checkpoints that currently exist.");
        }});
    }};

    Execution master;
    private Stack<String> lineStack = new Stack<>();
    private Stack<Execution> clones = new Stack<>();
    private boolean breakOnNonBreakable = false;
    private boolean didStep = true;
    private boolean exitedConditional = false;

    private boolean inContinue = false;

    public ExecutionStack(Execution master)
    {
        super(master.config);
        this.master = master;
    }

    @Override
    public ExecutionState pop()
    {
        return super.pop();
    }

    private Result<?> smallStep()
    {
        try
        {
            return makeStep();
        }
        catch (UnwindException u)
        {
            propagate(u);
            return null;
        }
    }

    private Result<?> exitFinalCheckConditionalStmt()
    {
        Result<?> result = null;
        LoopingState loop = (LoopingState)stack.peek();
        boolean exitCondition = false;
        if (stack.peek().getTree() instanceof RepeatUntilAST)
        {
            exitCondition = true;
        }
        if(loop.getConditionValue() != null && ((AlkBool)loop.getConditionValue()).getValue() == exitCondition)
        {
            exitedConditional = true;
            result = smallStep();
            while (!stack.empty() && !(stack.peek().getTree() instanceof BreakableStmtAST))
            {
                result = smallStep();
            }
        }
        return result;
    }

    private Result<?> exitIfStmt()
    {
        Result<?> result = null;
        IfStmtState ifStmt = (IfStmtState)stack.peek();
        if (ifStmt.hasExecuted())
        {
            exitedConditional = true;
            result = smallStep();
            while (!stack.empty() && !(stack.peek().getTree() instanceof BreakableStmtAST))
            {
                result = smallStep();
            }
        }
        return result;
    }

    private Result<?> exitConditionals()
    {
        Result<?> result = null;
        if (stack.peek() instanceof DoWhileState || stack.peek() instanceof RepeatUntilState)
        {
            result = exitFinalCheckConditionalStmt();
        }
        else if (stack.peek() instanceof IfStmtState)
        {
            result = exitIfStmt();
        }
        return result;
    }

    private Result<?> gotoBreakableStmt()
    {
        Result<?> result = null;
        ExecutionState initialStackTop = stack.peek();
        CallStack callStack = stack.peek().getPayload().getExecution().getCallStack();
        int initialCallStackSize = callStack.size();
        while (!stack.empty() && !(stack.peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
        {
            result = smallStep();
        }
        while (stack.peek() == initialStackTop)
        {
            result = smallStep();
            while (!stack.empty() && !(stack.peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
            {
                result = smallStep();
            }
        }
        if (breakOnNonBreakable && callStack.size() == initialCallStackSize)
        {
            result = smallStep();
            while (!stack.empty() && !(stack.peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
            {
                result = smallStep();
            }
        }
        do
        {
            exitedConditional = false;
            result = exitConditionals();
        } while (exitedConditional);
        breakOnNonBreakable = !(stack.peek().getTree() instanceof BreakableStmtAST);
        return result;
    }

    public String prettyLine(String line)
    {
        if (line.startsWith("return"))
        {
            return "return " + line.substring(6);
        }
        else if (line.startsWith("choose") && line.contains("from"))
        {
            int indexOfFrom = line.indexOf("from");
            int indexOfST = line.indexOf("s.t.");
            if (indexOfST != -1 && indexOfST > indexOfFrom)
            {
                return "choose " + line.substring(6, indexOfFrom) + " from " + line.substring(indexOfFrom + 4, indexOfST)
                        + " s.t. " + line.substring(indexOfST + 4);
            }
            return "choose " + line.substring(6, indexOfFrom) + " from " + line.substring(indexOfFrom + 4);
        }
        else if (line.startsWith("uniform"))
        {
            int indexOfFrom = line.indexOf("from");
            return "uniform " + line.substring(7, indexOfFrom) + " from " + line.substring(indexOfFrom + 4);
        }
        else
        {
            return line;
        }
    }

    public void printCurrentLine()
    {
        CallStack callStack = (stack.peek().getPayload()).getExecution().getCallStack();
        callStack.printMessages();
        if (lineStack.size() > callStack.size() && didStep)
            lineStack.pop();
        if (!(stack.peek().getTree() instanceof BreakableStmtAST))
        {
            conf.getIOManager().write("Current line -> " + prettyLine(lineStack.peek()));
            conf.getIOManager().flush();
            return;
        }
        if (lineStack.size() >= callStack.size() && didStep)
            lineStack.pop();
        String currentLine = stack.peek().getTree().getText();
        if (stack.peek().getTree() instanceof ConditionalStmtAST)
        {
            currentLine = ((ConditionalStmtAST)stack.peek().getTree()).getConditionalStmt();
        }
        else if (stack.peek() instanceof DoWhileState || stack.peek() instanceof RepeatUntilState)
        {
            if (((FinalCheckLoopingState)stack.peek()).getFirstTime() || ((LoopingState)stack.peek()).getCheckedCondition())
            {
                currentLine = ((FinalTestConditionalStmtAST)stack.peek().getTree()).getDoRepeatStmt();
            }
            else
            {
                currentLine = ((FinalTestConditionalStmtAST)stack.peek().getTree()).getConditionalStmt();
            }
        }

        conf.getIOManager().write("Current line -> " + stack.peek().getTree().getLine() + ". " + prettyLine(currentLine));
        conf.getIOManager().flush();

        if (lineStack.size() < callStack.size() && didStep)
            lineStack.push(stack.peek().getTree().getLine() + ". " + currentLine);
    }

    void printCommand(String key)
    {
        if (!helpMessages.containsKey(key))
        {
            conf.getIOManager().write("\"" + key + "\" is not a valid command, use \"help\" to see all the available commands.");
            conf.getIOManager().flush();
            return;
        }
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < 10 - key.length(); ++i)
        {
            spaces.append(" ");
        }
        conf.getIOManager().write(key + spaces + "->\t" + helpMessages.get(key).get(0));
        conf.getIOManager().write("            \t" + helpMessages.get(key).get(1));
        conf.getIOManager().flush();
    }

    private Result<?> debugStep()
    {
        //smallStep();
        return gotoBreakableStmt();
    }

    public Result<?> debug()
    {
        Result<?> result = null;
        Set<Integer> breakpoints = new HashSet<>();
        if (!(stack.peek().getTree() instanceof BreakableStmtAST))
        {
            result = gotoBreakableStmt();
        }
        while (!stack.empty())
        {
            CallStack callStack = (stack.peek().getPayload()).getExecution().getCallStack();
            if (callStack.empty())
                break;
            printCurrentLine();
            String line;
            try
            {
                line = conf.getIOManager().readLine();
            }
            catch (IOException e)
            {
                conf.getIOManager().write(e.getMessage());
                continue;
            }
            String[] tokens = line.split(" ", 2);
            String command = tokens[0];
            didStep = false;
            switch (command)
            {
                case "run":
                    conf.setDebugger(false);
                    return run();
                case "step":
                {
                    didStep = true;
                    result = debugStep();
                    break;
                }
                case "next":
                {
                    didStep = true;
                    int currentStackDepth = callStack.size();
                    result = debugStep();
                    while (!stack.empty() &&
                            (callStack.size() > currentStackDepth ||
                                    callStack.size() == currentStackDepth && !(stack.peek().getTree() instanceof BreakableStmtAST)))
                    {
                        result = debugStep();
                    }
                    break;
                }
                case "backtrace":
                {
                    if (callStack.empty())
                    {
                        conf.getIOManager().write("Empty call stack.");
                    }
                    else
                    {
                        for (int i=callStack.size()-1;i>=0;i--)
                        {
                            conf.getIOManager().write(callStack.get(i).toString());
                        }
                    }
                    conf.getIOManager().flush();
                    break;
                }
                case "print":
                {
                    if (tokens.length < 2)
                    {
                        conf.getIOManager().write("No expression given.");
                        break;
                    }
                    ParseTree tree = AlkParser.execute(tokens[1]);
                    if (tree == null)
                    {
                        conf.getIOManager().write("Syntax error!");
                        break;
                    }
                    AST root = ParseTreeGlobals.PARSE_TREE_EXPR_VISITOR.visit(tree);
                    if (root instanceof AssignmentAST) // de investigat alte statementuri cu side-effect
                    {
                        conf.getIOManager().write("This statement has side-effects. Are you sure you want to run it? (yes / no)");
                        conf.getIOManager().flush();
                        try
                        {
                            line = conf.getIOManager().readLine();
                            if (!line.equalsIgnoreCase("yes"))
                                break;
                        }
                        catch (IOException e)
                        {
                            conf.getIOManager().write(e.getMessage());
                            break;
                        }

                    }
                    ExecutionPayload payload = stack.peek().getPayload();
                    Execution execution = payload.getExecution();
                    try
                    {
                        Storable value = Stepper.run(root, new Configuration(),
                                payload.getEnv(),
                                execution.getStore(),
                                execution.getPathCondition(),
                                execution.getFuncManager(),
                                execution.getInterpreterManager());
                        if (value == null)
                        {
                            conf.getIOManager().write("No value.");
                        }
                        else
                        {
                            conf.getIOManager().write(value.toRValue().toString());
                        }
                    }
                    catch (Exception e)
                    {
                        conf.getIOManager().write("Error. " + e.getMessage());
                    }
                    conf.getIOManager().flush();
                    break;
                }
                case "break":
                {
                    if (tokens.length < 2)
                    {
                        conf.getIOManager().write("No line number given.");
                        break;
                    }
                    try
                    {
                        breakpoints.add(Integer.parseInt(tokens[1]));
                    }
                    catch (Exception e)
                    {
                        conf.getIOManager().write(e.getMessage());
                        conf.getIOManager().flush();
                    }
                    break;
                }
                case "breakpoints":
                {
                    if (breakpoints.size() == 0)
                    {
                        conf.getIOManager().write("No breakpoints are active.");
                        conf.getIOManager().flush();
                        break;
                    }
                    conf.getIOManager().write("Currently active breakpoints:");
                    conf.getIOManager().flush();
                    int pos = 0;
                    for (int bp : breakpoints)
                    {
                        conf.getIOManager().write("Breakpoint " + ++pos + " at line " + bp);
                        conf.getIOManager().flush();
                    }
                    break;
                }
                case "continue":
                {
                    result = debugStep();
                    inContinue = true;
                    while (!stack.empty() && !breakpoints.contains(stack.peek().getTree().getLine()))
                    {
                        result = debugStep();
                    }
                    inContinue = false;
                    break;
                }
                case "clear":
                {
                    if (tokens.length < 2)
                    {
                        breakpoints.clear();
                    }
                    try
                    {
                        int lineNum = Integer.parseInt(tokens[1]);
                        if (!breakpoints.contains(lineNum))
                        {
                            conf.getIOManager().write("No breakpoint at line " + lineNum);
                            conf.getIOManager().flush();
                            break;
                        }
                        breakpoints.remove(lineNum);
                    }
                    catch (Exception e)
                    {
                        conf.getIOManager().write(e.getMessage());
                        conf.getIOManager().flush();
                    }
                    break;
                }
                case "back":
                {
                    if (clones.size() == 0)
                    {
                        conf.getIOManager().write("No checkpoints");
                        conf.getIOManager().flush();
                        break;
                    }
                    conf.getIOManager().write("Choose the index of the checkpoint you want to return to.");
                    conf.getIOManager().flush();
                    for (int i=0; i < clones.size(); i++)
                    {
                        conf.getIOManager().write("Checkpoint " + i + ":");
                        conf.getIOManager().flush();
                        clones.get(i).getStack().printCurrentLine();
                    }
                    while (true)
                    {
                        try
                        {
                            String s = conf.getIOManager().readLine();
                            int choice = Integer.parseInt(s);
                            if (choice >= clones.size() || choice < 0)
                                throw new NumberFormatException();
                            clones.get(choice).start();
                            throw new AlkDebugTerminateException();
                        }
                        catch (IOException e)
                        {
                            conf.getIOManager().write(e.getMessage());
                            conf.getIOManager().flush();
                        }
                        catch (NumberFormatException e)
                        {
                            conf.getIOManager().write("Invalid number");
                            conf.getIOManager().flush();
                        }
                    }
                }
                case "checkpoints":
                {
                    if (clones.size() == 0)
                    {
                        conf.getIOManager().write("No checkpoints are active.");
                        conf.getIOManager().flush();
                        break;
                    }
                    conf.getIOManager().write("Currently active checkpoints:");
                    conf.getIOManager().flush();
                    for (int i=0; i < clones.size(); i++)
                    {
                        conf.getIOManager().write("Checkpoint " + i + ":");
                        conf.getIOManager().flush();
                        clones.get(i).getStack().printCurrentLine();
                    }
                    break;
                }
                case "help":
                {
                    if (tokens.length < 2)
                    {
                        helpMessages.forEach((k, v) -> printCommand(k));
                    }
                    else
                    {
                        try
                        {
                            printCommand(tokens[1]);
                        }
                        catch (Exception e)
                        {
                            conf.getIOManager().write(e.getMessage());
                            conf.getIOManager().flush();
                        }
                    }
                    break;
                }
            }

        }
        return result;
    }

    public void makeCheckpoint()
    {
        clones.push(master.clone().exec);
    }

    public boolean isInContinue()
    {
        return inContinue;
    }

    ExecutionStateMapper cloneStates(Execution master, LocationMapper locMapping, EnvironmentMapper envMapper)
    {
        ExecutionStateMapper mapping = new ExecutionStateMapper();

        for (ExecutionState state : stack)
        {
            SplitMapper sm = new SplitMapper(master, locMapping, envMapper);
            ExecutionState copyState = state.clone(sm);
            mapping.put(state, copyState);

            assert copyState.getPayload().getExecution() == master;
        }

        return mapping;
    }

    ExecutionStack makeClone(Execution master, ExecutionStateMapper stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master);

        for (ExecutionState state : stack)
        {
            clone.push(stateMapping.get(state));
        }

        clone.lineStack = new Stack<>();
        for (String s : this.lineStack)
            clone.lineStack.push(s);

        clone.breakOnNonBreakable = this.breakOnNonBreakable;
        clone.didStep = this.didStep;
        clone.exitedConditional = this.exitedConditional;

        return clone;
    }
}
