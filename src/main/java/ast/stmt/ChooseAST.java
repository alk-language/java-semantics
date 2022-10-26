package ast.stmt;

import ast.AST;
import ast.attr.IdASTAttr;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.ChooseVisitorIface;

public class ChooseAST
extends StmtAST
implements BreakableStmtAST
{

    public ChooseAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getSource()
    {
        return super.getChild(0);
    }

    public AST getSuchThat()
    {
        return super.getChild(1);
    }

    public boolean hasSuchThat()
    {
        return super.getChildCount() == 2;
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof ChooseVisitorIface)
            return ((ChooseVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        IdASTAttr attr = super.getAttribute(IdASTAttr.class);
        String s = "choose " + attr.getId() + " from " + getSource().toString();
        if (hasSuchThat())
        {
            s += " s.t. " + getSuchThat().toString() + ";\n";
        }
        return s;
    }
}
