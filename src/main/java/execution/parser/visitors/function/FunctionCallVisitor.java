package execution.parser.visitors.function;


import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.function.BuiltInFunctionState;
import execution.state.function.BuiltInMethodState;
import execution.state.function.DefinedFunctionCallState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.ExecutionPayload;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    private ExecutionPayload executionPayload;

    public FunctionCallVisitor(Environment env, ExecutionPayload executionPayload)
    {
        this.env = env;
        this.executionPayload = executionPayload;
    }

    public Environment getEnvironment()
    {
        return env;
    }

    @Override
    public ExecutionState visitBuiltinFunction(alkParser.BuiltinFunctionContext ctx)
    {
        return StateFactory.create(BuiltInFunctionState.class, ctx, executionPayload, env);
    }

    @Override
    public ExecutionState visitBuiltinMethod(alkParser.BuiltinMethodContext ctx)
    {
        return StateFactory.create(BuiltInMethodState.class, ctx, executionPayload, env);
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx)
    {
        return StateFactory.create(DefinedFunctionCallState.class, ctx, executionPayload, env);
    }
}