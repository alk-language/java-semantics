package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.IterableWithExpressionsState;
import execution.state.structure.IterableWithIntervalState;
import execution.state.structure.IterableWithSpecState;
import grammar.alkParser;
import parser.env.Environment;
import parser.types.alkArray.AlkArray;

public class ArrayVisitor extends DataStructureVisitor {

    public ArrayVisitor(Environment env) {
        super(env);
    }

    @Override
    public ExecutionState visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
    {
        return new IterableWithExpressionsState(ctx, env, ctx.expression(), AlkArray.class);
    }


    @Override
    public ExecutionState visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
    {
        return new IterableWithIntervalState(ctx, this, ctx.interval(), AlkArray.class);
    }

    @Override
    public ExecutionState visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx)
    {
        return new IterableWithSpecState(ctx, this, ctx.spec(), AlkArray.class);
    }
}
