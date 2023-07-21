package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.SetExprVisitorIface;

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
        return ((ExpressionAST) getChild(0)).getDataType(dtp);
    }

    @Override
    public String toString()
    {
        return ExpressionAST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SetExprVisitorIface)
            return ((SetExprVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
