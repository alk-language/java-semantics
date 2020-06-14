package parser.visitors;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.init.InitState;
import execution.state.init.VarSeqState;
import execution.state.init.VarState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import parser.env.EnvironmentImpl;
import util.Payload;

public class InitVisitor extends alkBaseVisitor<ExecutionState>  {

    public Environment env;
    private Payload payload;

    public InitVisitor(Environment env, Payload payload)
    {
        this.env = env;
        this.payload = payload;
    }

    @Override public ExecutionState visitConfig(alkParser.ConfigContext ctx)
    {
        return StateFactory.create(InitState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitVarSeq(alkParser.VarSeqContext ctx)
    {
        return StateFactory.create(VarSeqState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitVar(alkParser.VarContext ctx)
    {
        return StateFactory.create(VarState.class, ctx, payload, env);
    }
}
