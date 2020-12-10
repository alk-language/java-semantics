package execution.parser.visitors.structure;

import ast.StateFactory;
import execution.state.ExecutionState;
import execution.state.structure.*;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.ExecutionPayload;

public class DataStructureVisitor extends alkBaseVisitor
{
    protected Environment env;

    protected ExecutionPayload executionPayload;

    public Environment getEnvironment() {
        return env;
    }

    public DataStructureVisitor(Environment env, ExecutionPayload executionPayload) {
        this.env = env;
        this.executionPayload = executionPayload;
    }

    public ExecutionState visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        return StateFactory.create(IntervalDefinitionState.class, ctx, executionPayload, env);
    }

    public ExecutionState visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx)
    {
        return StateFactory.create(MapSpecDefinitionState.class, ctx, executionPayload, env);
    }

    public ExecutionState visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx) {
        return StateFactory.create(FilterSpecDefinitionState.class, ctx, executionPayload, env);
    }

    public ExecutionState visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        return StateFactory.create(ComponentDefinitionState.class, ctx, executionPayload, env);
    }

}
