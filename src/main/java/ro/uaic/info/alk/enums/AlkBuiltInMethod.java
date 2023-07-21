package ro.uaic.info.alk.enums;

import ro.uaic.info.alk.exeptions.InternalException;

public enum AlkBuiltInMethod
{
    AT("at"),
    @Deprecated
    DELETE("delete"),
    @Deprecated
    END("end"),
    @Deprecated
    FIRST("first"),
    INSERT("insert"),
    KEYS("keys"),
    POP_BACK("popBack"),
    POP_FRONT("popFront"),
    PUSH_BACK("pushBack"),
    PUSH_FRONT("pushFront"),
    REMOVE("remove"),
    REMOVE_ALL_EQ_TO("removeAllEqTo"),
    REMOVE_AT("remoteAt"),
    SIZE("size"),
    SPLIT("split"),
    TOP_BACK("topBack"),
    TOP_FRONT("topFront"),
    UPDATE("update");

    private final String syntax;

    AlkBuiltInMethod(String syntax)
    {
        this.syntax = syntax;
    }

    public static AlkBuiltInMethod of(String text)
    {
        switch (text.toUpperCase())
        {
            case "AT": return AlkBuiltInMethod.AT;
            case "DELETE": return AlkBuiltInMethod.DELETE;
            case "END": return AlkBuiltInMethod.END;
            case "FIRST": return AlkBuiltInMethod.FIRST;
            case "INSERT": return AlkBuiltInMethod.INSERT;
            case "KEYS": return AlkBuiltInMethod.KEYS;
            case "POPBACK": return AlkBuiltInMethod.POP_BACK;
            case "POPFRONT": return AlkBuiltInMethod.POP_FRONT;
            case "PUSHBACK": return AlkBuiltInMethod.PUSH_BACK;
            case "PUSHFRONT": return AlkBuiltInMethod.PUSH_FRONT;
            case "REMOVE": return AlkBuiltInMethod.REMOVE;
            case "REMOVEALLEQTO": return AlkBuiltInMethod.REMOVE_ALL_EQ_TO;
            case "REMOVEAT": return AlkBuiltInMethod.REMOVE_AT;
            case "SIZE": return AlkBuiltInMethod.SIZE;
            case "SPLIT": return AlkBuiltInMethod.SPLIT;
            case "TOPBACK": return AlkBuiltInMethod.TOP_BACK;
            case "TOPFRONT": return AlkBuiltInMethod.TOP_FRONT;
            case "UPDATE": return AlkBuiltInMethod.UPDATE;
            default: throw new InternalException("Unidentified built-in method: " + text);
        }
    }

    public String getSyntax()
    {
        return syntax;
    }
}
