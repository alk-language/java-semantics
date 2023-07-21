package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.attr.BuiltInMethodASTAttr;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.FactorPointMethodVisitorIface;

public class FactorPointMethodAST
extends ExpressionAST
{
    public FactorPointMethodAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        BuiltInMethodASTAttr attr = this.getAttribute(BuiltInMethodASTAttr.class);
        switch (attr.getMethod())
        {
            case SIZE: return new IntDataTypeAST(ctx);
            case POP_FRONT:
            case PUSH_FRONT:
            case INSERT:
            case POP_BACK:
            case REMOVE_AT:
            case REMOVE_ALL_EQ_TO:
            case UPDATE:
            case PUSH_BACK: return ((ExpressionAST) getChild(0)).getDataType(dtp);
            case TOP_BACK:
            case TOP_FRONT:
            case AT:
            {
                DataTypeAST target = ((ExpressionAST) getChild(0)).getDataType(dtp);
                if (target instanceof IterableDataTypeAST)
                    return ((IterableDataTypeAST) target).getTypeAst();
                else
                    throw new AlkException("Invalid use of " + attr.getMethod() + " method on " + target);
            }
            case KEYS:
            {
                DataTypeAST target = ((ExpressionAST) getChild(0)).getDataType(dtp);
                if (target instanceof MapDataTypeAST)
                    return new SetDataTypeAST(null);
                else
                    throw new AlkException("Invalid use of keys method on " + target);
            }
            default: throw new InternalException("Unidentified builtin method in order to detect data type.");
        }
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FactorPointMethodVisitorIface)
            return ((FactorPointMethodVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(
                super.getChild(0) + "." + super.getAttribute(BuiltInMethodASTAttr.class).getMethod().toString().toLowerCase() + "(");
        for (int i = 1; i < super.getChildCount(); i++)
        {
            sb.append(super.getChild(i).toString());
            if (i < super.getChildCount() - 1)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
