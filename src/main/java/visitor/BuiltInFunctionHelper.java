package visitor;

import ast.enums.BuiltInFunction;
import util.exception.InternalException;

public class BuiltInFunctionHelper
{
    public static BuiltInFunction parse(String function)
    {
        switch (function.toUpperCase())
        {
            case "ABS": return BuiltInFunction.ABS;
            case "ASIN": return BuiltInFunction.ASIN;
            case "ACOS": return BuiltInFunction.ACOS;
            case "ATAN": return BuiltInFunction.ATAN;
            case "COS": return BuiltInFunction.COS;
            case "FLOAT": return BuiltInFunction.FLOAT;
            case "INTEGER": return BuiltInFunction.INTEGER;
            case "LEN": return BuiltInFunction.LEN;
            case "LOG": return BuiltInFunction.LOG;
            case "PI": return BuiltInFunction.PI;
            case "PRINT": return BuiltInFunction.PRINT;
            case "POW": return BuiltInFunction.POW;
            case "RANDOM": return BuiltInFunction.RANDOM;
            case "SIN": return BuiltInFunction.SIN;
            case "SINGLETONSET": return BuiltInFunction.SINGLETONSET;
            case "SQRT": return BuiltInFunction.SQRT;
            case "TAN": return BuiltInFunction.TAN;
            default: throw new InternalException("Unidentified build in method: " + function);
        }
    }
}
