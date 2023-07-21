package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.ListDataTypeAST;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ListVisitorIface;

public class ListAST
extends ExpressionAST
{
    public ListAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public ListDataTypeAST getDataType(DataTypeProvider dtp)
    {
        ListDataTypeAST dataTypeAST = new ListDataTypeAST(null);
        DataTypeAST root = null;
        for (int i = 0; i < getChildCount(); i++)
        {
            if (getChild(i) instanceof UnknownAST) continue;
            DataTypeAST ast = ((ExpressionAST) getChild(i)).getDataType(dtp);

            if (root == null)
            {
                root = ast;
                continue;
            }

            if (!root.equals(ast))
            {
                throw new AlkException("Can't classify this as a homogeneous list: " + this);
            }
        }
        if (root == null)
        {
            throw new AlkException("Can't identify the data type of the following list: " + this);
        }
        dataTypeAST.addChild(root);
        return dataTypeAST;
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
