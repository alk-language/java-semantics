package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import execution.types.alkArray.AlkArray;
import util.Payload;

public class ArrayVisitor extends DataStructureVisitor {

    public ArrayVisitor(Environment env, Payload payload) {
        super(env, payload);
    }

    @Override
    public ExecutionState visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
    {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, payload, ctx.expression(), AlkArray.class, env);
    }

    @Override
    public ExecutionState visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
    {
        return StateFactory.create(IterableWithIntervalState.class, ctx, payload, ctx.interval(), AlkArray.class, env);
    }

    @Override
    public ExecutionState visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx)
    {
        return StateFactory.create(IterableWithSpecState.class, ctx, payload, ctx.spec(), AlkArray.class, env);
    }
}
