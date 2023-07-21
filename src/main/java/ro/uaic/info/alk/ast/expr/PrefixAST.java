package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.OperatorUtils;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.PrefixVisitorIface;

import java.util.List;

public class PrefixAST
extends ExpressionAST
{
    public PrefixAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return ((ExpressionAST) getChild(0)).getDataType(dtp);
    }

    public static PrefixAST createUnary(Operator op, List<AST> children)
    {
        PrefixAST ast = new PrefixAST(null);
        for (AST child : children)
            ast.addChild(child);
        return addOpsASTAttr(ast, op);
    }

    @Override
    public String toString()
    {
        OpsASTAttr attr = getAttribute(OpsASTAttr.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <attr.getOpCount(); i++)
            sb.append(attr.getOp(i).getSyntax());
        sb.append(super.getChild(0).toString());
        return sb.toString();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof PrefixVisitorIface)
            return ((PrefixVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
