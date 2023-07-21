package ro.uaic.info.alk.execution.exhaustive;

import java.util.HashSet;
import java.util.Set;

public class NameMapper
{

    private static final Set<String> RESERVED_KEYWORDS = new HashSet<>();

    static
    {
        RESERVED_KEYWORDS.add("int");
        RESERVED_KEYWORDS.add("float");
    }

    public static String processBuiltInName(String functionName)
    {
        functionName = functionName.toLowerCase();
        if (RESERVED_KEYWORDS.contains(functionName))
            return "_" + functionName;
        return functionName;
    }
}
