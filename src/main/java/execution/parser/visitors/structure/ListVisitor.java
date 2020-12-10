package execution.parser.visitors.structure;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.structure.EmptyListState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.types.alkList.AlkList;
import execution.ExecutionPayload;

public class ListVisitor extends DataStructureVisitor {

    public ListVisitor(Environment env, ExecutionPayload executionPayload) {
        super(env, executionPayload);
    }

    public ExecutionState visitListWithExpressions(alkParser.ListWithExpressionsContext ctx) {
        return StateFactory.create(IterableWithExpressionsState.class, ctx, executionPayload, ctx.expression(), AlkList.class, env);
    }

    public ExecutionState visitEmptyList(alkParser.EmptyListContext ctx) {
        return StateFactory.create(EmptyListState.class, ctx, executionPayload, env);
    }


    public ExecutionState visitListWithInterval(alkParser.ListWithIntervalContext ctx) {
        return StateFactory.create(IterableWithIntervalState.class, ctx, executionPayload, ctx.interval(), AlkList.class, env);
    }


    public ExecutionState visitListWithSpec(alkParser.ListWithSpecContext ctx) {
        return StateFactory.create(IterableWithSpecState.class, ctx, executionPayload, ctx.spec(), AlkList.class, env);
    }


}
