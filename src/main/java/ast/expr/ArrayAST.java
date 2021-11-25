package ast.expr;

import ast.AST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.ArrayVisitorIface;

public class ArrayAST
extends ExpressionAST
{
    public ArrayAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public ArrayDataTypeAST getDataType(DataTypeProvider dtp)
    {
        ArrayDataTypeAST dataTypeAST = new ArrayDataTypeAST(null);
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
                throw new AlkException("Can't classify this as a homogeneous array: " + this);
            }
        }
        if (root == null)
        {
            throw new AlkException("Can't identify the data type of the following array: " + this);
        }
        dataTypeAST.addChild(root);
        return dataTypeAST;
    }

    @Override
    public String toString()
    {
        return "[" + AST.getCSV(this) + "]";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ArrayVisitorIface)
            return ((ArrayVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
