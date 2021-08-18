package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.AssumeVisitorIface;

public class AssumeAST
extends StmtAST
{
    public AssumeAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AssumeVisitorIface)
            return ((AssumeVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "assume " + getChild(0).toString() + ";\n";
    }
}