package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.exeptions.InternalException;

public class SMTUnimplementedException
   extends InternalException
{
    public SMTUnimplementedException(Class<? extends AST> clazz)
    {
        super("Unimplemented SMT solver for: " + clazz.getName());
    }

}
