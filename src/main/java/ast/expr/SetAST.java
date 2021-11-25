package ast.expr;

import ast.AST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import ast.type.SetDataTypeAST;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.SetVisitorIface;

public class SetAST
extends ExpressionAST
{
    public SetAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public SetDataTypeAST getDataType(DataTypeProvider dtp)
    {
        SetDataTypeAST dataTypeAST = new SetDataTypeAST(null);
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
                throw new AlkException("Can't classify this as a homogeneous set: " + this);
            }
        }
        if (root == null)
        {
            throw new AlkException("Can't identify the data type of the following set: " + this);
        }
        dataTypeAST.addChild(root);
        return dataTypeAST;
    }

    @Override
    public String toString()
    {
        return "{" + AST.getCSV(this) + "}";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SetVisitorIface)
            return ((SetVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
