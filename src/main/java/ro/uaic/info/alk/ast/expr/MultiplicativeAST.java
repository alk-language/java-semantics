package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.FloatDataTypeAST;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.MultiplicativeVisitorIface;

import java.util.List;

public class MultiplicativeAST
extends ExpressionAST
{
    public MultiplicativeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static MultiplicativeAST createBinary(Operator op, List<AST> children)
    {
        MultiplicativeAST ast = new MultiplicativeAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST ans = null;
        for (int i = 0; i < super.getChildCount(); i++)
        {
            DataTypeAST dt = ((ExpressionAST) getChild(i)).getDataType(dtp);
            if (dt instanceof FloatDataTypeAST)
                ans = new FloatDataTypeAST(null);
            else if (dt instanceof IntDataTypeAST && !(ans instanceof FloatDataTypeAST))
                ans = new IntDataTypeAST(null);
            else
                throw new AlkException("Incorrect data types for multiplicative expression!");
        }
        return ans;
    }

    @Override
    public String toString()
    {
        return ExpressionAST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof MultiplicativeVisitorIface)
            return ((MultiplicativeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
