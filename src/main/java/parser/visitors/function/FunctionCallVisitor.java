package parser.visitors.function;


import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.function.BuiltInFunctionState;
import execution.state.function.BuiltInMethodState;
import execution.state.function.DefinedFunctionCallState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import parser.env.EnvironmentImpl;
import util.Payload;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    private Payload payload;

    public FunctionCallVisitor(Environment env, Payload payload)
    {
        this.env = env;
        this.payload = payload;
    }

    public Environment getEnvironment()
    {
        return env;
    }

    @Override
    public ExecutionState visitBuiltinFunction(alkParser.BuiltinFunctionContext ctx)
    {
        return StateFactory.create(BuiltInFunctionState.class, ctx, payload, env);
    }

    @Override
    public ExecutionState visitBuiltinMethod(alkParser.BuiltinMethodContext ctx)
    {
        return StateFactory.create(BuiltInMethodState.class, ctx, payload, env);
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx)
    {
        return StateFactory.create(DefinedFunctionCallState.class, ctx, payload, env);
    }
}