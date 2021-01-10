package ast;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.Operator;
import visitor.VisitorIface;
import visitor.ifaces.expr.LogicalOrVisitorIface;

import java.util.List;

public class LogicalOrAST
extends AST
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
        return AST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof LogicalOrVisitorIface)
            return ((LogicalOrVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
