package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.EqualityVisitorIface;

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
        return ExpressionAST.getBinaryOperationString(this);
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
