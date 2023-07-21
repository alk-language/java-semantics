package ro.uaic.info.alk.ast.type;

import ro.uaic.info.alk.ast.AST;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Sort;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.DataTypeVisitorIface;

public abstract class DataTypeAST
extends AST
{
    public DataTypeAST(ASTContext ctx)
    {
        super(ctx);
    }

    public abstract Expr<?> makeExpr(Context ctx, String id);

    public abstract Sort getSort(Context ctx);

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof DataTypeAST)) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof DataTypeVisitorIface)
            return ((DataTypeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
