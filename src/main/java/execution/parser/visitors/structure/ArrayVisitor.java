package execution.parser.visitors.structure;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.types.alkArray.AlkArray;
import execution.ExecutionPayload;

public class ArrayVisitor extends DataStructureVisitor {

    public ArrayVisitor(Environment env, ExecutionPayload executionPayload) {
        super(env, executionPayload);
    }

    @Override
    public ExecutionState visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
    {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, executionPayload, ctx.expression(), AlkArray.class, env);
    }

    @Override
    public ExecutionState visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
    {
        return StateFactory.create(IterableWithIntervalState.class, ctx, executionPayload, ctx.interval(), AlkArray.class, env);
    }

    @Override
    public ExecutionState visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx)
    {
        return StateFactory.create(IterableWithSpecState.class, ctx, executionPayload, ctx.spec(), AlkArray.class, env);
    }
}
