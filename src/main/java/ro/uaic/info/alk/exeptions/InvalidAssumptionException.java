package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.util.types.Storable;

public class InvalidAssumptionException
extends AlkException
{
    public InvalidAssumptionException(AST ast)
    {
        super("Invalid assumption! The expression \"" + ast + "\" evaluated to false.");
    }

    public InvalidAssumptionException(AST ast, Storable value)
    {
        super("Invalid assumption! The expression \"" + ast + "\" evaluated to " + value + ", which is false.");
    }
}
