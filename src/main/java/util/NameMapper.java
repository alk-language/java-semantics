package util;

import java.util.HashSet;
import java.util.Set;

public class NameMapper {

    private static Set<String> reservedWords = new HashSet<>();

    static {
        reservedWords.add("int");
        reservedWords.add("float");
    }

    public static String processBuiltInName(String functionName) {
        if (reservedWords.contains(functionName))
            return "_" + functionName;
        return functionName;
    }
}
