package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ForAllVisitorIface;

public class ForAllExprAST
   extends ExpressionAST
{

    public ForAllExprAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(ctx);
    }

    public AST getExpr()
    {
        return getChild(getChildCount() - 1);
    }

    @Override
    public String toString()
    {
        StringBuilder varDecl = new StringBuilder();
        for (int i = 0; i < getChildCount() - 1; i++)
        {
            if (i != 1) varDecl.append(", ");
            varDecl.append(getChild(i).toString());
        }
        return "forall " + varDecl + " :: " + getExpr();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ForAllVisitorIface)
            return ((ForAllVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
