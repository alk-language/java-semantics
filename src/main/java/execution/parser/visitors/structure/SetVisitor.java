package execution.parser.visitors.structure;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.structure.EmptySetState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.types.alkSet.AlkSet;
import execution.ExecutionPayload;

public class SetVisitor extends DataStructureVisitor
{
    public SetVisitor(Environment env, ExecutionPayload executionPayload) {
        super(env, executionPayload);
    }

    public ExecutionState visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx) {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, executionPayload, ctx.expression(), AlkSet.class, env);
    }

    public ExecutionState visitEmptySet(alkParser.EmptySetContext ctx) {
        return StateFactory.create(EmptySetState.class, ctx, executionPayload, env);
    }

    public ExecutionState visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        return StateFactory.create(IterableWithIntervalState.class, ctx, executionPayload, ctx.interval(), AlkSet.class, env);
    }

    public ExecutionState visitSetWithSpec(alkParser.SetWithSpecContext ctx) {
        return StateFactory.create(IterableWithSpecState.class, ctx, executionPayload, ctx.spec(), AlkSet.class, env);
    }
}
