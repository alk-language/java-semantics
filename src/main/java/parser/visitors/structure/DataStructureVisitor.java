package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.ComponentDefinitionState;
import execution.state.structure.FilterSpecDefinitionState;
import execution.state.structure.IntervalDefinitionState;
import execution.state.structure.SelectSpecDefinitionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;
import util.types.ComponentValue;

public class DataStructureVisitor extends alkBaseVisitor
{
    protected Environment env;

    public Environment getEnvironment() {
        return env;
    }

    public DataStructureVisitor(Environment env) {
        this.env = env;
    }

    public ExecutionState visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx) {
        return new IntervalDefinitionState(ctx, this);
    }

    public ExecutionState visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx)
    {
        return new SelectSpecDefinitionState(ctx, this);
    }

    public ExecutionState visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx) {
        return new FilterSpecDefinitionState(ctx, this);
    }

    public ExecutionState visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        return new ComponentDefinitionState(ctx, this);
    }

}
