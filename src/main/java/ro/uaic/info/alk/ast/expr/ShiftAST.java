package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.ShiftVisitorIface;

import java.util.List;

public class ShiftAST
extends ExpressionAST
{
    public ShiftAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static ShiftAST createBinary(Operator op, List<AST> children)
    {
        ShiftAST ast = new ShiftAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }
    @Override
    public String toString()
    {
        return ExpressionAST.getBinaryOperationString(this);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST chld = ((ExpressionAST) getChild(0)).getDataType(dtp);
        if (chld instanceof IntDataTypeAST)
        {
            return chld;
        }
        throw new AlkException("Invalid data type for unary expression: " + chld);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ShiftVisitorIface)
            return ((ShiftVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
