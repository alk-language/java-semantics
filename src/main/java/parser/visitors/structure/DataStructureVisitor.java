package parser.visitors.structure;

import execution.state.ExecutionState;
import execution.state.structure.FilterSpecDefinitionState;
import execution.state.structure.IntervalDefinitionState;
import execution.state.structure.SelectSpecDefinitionState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.Pair;
import parser.env.Environment;
import parser.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

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

    public Pair visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
    {
        String comp = ctx.ID().toString();
        ExpressionVisitor expVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) expVisitor.visit(ctx.expression());
        return new Pair<>(comp, value);
    }

}
