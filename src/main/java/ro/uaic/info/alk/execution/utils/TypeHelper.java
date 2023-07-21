package ro.uaic.info.alk.execution.utils;

import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.types.Storable;

public class TypeHelper
{
    public static DataTypeAST getDataType(Storable value, DataTypeProvider dtp)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(value);
        return ((ExpressionAST) sym.toAST()).getDataType(dtp);
    }
}
