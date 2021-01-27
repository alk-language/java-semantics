package ast.stmt;

import ast.AST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.expr.AdditiveVisitorIface;
import visitor.ifaces.stmt.AssignmentVisitorIface;

public class AssignmentAST
extends StmtAST
{

    public AssignmentAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public AST getLeftSide()
    {
        return super.getChild(0);
    }

    public AST getRightSide()
    {
        return super.getChild(1);
    }

    @Override
    public String toString()
    {
        return getLeftSide().toString() + " = " + getRightSide().toString() + ";\n";
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof AssignmentVisitorIface)
            return ((AssignmentVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
