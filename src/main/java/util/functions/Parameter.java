package util.functions;

import ast.AST;
import ast.enums.ParamType;
import ast.type.DataTypeAST;

public class Parameter
{
    String id;
    ParamType type;
    DataTypeAST dataType;
    boolean size;

    public Parameter(String name, ParamType type, DataTypeAST dataType)
    {
        this.id = name;
        this.type = type;
        this.dataType = dataType;
    }

    public ParamType getType() {
        return type;
    }

    public String getName() {
        return id;
    }

    public DataTypeAST getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeAST dataType)
    {
        this.dataType = dataType;
    }

    public void setSizeFlag(boolean size)
    {
        this.size = size;
    }

    public boolean hasSizeFlag()
    {
        return this.size;
    }
}
