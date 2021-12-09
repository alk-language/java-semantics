package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ListVisitorIface;

public class ListAST
extends ExpressionAST
{
    public ListAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type for lists!");
    }

    @Override
    public String toString()
    {
        return "< " + AST.getCSV(this) + " >";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ListVisitorIface)
            return ((ListVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
