package ro.uaic.info.alk.ast.attr;

import ro.uaic.info.alk.enums.AlkBuiltInMethod;

public class BuiltInMethodASTAttr
extends ASTAttr
{
    private final AlkBuiltInMethod method;

    public BuiltInMethodASTAttr(AlkBuiltInMethod method)
    {
        this.method = method;
    }

    public AlkBuiltInMethod getMethod()
    {
        return method;
    }
}
