package execution.state.expression;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.expr.ComponentAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.state.ExecutionState;
import execution.state.GeneratorState;
import execution.types.alkStructure.AlkStructure;
import util.types.ComponentValue;
import util.types.Value;

public class BaseStructWithCompsState
extends ExecutionState
{
    private AlkStructure struct = new AlkStructure();
    private int step = 0;
    private String id;

    public BaseStructWithCompsState(AST tree, ExecutionPayload executionPayload) {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (step == tree.getChildCount())
        {
            setResult(new ExecutionResult(generator.generate(struct)));
            return null;
        }

        AST compAST = tree.getChild(step++);
        id = compAST.getAttribute(IdASTAttr.class).getId();
        AST exprAST = compAST.getChild(0);
        return request(exprAST);
    }

    @Override
    public void assign(ExecutionResult result)
    {
        struct.insert(new ComponentValue(id, generator.generate(result.getValue().toRValue())));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BaseStructWithCompsState copy = new BaseStructWithCompsState(tree, payload.clone(sm));
        copy.struct = (AlkStructure) this.struct.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
