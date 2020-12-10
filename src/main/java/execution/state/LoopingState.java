package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.parser.exceptions.BreakException;
import execution.parser.exceptions.ContinueException;
import execution.parser.exceptions.UnwindException;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

public abstract class LoopingState extends ExecutionState<Value, Value>
{
    private Class<? extends alkBaseVisitor> conditionVisitor;
    private Class<? extends alkBaseVisitor> bodyVisitor;
    private ParseTree condition;
    protected ParseTree body;
    protected boolean checkedCondition = false;
    protected boolean validCondition = false;
    protected boolean broke = false;

    public LoopingState(ParseTree tree,
                        ExecutionPayload executionPayload,
                        Class<? extends alkBaseVisitor> conditionVisitor,
                        Class<? extends alkBaseVisitor> bodyVisitor,
                        ParseTree condition,
                        ParseTree body)
    {
        super(tree, executionPayload);
        this.conditionVisitor = conditionVisitor;
        this.bodyVisitor = bodyVisitor;
        this.condition = condition;
        this.body = body;
    }

    @Override
    public ExecutionState makeStep()
    {
        if (broke)
        {
            return null;
        }

        if (!checkedCondition)
        {
            return request(conditionVisitor, condition);
        }

        if (!processValidity(validCondition))
        {
            setResult(new ExecutionResult<>(null));
            return null;
        }

        return request(bodyVisitor, body);
    }

    protected boolean processValidity(boolean validCondition)
    {
        return validCondition;
    }

    @Override
    public void assign(ExecutionResult executionResult)
    {
        if (!checkedCondition)
        {
            checkedCondition = true;
            Value decide = executionResult.getValue().toRValue();
            if (!(decide instanceof AlkBool))
            {
                super.handle(new AlkException("Condition in loop must be boolean."));
            }

            AlkBool bool = (AlkBool) decide;
            validCondition = bool.isTrue();
        }
        else
        {
            checkedCondition = false;
            validCondition = false;
        }
    }

    @Override
    public boolean handle(UnwindException e)
    {
        if (e instanceof BreakException)
        {
            assign(new ExecutionResult<>(null));
            broke = true;
            return true;
        }
        if (e instanceof ContinueException)
        {
            assign(new ExecutionResult<>(null));
            return true;
        }
        return false;
    }

    protected LoopingState decorate(LoopingState copy, SplitMapper sm)
    {
        copy.checkedCondition = checkedCondition;
        copy.validCondition = validCondition;
        copy.broke = broke;
        return (LoopingState) super.decorate(copy, sm);
    }
}
