package util.exception;

import ast.AST;

public class SMTUnimplementedException
extends InternalException
{
    public SMTUnimplementedException(Class<? extends AST> clazz)
    {
        super("Unimplemented SMT solver for: " + clazz.getName());
    }

}
