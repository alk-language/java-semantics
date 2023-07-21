package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.stmt.BreakableStmtAST;
import ro.uaic.info.alk.ast.stmt.ConditionalStmtAST;
import ro.uaic.info.alk.ast.stmt.FinalTestConditionalStmtAST;
import ro.uaic.info.alk.ast.stmt.RepeatUntilAST;
import ro.uaic.info.alk.execution.exhaustive.EnvironmentMapper;
import ro.uaic.info.alk.execution.exhaustive.ExecutionStateMapper;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.exeptions.UnwindException;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.execution.state.FinalCheckLoopingState;
import ro.uaic.info.alk.execution.state.LoopingState;
import ro.uaic.info.alk.execution.state.statement.DoWhileState;
import ro.uaic.info.alk.execution.state.statement.IfStmtState;
import ro.uaic.info.alk.execution.state.statement.RepeatUntilState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.execution.utils.Stepper;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.exeptions.AlkDebugTerminateException;
import ro.uaic.info.alk.util.types.Storable;

import java.io.IOException;
import java.util.*;

public class ExecutionStack
   extends StatefulStack<ExecutionState, ExecutionResult>
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

    AlkExecution master;
    private Stack<String> lineStack = new Stack<>();
    private Stack<AlkExecution> clones = new Stack<>();
    private boolean breakOnNonBreakable = false;
    private boolean didStep = true;
    private boolean exitedConditional = false;

    private boolean inContinue = false;

    public ExecutionStack(AlkExecution master)
    {
        super(master.getConfig(), master::handleUnwind);
        this.master = master;
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
        LoopingState loop = (LoopingState) peek();
        boolean exitCondition = false;
        if (peek().getTree() instanceof RepeatUntilAST)
        {
            exitCondition = true;
        }
        if(loop.getConditionValue() != null && ((AlkBool) loop.getConditionValue()).isTrue() == exitCondition)
        {
            exitedConditional = true;
            result = smallStep();
            while (!empty() && !(peek().getTree() instanceof BreakableStmtAST))
            {
                result = smallStep();
            }
        }
        return result;
    }

    private Result<?> exitIfStmt()
    {
        Result<?> result = null;
        IfStmtState ifStmt = (IfStmtState) peek();
        if (ifStmt.hasExecuted())
        {
            exitedConditional = true;
            result = smallStep();
            while (!empty() && !(peek().getTree() instanceof BreakableStmtAST))
            {
                result = smallStep();
            }
        }
        return result;
    }

    private Result<?> exitConditionals()
    {
        if (empty())
        {
            return null;
        }

        Result<?> result = null;
        if (peek() instanceof DoWhileState || peek() instanceof RepeatUntilState)
        {
            result = exitFinalCheckConditionalStmt();
        }
        else if (peek() instanceof IfStmtState)
        {
            result = exitIfStmt();
        }
        return result;
    }

    private Result<?> gotoBreakableStmt()
    {
        Result<?> result = null;
        ExecutionState initialStackTop = peek();
        CallStack callStack = peek().getPayload().getExecution().getCallStack();
        int initialCallStackSize = callStack.size();
        while (!empty() && !(peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
        {
            result = smallStep();
        }
        while (!empty() && peek() == initialStackTop)
        {
            result = smallStep();
            while (!empty() && !(peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
            {
                result = smallStep();
            }
        }
        if (!empty() && breakOnNonBreakable && callStack.size() == initialCallStackSize)
        {
            result = smallStep();
            while (!empty() && !(peek().getTree() instanceof BreakableStmtAST) && callStack.size() >= initialCallStackSize)
            {
                result = smallStep();
            }
        }
        do
        {
            exitedConditional = false;
            result = exitConditionals();
        } while (exitedConditional);
        if (!empty())
            breakOnNonBreakable = !(peek().getTree() instanceof BreakableStmtAST);
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
        CallStack callStack = (peek().getPayload()).getExecution().getCallStack();
        callStack.printMessages();
        if (lineStack.size() > callStack.size() && didStep)
            lineStack.pop();
        if (!(peek().getTree() instanceof BreakableStmtAST))
        {
            printDebugMessage("Current line -> " + prettyLine(lineStack.peek()));
            return;
        }
        if (lineStack.size() >= callStack.size() && didStep)
            lineStack.pop();
        String currentLine = peek().getTree().getText();
        if (peek().getTree() instanceof ConditionalStmtAST)
        {
            currentLine = ((ConditionalStmtAST) peek().getTree()).getConditionalStmt();
        }
        else if (peek() instanceof DoWhileState || peek() instanceof RepeatUntilState)
        {
            if (((FinalCheckLoopingState) peek()).getFirstTime() || ((LoopingState) peek()).getCheckedCondition())
            {
                currentLine = ((FinalTestConditionalStmtAST) peek().getTree()).getDoRepeatStmt();
            }
            else
            {
                currentLine = ((FinalTestConditionalStmtAST) peek().getTree()).getConditionalStmt();
            }
        }
        printDebugMessage("Current line -> " +  peek().getTree().getLine() + ". " + prettyLine(currentLine));

        if (lineStack.size() < callStack.size() && didStep)
            lineStack.push(peek().getTree().getLine() + ". " + currentLine);
    }

    void printCommand(String key)
    {
        if (!helpMessages.containsKey(key))
        {
            printDebugMessage("\"" + key + "\" is not a valid command, use \"help\" to see all the available commands.");
            return;
        }
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < 10 - key.length(); ++i)
        {
            spaces.append(" ");
        }
        printDebugMessage(key + spaces + "->\t" + helpMessages.get(key).get(0));
        printDebugMessage("            \t" + helpMessages.get(key).get(1));
    }

    private Result<?> debugStep()
    {
        //smallStep();
        return gotoBreakableStmt();
    }

    private void printDebugMessage(String message)
    {
        conf.getIOManager().write(message);
        conf.getIOManager().flush();
    }

    public Result<?> debug()
    {
        Result<?> result = null;
        Set<Integer> breakpoints = new HashSet<>();
        if (!(peek().getTree() instanceof BreakableStmtAST))
        {
            result = gotoBreakableStmt();
        }
        while (!empty())
        {
            CallStack callStack = (peek().getPayload()).getExecution().getCallStack();
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
                printDebugMessage(e.getMessage());
                continue;
            }
            if (conf.hasDebugMarkers())
            {
                printDebugMessage("--- begin <" + line + "> ---");
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
                    while (!empty() &&
                            (callStack.size() > currentStackDepth ||
                                    callStack.size() == currentStackDepth && !(peek().getTree() instanceof BreakableStmtAST)))
                    {
                        result = debugStep();
                    }
                    break;
                }
                case "finish":
                {
                    didStep = true;
                    int currentStackDepth = callStack.size();
                    result = debugStep();
                    while (!empty() && callStack.size() >= currentStackDepth)
                    {
                        result = debugStep();
                    }
                    break;
                }
                case "backtrace":
                {
                    if (callStack.empty())
                    {
                        printDebugMessage("Empty call stack.");
                    }
                    else
                    {
                        for (int i=callStack.size()-1;i>=0;i--)
                        {
                            int l = peek().getTree().getLine();
                            if (i < callStack.size() - 1)
                                l = callStack.get(i + 1).getTree().getLine();
                            printDebugMessage(callStack.get(i).toString() + " at line " + l);
                        }
                    }
                    
                    break;
                }
                case "print":
                {
                    if (tokens.length < 2)
                    {
                        printDebugMessage("No expression given.");
                        break;
                    }
                    AST root = new SimpleAlkParser().parseExpr(tokens[1]);
                    if (root == null)
                    {
                        printDebugMessage("Syntax error!");
                        break;
                    }
                    if (root instanceof AssignmentAST) // de investigat alte statementuri cu side-effect
                    {
                        printDebugMessage("This statement has side-effects. Are you sure you want to run it? (yes / no)");
                        try
                        {
                            line = conf.getIOManager().readLine();
                            if (!line.equalsIgnoreCase("yes"))
                                break;
                        }
                        catch (IOException e)
                        {
                            printDebugMessage(e.getMessage());
                            break;
                        }
                    }
                    ExecutionPayload payload = peek().getPayload();
                    AlkExecution execution = payload.getExecution();
                    try
                    {
                        Storable value = Stepper.run(root, new AlkConfiguration(),
                                                     payload.getEnv(),
                                                     execution.getStore(),
                                                     execution.getPathCondition(),
                                                     execution.getFuncManager(),
                                                     execution.getInterpreter());
                        if (value == null)
                        {
                            printDebugMessage("No value.");
                        }
                        else
                        {
                            printDebugMessage(value.toRValue().toString());
                        }
                    }
                    catch (Exception e)
                    {
                        printDebugMessage("Error. " + e.getMessage());
                    }
                    break;
                }
                case "break":
                {
                    if (tokens.length < 2)
                    {
                        printDebugMessage("No line number given.");
                        break;
                    }
                    try
                    {
                        breakpoints.add(Integer.parseInt(tokens[1]));
                    }
                    catch (Exception e)
                    {
                        printDebugMessage(e.getMessage());
                    }
                    break;
                }
                case "breakpoints":
                {
                    if (breakpoints.size() == 0)
                    {
                        printDebugMessage("No breakpoints are active.");
                        
                        break;
                    }
                    printDebugMessage("Currently active breakpoints:");
                    
                    int pos = 0;
                    for (int bp : breakpoints)
                    {
                        printDebugMessage("Breakpoint " + ++pos + " at line " + bp);
                        
                    }
                    break;
                }
                case "continue":
                {
                    result = debugStep();
                    inContinue = true;
                    while (!empty() && !breakpoints.contains(peek().getTree().getLine()))
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
                            printDebugMessage("No breakpoint at line " + lineNum);
                            break;
                        }
                        breakpoints.remove(lineNum);
                    }
                    catch (Exception e)
                    {
                        printDebugMessage(e.getMessage());
                    }
                    break;
                }
                case "back":
                {
                    if (clones.size() == 0)
                    {
                        printDebugMessage("No checkpoints");
                        printDebugMessage("--- end <back> ---");
                        break;
                    }
                    printDebugMessage("Choose the index of the checkpoint you want to return to.");
                    
                    for (int i=0; i < clones.size(); i++)
                    {
                        printDebugMessage("Checkpoint " + i + ":");
                        clones.get(i).getStack().printCurrentLine();
                    }
                    printDebugMessage("--- end <back> ---");
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
                            printDebugMessage(e.getMessage());
                        }
                        catch (NumberFormatException e)
                        {
                            printDebugMessage("Invalid number");
                        }
                    }
                }
                case "checkpoints":
                {
                    if (clones.size() == 0)
                    {
                        printDebugMessage("No checkpoints are active.");
                        break;
                    }
                    printDebugMessage("Currently active checkpoints:");
                    
                    for (int i=0; i < clones.size(); i++)
                    {
                        printDebugMessage("Checkpoint " + i + ":");
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
                            printDebugMessage(e.getMessage());
                        }
                    }
                    break;
                }
            }
            if (conf.hasDebugMarkers() && !line.equals("back"))
            {
                printDebugMessage("--- end <" + line + "> ---");
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

    ExecutionStateMapper cloneStates(AlkExecution master, LocationMapper locMapping, EnvironmentMapper envMapper)
    {
        ExecutionStateMapper mapping = new ExecutionStateMapper();

        for (ExecutionState state : this)
        {
            SplitMapper sm = new SplitMapper(master, locMapping, envMapper);
            ExecutionState copyState = state.clone(sm);
            mapping.put(state, copyState);

            assert copyState.getPayload().getExecution() == master;
        }

        return mapping;
    }

    ExecutionStack makeClone(AlkExecution master, ExecutionStateMapper stateMapping)
    {
        ExecutionStack clone = new ExecutionStack(master);

        for (ExecutionState state : this)
        {
            clone.push(stateMapping.get(state));
        }

        clone.lineStack = new Stack<>();
        for (String s : this.lineStack)
            clone.lineStack.push(s);

        clone.clones = new Stack<>();
        for (AlkExecution e : this.clones)
            clone.clones.push(e);

        clone.breakOnNonBreakable = this.breakOnNonBreakable;
        clone.didStep = this.didStep;
        clone.exitedConditional = this.exitedConditional;

        return clone;
    }
}
