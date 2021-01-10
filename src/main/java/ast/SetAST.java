package ast;

import ast.attr.OpsASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.SetVisitorIface;

import java.util.List;

public class SetAST
extends AST
{
    public SetAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public String toString()
    {
        return "{" + AST.getCSV(this) + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SetVisitorIface)
            return ((SetVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
