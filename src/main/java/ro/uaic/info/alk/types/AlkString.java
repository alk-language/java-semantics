package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.expr.StringAST;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.exeptions.OutOfBoundsException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The main and only class responsible for the string values. In Alk, the string values
 * are unbound, so we use {@link String} as main data structure. This class is immutable,
 * so the Alk may share the same string instances across different part of code.
 * Overrides specific operations (like relational) and built-in methods.
 *
 * @author Alexandru Lungu
 * @since 1.0
 */
@TypeName("string")
public final class AlkString
extends SimpleAlkValue
{
    /** The largest string size that allows caching */
    private static final int MAX_LENGTH_CACHEABLE_STRING = 1024;

    /** Convenient instance representing the empty string value. */
    public static final AlkString EMPTY = new AlkString("");

    /** Internal value of this Alk string. */
    private final String value;

    /**
     * Basic constructor that initializes the Alk string. This is private to allow
     * only the cachable gateway through {@link #get}.
     *
     * @param   value
     *          The underlying native string value.
     */
    private AlkString(String value)
    {
        if (value == null)
        {
            throw new InternalException("Invalid value to instantiate Alk string: null");
        }
        this.value = value;
    }

    /**
     * A mean of retrieving a specific string. This uses the cache or instantiates
     * a new string value representation. Strings that are too long won't be cached.
     *
     * @param   value
     *          The native string value to be wrapped.
     *
     * @return  An Alk representation of the provided string.
     */
    public static AlkString get(String value)
    {
        if (value.isEmpty())
        {
            return EMPTY;
        }

        if (value.length() > MAX_LENGTH_CACHEABLE_STRING)
        {
            return new AlkString(value);
        }

        return (AlkString) cache(new AlkString(value));
    }

    /**
     * Equal implementation of the Alk string data type. This can be applied
     * only with another string. The comparison is case-sensitive.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if the operand has the same string value.
     */
    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (this == operand)
        {
            return AlkBool.TRUE;
        }

        if (operand instanceof AlkString)
        {
            return AlkBool.get(this.value.equals(((AlkString) operand).value));
        }

        throw new InvalidOperationException(Operator.EQUAL, this, operand);
    }

    /**
     * Lower implementation of the Alk string data type. This can be applied
     * only with another string. The comparison is based on the native string
     * comparison. It is not locale sensitive. The lexicographic order is used.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation.
     *
     * @return  {@code true} if this is lexicographically lower than the operand.
     */
    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (operand instanceof AlkString)
        {
            return AlkBool.get(this.value.compareTo(((AlkString) operand).value) < 0);
        }

        throw new InvalidOperationException(Operator.LOWER, this, operand);
    }

    /**
     * Implementation of the {@code at} built-in function. This allows accessing a specific
     * character from within the string, as long as the index is valid.
     *
     * @param   index
     *          The index from which the retrieval is done. This should be an integer.
     *
     * @return  The character at the specified index as an Alk string.
     */
    @Override
    public AlkValue at(AlkValue index)
    {
        if (!(index instanceof AlkInt))
        {
            return super.at(index);
        }

        try
        {
            int intIndex = ((AlkInt) index).intValue((e) ->
            {
                throw new OutOfBoundsException(this, (AlkInt) index);
            });

            if (intIndex < 0 || intIndex >= value.length())
            {
                throw new OutOfBoundsException(this, (AlkInt) index);
            }

            return AlkString.get(String.valueOf(value.charAt(intIndex)));
        }
        catch (OutOfBoundsException ex)
        {
            InvalidOperationException ioe = new InvalidOperationException(AlkBuiltInMethod.AT, this, index);
            ioe.initCause(ex);
            throw ioe;
        }
    }

    /**
     * Implementation of the {@code split} built-in function. This allows splitting the array based
     * on a provided regex pattern. If {@link #EMPTY} is used, the split is done per-character. The
     * resulting value is an {@link AlkArray}.
     *
     * @param   pattern
     *          The regex pattern which is used for splitting.
     * @param   generator
     *          A generator that allows generating new locations.
     *
     * @return  An Alk array holding the string chunks after splitting.
     */
    @Override
    public AlkArray split(AlkValue pattern, LocationGenerator generator)
    {
        if (!(pattern instanceof AlkString))
        {
            return super.split(pattern, generator);
        }

        AlkInt size = ((AlkString) pattern).size();
        List<String> chunks = new ArrayList<>();
        if (size.equals(AlkInt.ZERO))
        {
            chunks = Arrays.asList(value.split(""));
        }
        else if (size.equals(AlkInt.ONE))
        {
            char delim = ((AlkString) pattern).value.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < value.length(); i++)
            {
                if (value.charAt(i) == delim)
                {
                    chunks.add(sb.toString());
                    sb = new StringBuilder();
                }
                else
                {
                    sb.append(value.charAt(i));
                }
            }
            chunks.add(sb.toString());
        }
        else
        {
            InvalidOperationException ex = new InvalidOperationException(AlkBuiltInMethod.SPLIT,
                                                                         this,
                                                                         pattern);
            ex.initCause(new AlkException("Invalid split with multi-character string!"));
            throw ex;
        }

        AlkArray arr = new AlkArray();
        chunks.forEach((chunk) -> arr.push(AlkString.get(chunk), generator));

        return arr;
    }

    /**
     * Implementation of the {@code split} built-in function. This generated an array where each
     * element is a character from this string.
     *
     * @param   generator
     *          A generator that allows generating new locations.
     *
     * @return  An Alk array holding the characters after splitting.
     */
    @Override
    public AlkArray split(LocationGenerator generator)
    {
        return split(AlkString.EMPTY, generator);
    }

    /**
     * Implementation of the {@code insert} built-in function. This allows generating an Alk string
     * similar to this, but where the provided string is inserted at the specified position.
     *
     * @param   position
     *          The position where to do the insertion. This should be integer.
     * @param   str
     *          The string to be inserted into a (copy) of this.
     *
     * @return  An Alk string representing the result of the insertion.
     */
    public AlkValue insert(AlkValue position, AlkValue str)
    {
        return insert(position, str, null);
    }

    /**
     * Implementation of the {@code insert} built-in function. This allows generating an Alk string
     * similar to this, but where the provided string is inserted at the specified position.
     *
     * @param   position
     *          The position where to do the insertion. This should be integer.
     * @param   str
     *          The string to be inserted into a (copy) of this.
     *
     * @return  An Alk string representing the result of the insertion.
     */
    @Override
    public AlkValue insert(AlkValue position, AlkValue str, LocationGenerator generator)
    {
        if (!(position instanceof AlkInt) || !(str instanceof AlkString))
        {
            return super.insert(position, str, generator);
        }

        try
        {
            int intIndex = ((AlkInt) position).intValue((e) -> {
                throw new OutOfBoundsException(this, (AlkInt) position);
            });
            if (intIndex < 0 || intIndex > this.value.length())
            {
                throw new OutOfBoundsException(this, (AlkInt) position);
            }

            return AlkString.get(value.substring(0, intIndex) +
                                 ((AlkString) str).value +
                                 value.substring(intIndex));
        }
        catch (OutOfBoundsException obe)
        {
            InvalidOperationException ex = new InvalidOperationException(AlkBuiltInMethod.INSERT,
                                                                         this,
                                                                         position,
                                                                         str);
            ex.initCause(obe);
            throw ex;
        }
    }

    /**
     * Implementation of the {@code update} built-in function. This allows generating an Alk string
     * similar to this, but where the provided string replaces the character at the specified location.
     * Usually, this is used to replace with one single character. However, one character can be replaced
     * with several characters using {@code update}.
     *
     * @param   position
     *          The position where to do the update. This should be integer.
     * @param   str
     *          The string to be inserted into a (copy) of this.
     *
     * @return  An Alk string representing the result of the update.
     */
    public AlkValue update(AlkValue position, AlkValue str)
    {
        return update(position, str, null);
    }

    /**
     * Implementation of the {@code update} built-in function. This allows generating an Alk string
     * similar to this, but where the provided string replaces the character at the specified location.
     * Usually, this is used to replace with one single character. However, one character can be replaced
     * with several characters using {@code update}.
     *
     * @param   position
     *          The position where to do the update. This should be integer.
     * @param   str
     *          The string to be inserted into a (copy) of this.
     *
     * @return  An Alk string representing the result of the update.
     */
    @Override
    public AlkValue update(AlkValue position, AlkValue str, LocationGenerator generator)
    {
        if (!(position instanceof AlkInt) || !(str instanceof AlkString))
        {
            return super.update(position, str, generator);
        }

        if (!((AlkString) str).size().equals(AlkInt.ONE))
        {
            InvalidOperationException ex = new InvalidOperationException(AlkBuiltInMethod.UPDATE,
                                                                         this,
                                                                         position,
                                                                         str);
            ex.initCause(new AlkException("Invalid update with multi-character string!"));
            throw ex;
        }

        return this.removeAt(position).insert(position, str, generator);
    }

    /**
     * Implementation of the {@code removeAt} built-in function. This allows generating an Alk string
     * similar to this, but where the character at the provided position is removed.
     *
     * @param   position
     *          The position where to do the remove. This should be integer.
     *
     * @return  An Alk string representing the result of the removal.
     */
    @Override
    public AlkValue removeAt(AlkValue position)
    {
        if (!(position instanceof AlkInt))
        {
            return super.removeAt(position);
        }

        int intIndex = ((AlkInt) position).intValue((e) -> {
            throw new OutOfBoundsException(this, (AlkInt) position);
        });
        if (intIndex < 0 || intIndex >= value.length())
        {
            throw new OutOfBoundsException(this, (AlkInt) position);
        }

        return AlkString.get(this.value.substring(0, intIndex) + this.value.substring(intIndex + 1));
    }

    /**
     * Implementation of the {@code size} built-in function. This allows computing the number of
     * characters from this string.
     *
     * @return  An Alk integer holding the number of characters in this string.
     */
    @Override
    public AlkInt size()
    {
        return this == EMPTY ? AlkInt.ZERO : AlkInt.get(value.length());
    }

    /**
     * Implementation of the {@code add} operator. This allows generating an Alk string
     * holding the concatenation of this with the provided operand.
     *
     * @param   operand
     *          The string operand to which this will be concatenaed to in the result.
     *
     * @return  An Alk string representing the concatenation of this and the provided operand.
     */
    public AlkString add(AlkValue operand)
    {
        return add(operand, null);
    }

    /**
     * Implementation of the {@code add} operator. This allows generating an Alk string
     * holding the concatenation of this with the provided operand.
     *
     * @param   operand
     *          The string operand to which this will be concatenaed to in the result.
     * @param   generator
     *          A generator that allows generating new locations.
     *
     * @return  An Alk string representing the concatenation of this and the provided operand.
     */
    @Override
    public AlkString add(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkString))
        {
            return (AlkString) super.add(operand, generator);
        }

        return AlkString.get(value + ((AlkString) operand).value);
    }

    /**
     * Simple equals implementation.
     *
     * @param   obj
     *          Operand to be compared with
     *
     * @return  {@code true} if the provided argument is an Alk string with the same value.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof AlkString))
        {
            return false;
        }

        return value.equals(((AlkString) obj).value);
    }

    /**
     * Simple hash code.
     *
     * @return   Hash code.
     */
    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    /**
     * Basic override of the toString method.
     *
     * @return   String representation of this value.
     */
    @Override
    public String toString()
    {
        return "\"" + value + "\"";
    }

    /**
     * Implementation of AST representation.
     *
     * @return   A string AST holding this value.
     */
    @Override
    public AST toAST()
    {
        return new StringAST(value);
    }
}
