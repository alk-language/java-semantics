package ast.attr;

import ast.enums.BuiltInMethod;

public class BuiltInMethodASTAttr
extends ASTAttr
{
    private final BuiltInMethod method;

    public BuiltInMethodASTAttr(BuiltInMethod method)
    {
        this.method = method;
    }

    public BuiltInMethod getMethod()
    {
        return method;
    }
}
