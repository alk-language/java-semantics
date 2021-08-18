package visitor;

import ast.enums.Anno;

public class AnnoHelper
{
    public static Anno textToEnum(String text)
    {
        text = text.toUpperCase();
        switch(text)
        {
            case "COUNT": return Anno.COUNT;
            default: return null;
        }
    }
}
