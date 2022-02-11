package visitor;

import ast.enums.BuiltInMethod;
import util.exception.InternalException;

public class BuiltInMethodHelper
{
    public static BuiltInMethod parse(String text)
    {
        switch (text.toUpperCase())
        {
            case "AT": return BuiltInMethod.AT;
            case "DELETE": return BuiltInMethod.DELETE;
            case "END": return BuiltInMethod.END;
            case "FIRST": return BuiltInMethod.FIRST;
            case "INSERT": return BuiltInMethod.INSERT;
            case "KEYS": return BuiltInMethod.KEYS;
            case "POPBACK": return BuiltInMethod.POPBACK;
            case "POPFRONT": return BuiltInMethod.POPFRONT;
            case "PUSHBACK": return BuiltInMethod.PUSHBACK;
            case "PUSHFRONT": return BuiltInMethod.PUSHFRONT;
            case "REMOVE": return BuiltInMethod.REMOVE;
            case "REMOVEALLEQTO": return BuiltInMethod.REMOVEALLEQTO;
            case "REMOVEAT": return BuiltInMethod.REMOVEAT;
            case "SIZE": return BuiltInMethod.SIZE;
            case "SPLIT": return BuiltInMethod.SPLIT;
            case "TOPBACK": return BuiltInMethod.TOPBACK;
            case "TOPFRONT": return BuiltInMethod.TOPFRONT;
            case "UPDATE": return BuiltInMethod.UPDATE;
            default: throw new InternalException("Unidentified build in method: " + text);
        }
    }
}
