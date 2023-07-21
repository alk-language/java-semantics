package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.HavocVisitorIface;

import java.util.stream.Collectors;

public class HavocAST
extends StmtAST
{
    public HavocAST(ASTContext ctx)
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
        String decls = children.stream()
                               .map(Object::toString)
                               .collect(Collectors.joining(", "));
        return "@havoc " + decls + ";" + System.lineSeparator();
    }
}
