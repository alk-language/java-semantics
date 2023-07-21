package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.AssignmentVisitorIface;

public class AssignmentAST
extends ExpressionAST
{

    public AssignmentAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return getRightSide().getDataType(dtp);
    }

    public ExpressionAST getLeftSide()
    {
        return getChild(0);
    }

    public ExpressionAST getRightSide()
    {
        return getChild(1);
    }

    @Override
    public String toString()
    {
        return getLeftSide().toString() + " = " + getRightSide().toString();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AssignmentVisitorIface)
            return ((AssignmentVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
