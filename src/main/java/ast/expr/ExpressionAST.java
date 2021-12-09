package ast.expr;

import ast.AST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;

public abstract class ExpressionAST
extends AST
{
    public ExpressionAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    public abstract DataTypeAST getDataType(DataTypeProvider dtp);
    /*{
        throw new InternalException("Can't identify data type for the specified expression AST");
    }*/
}
