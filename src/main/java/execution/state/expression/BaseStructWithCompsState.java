package execution.state.expression;

import ast.AST;
import ast.attr.IdASTAttr;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.env.Location;
import execution.state.ExecutionState;
import execution.types.alkStructure.AlkStructure;
import util.Pair;

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
