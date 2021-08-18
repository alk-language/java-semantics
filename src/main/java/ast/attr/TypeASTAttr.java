package ast.attr;

import ast.type.DataTypeAST;
import ast.type.IntDataTypeAST;

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
