package execution.state;

import ast.AST;
import ast.attr.OpsASTAttr;
import ast.enums.Operator;
import execution.ExecutionResult;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.types.Value;

import java.util.List;

public abstract class GuardedGeneratorState
extends GeneratorState
{
    private Value localResult;

    public GuardedGeneratorState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    protected abstract Value interpretResult(Operator op, Value current, Value next);

    @Override
    public void assign(ExecutionResult executionResult)
    {
        Value value = executionResult.getValue();
        if (step == 1)
        {
            localResult = value;
        }
        else
        {
            OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
            localResult = interpretResult(attr.getOp(step - 2), localResult, value);
        }
    }

    @Override
    public Value getFinalResult() {
        return localResult;
    }

    protected Value getLocalResult()
    {
        return localResult;
    }

    protected GuardedGeneratorState decorate(GuardedGeneratorState copy, SplitMapper sm)
    {
        if (localResult != null)
            copy.localResult = localResult.weakClone(sm.getLocationMapper());
        return (GuardedGeneratorState) super.decorate(copy, sm);
    }

}
