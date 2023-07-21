package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.enums.Operator;

public abstract class ExpressionAST
extends AST
{
    public ExpressionAST(ASTContext ctx)
    {
        super(ctx);
    }

    public abstract DataTypeAST getDataType(DataTypeProvider dtp);

    public void check(DataTypeProvider dtp)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            getChild(i).check(dtp);
        }
    }


    protected void addOpsASTAttr(Operator op)
    {
        if (!this.hasAttribute(OpsASTAttr.class))
        {
            this.addAttribute(OpsASTAttr.class, new OpsASTAttr());
        }
        OpsASTAttr attr = this.getAttribute(OpsASTAttr.class);
        attr.add(op);
    }

    @Override
    public ExpressionAST getChild(int idx)
    {
        return (ExpressionAST) super.getChild(idx);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        for (int i = 0; i < getChildCount(); i++)
        {
            sb.append(getChild(i).toString());
            if (i < getChildCount() - 1)
                sb.append(" ").append(attr.getOp(i).getSyntax()).append(" ");
        }
        return "(" + sb + ")";
    }

}
