package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.expression.PrimitiveState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import parser.types.alkSet.AlkSet;

public class SetVisitor extends DataStructureVisitor
{
    public SetVisitor(Environment env) {
        super(env);
    }

    public ExecutionState visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx) {
        return new IterableWithExpressionsState(ctx, env, ctx.expression(), AlkSet.class);
    }

    public ExecutionState visitEmptySet(alkParser.EmptySetContext ctx) {
        return new PrimitiveState(ctx, this, new AlkSet());
    }

    public ExecutionState visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        return new IterableWithIntervalState(ctx, payload, ctx.interval(), AlkSet.class);
    }

    public ExecutionState visitSetWithSpec(alkParser.SetWithSpecContext ctx) {
        return new IterableWithSpecState(ctx, payload, ctx.spec(), AlkSet.class);
    }
}
