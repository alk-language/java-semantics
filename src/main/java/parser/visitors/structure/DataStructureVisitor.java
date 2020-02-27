package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.structure.*;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import util.Payload;

public class DataStructureVisitor extends alkBaseVisitor
{
    protected Environment env;

    protected Payload payload;

    public Environment getEnvironment() {
        return env;
    }

    public DataStructureVisitor(Environment env, Payload payload) {
        this.env = env;
        this.payload = payload;
    }

    public ExecutionState visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        return StateFactory.create(IntervalDefinitionState.class, ctx, payload, env);
    }

    public ExecutionState visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx)
    {
        return StateFactory.create(SelectSpecDefinitionState.class, ctx, payload, env);
    }

    public ExecutionState visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx) {
        return StateFactory.create(FilterSpecDefinitionState.class, ctx, payload, env);
    }

    public ExecutionState visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        return StateFactory.create(ComponentDefinitionState.class, ctx, payload, env);
    }

}
