package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;

public class UndefinedValueException
extends AlkException
{
    public UndefinedValueException(AST ast)
    {
        super("Undefined value used! The expression \"" + ast + "\" evaluated to an unknown value.");
    }
}
