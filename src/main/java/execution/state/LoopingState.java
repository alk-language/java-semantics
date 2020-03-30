package execution.state;

import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import parser.exceptions.BreakException;
import parser.exceptions.ContinueException;
import parser.exceptions.UnwindException;
import util.Payload;
import util.types.Value;

public abstract class LoopingState extends ExecutionState
{
    private Class<? extends alkBaseVisitor> conditionVisitor;
    private Class<? extends alkBaseVisitor> bodyVisitor;
    private ParseTree condition;
    protected ParseTree body;
    protected boolean checkedCondition = false;
    protected boolean validCondition = false;
    protected boolean broke = false;

    public LoopingState(ParseTree tree,
                        Payload payload,
                        Class<? extends alkBaseVisitor> conditionVisitor,
                        Class<? extends alkBaseVisitor> bodyVisitor,
                        ParseTree condition,
                        ParseTree body)
    {
        super(tree, payload);
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
            result = new ExecutionResult<>(null);
            return null;
        }

        return request(bodyVisitor, body);
    }

    protected boolean processValidity(boolean validCondition)
    {
        return validCondition;
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (!checkedCondition)
        {
            checkedCondition = true;
            Value decide = result.getValue().toRValue();
            if (!(decide instanceof AlkBool))
            {
                throw new AlkException("Condition in loop must be boolean.");
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

    protected LoopingState decorate(LoopingState copy)
    {
        copy.checkedCondition = checkedCondition;
        copy.validCondition = validCondition;
        return (LoopingState) super.decorate(copy);
    }
}
