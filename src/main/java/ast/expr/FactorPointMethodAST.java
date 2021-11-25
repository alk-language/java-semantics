package ast.expr;

import ast.attr.BuiltInMethodASTAttr;
import ast.type.*;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.FactorPointMethodVisitorIface;

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
            case POPFRONT:
            case PUSHFRONT:
            case INSERT:
            case POPBACK:
            case REMOVEAT:
            case REMOVEALLEQTO:
            case UPDATE:
            case PUSHBACK: return ((ExpressionAST) getChild(0)).getDataType(dtp);
            case TOPBACK:
            case TOPFRONT:
            case AT:
            {
                DataTypeAST target = ((ExpressionAST) getChild(0)).getDataType(dtp);
                if (target instanceof IterableDataTypeAST)
                    return ((IterableDataTypeAST) target).getTypeAst();
                else
                    throw new AlkException("Invalid use of at method on " + target);
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
