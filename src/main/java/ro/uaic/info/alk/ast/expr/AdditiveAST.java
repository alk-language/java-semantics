package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.AdditiveVisitorIface;

import java.util.List;

public class AdditiveAST
extends ExpressionAST
{
    public AdditiveAST(ASTContext ctx, Operator op, List<AST> children)
    {
        super(ctx);
        children.forEach(this::addChild);
        this.addOpsASTAttr(op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST ans = null;
        for (int i = 0; i < getChildCount(); i++)
        {
            DataTypeAST dt = getChild(i).getDataType(dtp);
            if (ans == null)
            {
                ans = dt;
                continue;
            }

            if (dt instanceof IntDataTypeAST)
            {
                if (ans instanceof FloatDataTypeAST)
                {
                    ans = FloatDataTypeAST.getInstance();
                    continue;
                }
                else if (ans instanceof IntDataTypeAST)
                {
                    continue;
                }
            }
            else if (dt instanceof FloatDataTypeAST)
            {
                if (ans instanceof IntDataTypeAST || ans instanceof FloatDataTypeAST)
                {
                    continue;
                }
            }
            else if (dt instanceof StringDataTypeAST)
            {
                if (ans instanceof StringDataTypeAST)
                {
                    continue;
                }
            }
            else if (dt instanceof ArrayDataTypeAST)
            {
                if (ans instanceof ArrayDataTypeAST &&
                   !((ArrayDataTypeAST) ans).getTypeAst().equals(((ArrayDataTypeAST) dt).getTypeAst()))
                    continue;
            }
            else if (dt instanceof ListDataTypeAST)
            {
                if (ans instanceof ListDataTypeAST &&
                   !((ListDataTypeAST) dt).getTypeAst().equals(((ListDataTypeAST) ans).getTypeAst()))
                    continue;
            }

            throw new InvalidOperationException(Operator.ADD, this);
        }

        if (ans == null)
        {
            throw new InvalidOperationException(Operator.ADD, this);
        }

        return ans;
    }

    @Override
    public void check(DataTypeProvider dtp)
    {
        super.check(dtp);

        getDataType(dtp);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AdditiveVisitorIface)
            return ((AdditiveVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
