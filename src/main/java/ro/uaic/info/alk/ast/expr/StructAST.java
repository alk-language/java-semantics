package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.StructVisitorIface;

public class StructAST
extends ExpressionAST
{

    public StructAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        throw new InternalException("Can't detect data type for structures.");
    }

    @Override
    public String toString()
    {
        return "{" + AST.getSV(this, " ") + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof StructVisitorIface)
            return ((StructVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
