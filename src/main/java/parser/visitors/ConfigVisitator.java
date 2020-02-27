package parser.visitors;

import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import execution.types.AlkValue;
import parser.visitors.expression.ExpressionVisitor;

public class ConfigVisitator extends alkBaseVisitor {

    public Environment env;

    public ConfigVisitator(Environment env)
    {
        this.env = env;
    }

    @Override public Object visitConfig(alkParser.ConfigContext ctx) {
        int size = ctx.variable().size();
        for (int i=0; i<size; i++)
            visit(ctx.variable(i));
        return null;
    }

    @Override public Object visitVar(alkParser.VarContext ctx) {

        String name = ctx.ID().getText();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
        AlkValue value = (AlkValue) expressionVisitor.visit(ctx.expression());
        env.update(name, value);
        return null;
    }


}
