package ast.expr.fol;

import ast.AST;
import ast.expr.ExpressionAST;
import ast.type.BoolDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ForAllVisitorIface;

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
        return getChild(0);
    }

    @Override
    public String toString()
    {
        StringBuilder varDecl = new StringBuilder();
        for (int i = 1; i < getChildCount(); i++)
        {
            if (i != 1) varDecl.append(", ");
            varDecl.append(getChild(i).toString());
        }
        return "forall " + varDecl.toString() + " :: " + getExpr();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ForAllVisitorIface)
            return ((ForAllVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
