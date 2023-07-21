package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.TypeName;
import ro.uaic.info.alk.util.types.Storable;

public class UnexpectedTypeException
extends AlkException
{
    public UnexpectedTypeException(AST child, Storable value, Class<? extends AlkValue> clazz)
    {
        super("Unexpected data type when evaluating \"" + child + "\". The result was " + value +
              (value.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + value.getClass().getAnnotation(TypeName.class).value() : "") +
              (clazz.isAnnotationPresent(TypeName.class) ?
              ", but " + clazz.getAnnotation(TypeName.class).value() + " was expected" : "") + ".");
    }
}
