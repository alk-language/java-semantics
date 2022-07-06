package ast.expr;

import ast.AST;
import ast.type.*;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.EqualityVisitorIface;

import java.util.List;

public class EqualityAST
extends ExpressionAST
{
    public static EqualityAST createBinary(Operator op, List<AST> children)
    {
        EqualityAST ast = new EqualityAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    public EqualityAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(null);
    }

    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof EqualityVisitorIface)
            return ((EqualityVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    public boolean isForArray(DataTypeProvider dtp)
    {
        return isArray((ExpressionAST) getChild(0), dtp) && isArray((ExpressionAST) getChild(1), dtp);
    }

    private boolean isArray(ExpressionAST ast, DataTypeProvider dtp)
    {
        return ast.getDataType(dtp) instanceof ArrayDataTypeAST || ast.getDataType(dtp) instanceof ListDataTypeAST;
    }

}
