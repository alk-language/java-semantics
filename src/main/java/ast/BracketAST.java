package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.BracketVisitorIface;

import java.util.List;

public class BracketAST
extends AST
{
    public BracketAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static BracketAST createBinary(Operator op, List<AST> children)
    {
        BracketAST ast = new BracketAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        return super.getChild(0).toString() + "[" + super.getChild(1) + "]";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BracketVisitorIface)
            return ((BracketVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
