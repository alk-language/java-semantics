package ast.type;

import ast.AST;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.expr.DataTypeVisitorIface;

public abstract class DataTypeAST
extends AST
{
    public DataTypeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public abstract Expr<?> makeExpr(Context ctx, String id);
    public abstract Sort getSort(Context ctx);

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof DataTypeAST))
            return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof DataTypeVisitorIface)
            return ((DataTypeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
