package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.util.types.Storable;

public class InvalidAssertionException
extends AlkException
{
    public InvalidAssertionException(AST ast)
    {
        super("Invalid assertion! The expression \"" + ast + "\" evaluated to false.");
    }

    public InvalidAssertionException(AST ast, Storable value)
    {
        super("Invalid assertion! The expression \"" + ast + "\" evaluated to " + value + ", which is false.");
    }
}
