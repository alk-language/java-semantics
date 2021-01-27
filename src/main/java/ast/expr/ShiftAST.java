package ast.expr;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ShiftVisitorIface;

import java.util.List;

public class ShiftAST
extends ExpressionAST
{
    public ShiftAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static ShiftAST createBinary(Operator op, List<AST> children)
    {
        ShiftAST ast = new ShiftAST(null);
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
        if (visitor instanceof ShiftVisitorIface)
            return ((ShiftVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
