package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.DoWhileVisitorIface;

public class DoWhileAST
extends StmtAST
{

    public DoWhileAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getStatement()
    {
        return super.getChild(0);
    }

    public AST getCondition()
    {
        return super.getChild(1);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof DoWhileVisitorIface)
            return ((DoWhileVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "do\n" + this.getStatement().toString() + "while (" + this.getCondition().toString() + ");\n";
    }
}