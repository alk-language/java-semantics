package ro.uaic.info.alk.ast.symbolic;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.stmt.StmtAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.SymbolicDeclsVisitorIface;

public class SymbolicDeclsAST
   extends StmtAST
{
    public SymbolicDeclsAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof SymbolicDeclsVisitorIface)
            return ((SymbolicDeclsVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("@symbolic ");
        children.forEach((child) -> str.append(child.toString()));
        str.append(";").append(System.lineSeparator());
        return str.toString();
    }
}
