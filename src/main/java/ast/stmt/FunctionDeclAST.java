package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.FunctionDeclVisitorIface;

public class FunctionDeclAST
extends StmtAST
{

    public FunctionDeclAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FunctionDeclVisitorIface)
            return ((FunctionDeclVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "function declaration";
    }
}
