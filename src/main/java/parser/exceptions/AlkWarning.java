package parser.exceptions;

import java.util.ArrayList;

@Deprecated
public class AlkWarning {
    static private ArrayList<String> warnings = new ArrayList<>();

    public final static String WARR_DEPRECATED_SPECS = "The syntax for specs is deprecated. Use keyword \"from\" instead of \"in\".";

    public static void printAll() {
        for (String w : warnings)
        {
            System.out.println("[Warning] " + w);
        }
    }

    public static void addWarning(String text, int line)
    {
        warnings.add("line " + line + ": " + text);
    }
}
