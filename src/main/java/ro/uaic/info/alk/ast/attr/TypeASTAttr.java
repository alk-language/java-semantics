package ro.uaic.info.alk.ast.attr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;

public class TypeASTAttr
extends ASTAttr
{
    private final DataTypeAST type;

    public TypeASTAttr(String text)
    {
        switch(text)
        {
            case "int" : type = new IntDataTypeAST(null); break;
            default: throw new RuntimeException("Unidentified data type: " + text);
        }
    }

    public DataTypeAST getType()
    {
        return type;
    }
}
