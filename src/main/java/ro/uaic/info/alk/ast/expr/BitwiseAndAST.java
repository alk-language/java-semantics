package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.BitwiseAndVisitorIface;

import java.util.List;

public class BitwiseAndAST
extends ExpressionAST
{
    public BitwiseAndAST(ASTContext ctx, Operator op, List<AST> children)
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
                Storable op = new SymbolicValue(getChild(i));
                throw new InvalidOperationException(Operator.BITWISE_AND, op);
            }
        }
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BitwiseAndVisitorIface)
            return ((BitwiseAndVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
