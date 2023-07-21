package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.RepresentationASTAttr;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.SetDataTypeAST;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.SetVisitorIface;

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
        if (this.getChildCount() > 0 &&
            this.getAttribute(RepresentationASTAttr.class).getRepresentation() == CompoundValueRepresentation.EMPTY)
        {
            dataTypeAST.addChild(this.getChild(0));
            return dataTypeAST;
        }

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
