package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.PrimitiveState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import parser.types.alkSet.AlkSet;
import util.Payload;

public class SetVisitor extends DataStructureVisitor
{
    public SetVisitor(Environment env, Payload payload) {
        super(env, payload);
    }

    public ExecutionState visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx) {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, payload, AlkSet.class, env);
    }

    public ExecutionState visitEmptySet(alkParser.EmptySetContext ctx) {
        return StateFactory.create(PrimitiveState.class, ctx, payload, new AlkSet(), env);
    }

    public ExecutionState visitSetWithInterval(alkParser.SetWithIntervalContext ctx) {
        return StateFactory.create(IterableWithIntervalState.class, ctx, payload, AlkSet.class, env);
    }

    public ExecutionState visitSetWithSpec(alkParser.SetWithSpecContext ctx) {
        return StateFactory.create(IterableWithSpecState.class, ctx, payload, AlkSet.class, env);
    }
}
