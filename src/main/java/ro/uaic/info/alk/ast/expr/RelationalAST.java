package ro.uaic.info.alk.ast.expr;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.expr.RelationalVisitorIface;

import java.util.List;

public class RelationalAST
extends ExpressionAST
{
    public RelationalAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public static AST createBinary(Operator op, List<AST> children)
    {
        RelationalAST ast = new RelationalAST(null);
        for (AST child : children)
            ast.addChild(child);
        return AST.addOpsASTAttr(ast, op);
    }

    @Override
    public DataTypeAST getDataType(DataTypeProvider dtp)
    {
        return new BoolDataTypeAST(null);
    }

    @Override
    public String toString()
    {
        return ExpressionAST.getBinaryOperationString(this);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof RelationalVisitorIface)
            return ((RelationalVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }
}
