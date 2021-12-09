package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.StringVisitorIface;

public class StringAST
extends ExpressionAST
{
    public StringAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type of strings");
    }

    public StringAST(String text)
    {
        super(null);
        super.text = text;
    }

    @Override
    public String toString()
    {
        return "\"" + getText() + "\"";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StringVisitorIface)
            return ((StringVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
