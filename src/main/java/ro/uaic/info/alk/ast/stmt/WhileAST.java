package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.WhileVisitorIface;

import java.util.ArrayList;
import java.util.List;

public class WhileAST
extends StmtAST
implements BreakableStmtAST,
           ConditionalStmtAST
{
    private final boolean loopAssert;

    public WhileAST(ASTContext ctx, boolean loopAssert)
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

    @Override
    public String getConditionalStmt()
    {
        return "while " + this.getCondition().toString() + "";
    }
}