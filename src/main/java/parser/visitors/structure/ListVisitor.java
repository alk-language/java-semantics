package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.PrimitiveState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import execution.types.alkList.AlkList;
import util.Payload;

public class ListVisitor extends DataStructureVisitor {

    public ListVisitor(Environment env, Payload payload) {
        super(env, payload);
    }

    public ExecutionState visitListWithExpressions(alkParser.ListWithExpressionsContext ctx) {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, payload, ctx.expression(), AlkList.class, env);
    }

    public ExecutionState visitEmptyList(alkParser.EmptyListContext ctx) {
        return StateFactory.create(PrimitiveState.class, ctx, payload, new AlkList(), env);
    }


    public ExecutionState visitListWithInterval(alkParser.ListWithIntervalContext ctx) {
        return StateFactory.create(IterableWithIntervalState.class, ctx, payload, ctx.interval(), AlkList.class, env);
    }


    public ExecutionState visitListWithSpec(alkParser.ListWithSpecContext ctx) {
        return StateFactory.create(IterableWithSpecState.class, ctx, payload, ctx.spec(), AlkList.class, env);
    }


}
