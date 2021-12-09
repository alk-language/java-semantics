package ast.stmt;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.HavocVisitorIface;

import java.util.stream.Collectors;

public class HavocAST
extends StmtAST
{
    public HavocAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof HavocVisitorIface)
            return ((HavocVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        String chld = this.getChildren().stream().map(Object::toString).collect(Collectors.joining(", "));
        return "havoc " + chld + ";\n";
    }
}
