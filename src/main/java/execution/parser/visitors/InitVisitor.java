package execution.parser.visitors;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.init.InitState;
import execution.state.init.VarSeqState;
import execution.state.init.VarState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.ExecutionPayload;

public class InitVisitor extends alkBaseVisitor<ExecutionState>  {

    public Environment env;
    private ExecutionPayload executionPayload;

    public InitVisitor(Environment env, ExecutionPayload executionPayload)
    {
        this.env = env;
        this.executionPayload = executionPayload;
    }

    @Override public ExecutionState visitConfig(alkParser.ConfigContext ctx)
    {
        return StateFactory.create(InitState.class, ctx, executionPayload, env);
    }

    @Override public ExecutionState visitVarSeq(alkParser.VarSeqContext ctx)
    {
        return StateFactory.create(VarSeqState.class, ctx, executionPayload, env);
    }

    @Override public ExecutionState visitVar(alkParser.VarContext ctx)
    {
        return StateFactory.create(VarState.class, ctx, executionPayload, env);
    }
}
