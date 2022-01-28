package ast.expr;

import ast.AST;
import ast.type.BoolDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.InExprVisitorIface;

import java.util.List;

public class InExprAST
extends ExpressionAST
{
    public InExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(ctx);
    }

    public static InExprAST createBinary(Operator op, List<AST> children)
    {
        InExprAST ast = new InExprAST(null);
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
        if (visitor instanceof InExprVisitorIface)
            return ((InExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
