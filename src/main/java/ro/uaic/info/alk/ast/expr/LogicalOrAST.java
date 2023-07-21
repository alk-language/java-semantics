package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.LogicalOrVisitorIface;

import java.util.List;

public class LogicalOrAST
extends ExpressionAST
{
    public LogicalOrAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static LogicalOrAST createBinary(Operator op, List<AST> children)
    {
        LogicalOrAST ast = new LogicalOrAST(null);
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
        return new BoolDataTypeAST(null);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof LogicalOrVisitorIface)
            return ((LogicalOrVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
