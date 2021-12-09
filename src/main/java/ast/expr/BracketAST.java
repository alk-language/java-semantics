package ast.expr;

import ast.AST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import util.exception.InternalException;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.BracketVisitorIface;

import java.util.List;

public class BracketAST
extends ExpressionAST
{
    public BracketAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST dataTypeAST = ((ExpressionAST) getChild(0)).getDataType(dtp);
        if (dataTypeAST instanceof ArrayDataTypeAST)
        {
            ArrayDataTypeAST arrayDataTypeAST = (ArrayDataTypeAST) dataTypeAST;
            return arrayDataTypeAST.getTypeAst();
        }
        throw new InternalException("Can't retrieve data type of a bracket expr which is not over an array.");
    }

    public static BracketAST createBinary(Operator op, List<AST> children)
    {
        BracketAST ast = new BracketAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        return super.getChild(0).toString() + "[" + super.getChild(1) + "]";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BracketVisitorIface)
            return ((BracketVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
