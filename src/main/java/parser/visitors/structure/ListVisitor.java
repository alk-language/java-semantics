package parser.visitors.structure;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import parser.types.alkList.AlkList;

public class ListVisitor extends DataStructureVisitor {

    public ListVisitor(Environment env) {
        super(env);
    }

    public ExecutionState visitListWithExpressions(alkParser.ListWithExpressionsContext ctx) {
        return new IterableWithExpressionsState(ctx, env, ctx.expression(), AlkList.class);
    }

    public ExecutionState visitEmptyList(alkParser.EmptyListContext ctx) {
        return new ExecutionState(ctx, this) {
            @Override
            public ExecutionState makeStep() {
                result = new ExecutionResult<>(new AlkList());
                return null;
            }

            @Override
            public void assign(ExecutionResult result) {
                // no-op
            }
        };
    }


    public ExecutionState visitListWithInterval(alkParser.ListWithIntervalContext ctx) {
        return new IterableWithIntervalState(ctx, payload, ctx.interval(), AlkList.class);
    }


    public ExecutionState visitListWithSpec(alkParser.ListWithSpecContext ctx) {
        return new IterableWithSpecState(ctx, payload, ctx.spec(), AlkList.class);
    }


}
