package ast.expr;

import ast.AST;
import ast.type.BoolDataType;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.Operator;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.LogicalAndVisitorIface;

import java.util.List;

public class LogicalAndAST
extends ExpressionAST
{
    public LogicalAndAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static LogicalAndAST createBinary(Operator op, List<AST> children)
    {
        LogicalAndAST ast = new LogicalAndAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataType(null);
    }
    
    @Override
    public String toString()
    {
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof LogicalAndVisitorIface)
            return ((LogicalAndVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
