package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.type.ArrayDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.BracketVisitorIface;

import java.util.List;

public class BracketAST
extends ExpressionAST
{
    public BracketAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        DataTypeAST dataTypeAST = getChild(0).getDataType(dtp);
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
