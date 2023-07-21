package ro.uaic.info.alk.ast.symbolic;

import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.symbolic.SelectVisitorIface;

public class SelectAST
   extends ExpressionAST
{
    private static final boolean EXPLICIT_STRING = false;

    public SelectAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SelectVisitorIface)
            return ((SelectVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST subData = ((ExpressionAST) getChild(0)).getDataType(dtp);
        if (subData instanceof ArrayDataTypeAST)
        {
            ArrayDataTypeAST arrayDT = (ArrayDataTypeAST) subData;
            return arrayDT.getTypeAst();
        }
        else if (subData instanceof ListDataTypeAST)
        {
            ListDataTypeAST arrayDT = (ListDataTypeAST) subData;
            return arrayDT.getTypeAst();
        }
        else if (subData instanceof SetDataTypeAST)
        {
            return new BoolDataTypeAST(null);
        }
        else throw new AlkException("Can't identify the data type of: " + this);
    }

    @Override
    public String toString()
    {
        if (EXPLICIT_STRING)
            return "(select " + super.getChild(0) + " " + super.getChild(1) + ")";
        return super.getChild(0) + "[" + super.getChild(1) + "]";
    }
}
