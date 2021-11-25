package ast.expr;

import ast.AST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import ast.type.FloatDataTypeAST;
import ast.type.IntDataTypeAST;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.MultiplicativeVisitorIface;

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
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof MultiplicativeVisitorIface)
            return ((MultiplicativeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

}
