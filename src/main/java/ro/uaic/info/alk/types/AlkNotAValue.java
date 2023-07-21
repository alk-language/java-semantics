package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.UnknownAST;
import ro.uaic.info.alk.exeptions.AlkException;

import static ro.uaic.info.alk.exeptions.AlkException.*;

@TypeName("NaN")
public class AlkNotAValue
extends SimpleAlkValue
{
    public static AlkNotAValue INSTANCE = new AlkNotAValue();

    private AlkNotAValue()
    {

    }

    @Override
    public AlkBool equal(AlkValue operand)
    {
        throw new AlkException(ERR_EQUAL);
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        throw new AlkException(ERR_LOWER);
    }

    @Override
    public AST toAST()
    {
        return new UnknownAST(null);
    }

    @Override
    public String toString()
    {
        return "?";
    }
}
