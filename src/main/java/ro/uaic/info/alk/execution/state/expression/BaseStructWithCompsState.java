package ro.uaic.info.alk.execution.state.expression;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.types.AlkStructure;
import ro.uaic.info.alk.util.Pair;

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
        struct.put(new Pair<>(id, generator.generate(result.getValue().toRValue())));
    }

    @Override
    public ExecutionState clone(SplitMapper sm) {
        BaseStructWithCompsState copy = new BaseStructWithCompsState(tree, payload.clone(sm));
        copy.struct = (AlkStructure) this.struct.weakClone(sm.getLocationMapper());
        return super.decorate(copy, sm);
    }
}
