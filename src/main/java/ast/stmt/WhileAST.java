package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.BlockVisitorIface;
import visitor.ifaces.stmt.WhileVisitorIface;

import java.util.ArrayList;
import java.util.List;

public class WhileAST
extends StmtAST
{
    private boolean loopAssert = false;

    public WhileAST(ParserRuleContext ctx, boolean loopAssert)
    {
        super(ctx);
        this.loopAssert = loopAssert;
    }

    public boolean hasLoopAssert()
    {
        return loopAssert;
    }

    public AST getLoopAssert()
    {
        return getChild(getChildCount() - 1).getChild(0);
    }

    public AST getCondition()
    {
        return super.getChild(0);
    }

    public AST getStatement()
    {
        return loopAssert ? super.getChild(getChildCount() - 2) : super.getChild(getChildCount() - 1) ;
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof WhileVisitorIface)
            return ((WhileVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return "while (" + this.getCondition().toString() + ")\n" + this.getStatement().toString();
    }

    public List<AST> getInvariants()
    {
        List<AST> invs = new ArrayList<>();
        for (int i = 1; i < (loopAssert ? getChildCount() - 2 : getChildCount() - 1); i++)
        {
            invs.add(getChild(i));
        }
        return invs;
    }
}