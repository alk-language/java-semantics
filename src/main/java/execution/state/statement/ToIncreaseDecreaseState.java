package execution.state.statement;

import execution.state.ExecutionState;
import execution.state.IndependentSingleState;
import grammar.alkParser;
import parser.visitors.StmtVisitor;
import util.CtxState;
import util.Payload;

@CtxState(ctxClass = alkParser.ToIncreaseDecreaseContext.class)
public class ToIncreaseDecreaseState extends IndependentSingleState
{
    public ToIncreaseDecreaseState(alkParser.ToIncreaseDecreaseContext tree, Payload payload)
    {
        super(tree, payload, tree.increase_decrease(), StmtVisitor.class);
    }

    @Override
    public ExecutionState clone(Payload payload)
    {
        return null;
    }
}
