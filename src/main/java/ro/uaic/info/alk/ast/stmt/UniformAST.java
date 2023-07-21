package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.UniformVisitorIface;

public class UniformAST
extends StmtAST
implements BreakableStmtAST
{

    public UniformAST(ASTContext ctx)
    {
        super(ctx);
    }

    public AST getTarget()
    {
        return getChild(0);
    }

    public AST getSource()
    {
        return getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof UniformVisitorIface)
            return ((UniformVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "uniform  " + getTarget() + " from " + getSource() + ";" + System.lineSeparator();
    }
}
