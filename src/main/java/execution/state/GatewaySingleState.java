package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Payload;
import util.SplitMapper;
import util.types.Value;

public abstract class GatewaySingleState extends SingleState {

    public GatewaySingleState(ParseTree tree,
                                  Payload payload,
                                  ParseTree dependency,
                                  Class<? extends alkBaseVisitor> visitor) {
        super(tree, payload, dependency, visitor);
    }

    @Override
    protected Value interpretResult(Value value)
    {
        return value;
    }

    protected GatewaySingleState decorate(GatewaySingleState copy, SplitMapper sm)
    {
        return (GatewaySingleState) super.decorate(copy, sm);
    }
}
