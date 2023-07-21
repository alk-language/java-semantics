package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.BitwiseOrVisitorIface;

import java.util.List;

public class BitwiseOrAST
extends ExpressionAST
{
    public BitwiseOrAST(ASTContext ctx, Operator op, List<AST> children)
    {
        super(ctx);
        children.forEach(this::addChild);
        addOpsASTAttr(op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        check(dtp);
        return IntDataTypeAST.getInstance();
    }

    @Override
    public void check(DataTypeProvider dtp)
    {
        super.check(dtp);

        for (int i = 0; i < getChildCount(); i++)
        {
            DataTypeAST dt = getChild(i).getDataType(dtp);
            if (!(dt instanceof IntDataTypeAST))
            {
                throw new InvalidOperationException(Operator.BITWISE_OR, this);
            }
        }
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BitwiseOrVisitorIface)
            return ((BitwiseOrVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
