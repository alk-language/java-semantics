package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import ast.type.SetDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.SetExprVisitorIface;

import java.util.List;

public class SetExprAST
extends ExpressionAST
{
    public SetExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static SetExprAST createBinary(Operator op, List<AST> children)
    {
        SetExprAST ast = new SetExprAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new SetDataTypeAST(null);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SetExprVisitorIface)
            return ((SetExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
