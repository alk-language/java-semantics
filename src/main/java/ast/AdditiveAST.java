package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;

import java.util.List;

public class AdditiveAST
extends AST
{
    public AdditiveAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static AdditiveAST createBinary(Operator op, List<AST> children)
    {
        AdditiveAST ast = new AdditiveAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AdditiveVisitorIface)
            return ((AdditiveVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
