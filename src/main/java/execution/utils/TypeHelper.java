package execution.utils;

import ast.expr.ExpressionAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import symbolic.SymbolicValue;
import util.types.Storable;

public class TypeHelper
{
    public static DataTypeAST getDataType(Storable value, DataTypeProvider dtp)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(value);
        return ((ExpressionAST) sym.toAST()).getDataType(dtp);
    }
}
