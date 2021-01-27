package ast.attr;

import ast.enums.BuiltInFunction;

public class BuiltInFunctionASTAttr
extends ASTAttr
{
    private final BuiltInFunction function;

    public BuiltInFunctionASTAttr(BuiltInFunction function)
    {
        this.function = function;
    }

    public BuiltInFunction getFunction()
    {
        return function;
    }
}
