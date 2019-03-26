package impl.exceptions;

import java.util.ArrayList;


public class AlkWarning {
    static private ArrayList<String> warnings = new ArrayList<>();

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
