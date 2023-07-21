package ro.uaic.info.alk.ast.symbolic;

import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.stmt.StmtAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.IdDeclVisitorIface;

public class IdDeclAST
   extends StmtAST
{
    public IdDeclAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof IdDeclVisitorIface)
            return ((IdDeclVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr idAttr = getAttribute(IdASTAttr.class);
        return idAttr.getId() + " : " + getChild(0).toString();
    }
}
