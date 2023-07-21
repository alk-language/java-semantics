package ro.uaic.info.alk.ast.attr;

import ro.uaic.info.alk.enums.AlkBuiltInFunction;

public class BuiltInFunctionASTAttr
extends ASTAttr
{
    private final AlkBuiltInFunction function;

    public BuiltInFunctionASTAttr(AlkBuiltInFunction function)
    {
        this.function = function;
    }

    public AlkBuiltInFunction getFunction()
    {
        return function;
    }
}
