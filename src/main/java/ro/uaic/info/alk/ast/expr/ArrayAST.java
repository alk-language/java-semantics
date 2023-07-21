package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.RepresentationASTAttr;
import ro.uaic.info.alk.ast.type.ArrayDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ArrayVisitorIface;

public class ArrayAST
extends CompoundTypeAST
{
    public ArrayAST(CompoundValueRepresentation representation)
    {
        this((ASTContext) null);
        addAttribute(RepresentationASTAttr.class, new RepresentationASTAttr(representation));
    }

    public ArrayAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public ArrayDataTypeAST getDataType(DataTypeProvider dtp)
    {
        ArrayDataTypeAST dataTypeAST = new ArrayDataTypeAST();
        DataTypeAST root = null;

        for (int i = 0; i < getChildCount(); i++)
        {
            ExpressionAST child = getChild(i);
            if (child instanceof UnknownAST)
            {
                continue;
            }

            DataTypeAST dt = child.getDataType(dtp);

            if (root == null)
            {
                root = dt;
                continue;
            }

            if (!root.equals(dt))
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
    public void check(DataTypeProvider dtp)
    {
        super.check(dtp);

        getDataType(dtp);
    }

    @Override
    public String toString()
    {
        return "[" + getCSV() + "]";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ArrayVisitorIface)
            return ((ArrayVisitorIface<T>) visitor).visit(this);
        return super.accept(visitor);
    }
}
