package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.expr.ArrayAST;
import ro.uaic.info.alk.enums.*;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.*;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.ASTRepresentable;
import ro.uaic.info.alk.util.types.Storable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The main and only class responsible for the array values. In Alk, the array values
 * are dynamic, so we use {@link ArrayList} as main data structure. This class is mutable,
 * so make sure you don't use it for more than one specific use-case. Also, this can't
 * be shared across multiple threads as it is not synchronized.
 * This is an indexed structure, so access can be done using indexes at specific positions.
 * Overrides specific operations like concatenation and built-in methods.
 *
 * @author Alexandru Lungu
 * @since 1.0
 */
@TypeName("array")
public class AlkArray
extends AlkIndexedValue
{
    /** The maximum allowed size of an Alk array. This can be configured. TODO make private */
    public static int MAX_ARRAY = (int) 1e6;

    /** The core structure underlying this Alk value. This should be implementation dependent */
    private final ArrayList<Location> array;

    /**
     * Basic constructor that initializes the underlying Java array.
     */
    public AlkArray()
    {
        array = new ArrayList<>();
    }

    /**
     * Implementation of the shuffle operation. This is done in-place as the array is mutable.
     */
    @Override
    public void shuffle()
    {
        Collections.shuffle(array);
    }

    /**
     * Implementation of the push methods. This allows iterable values to be uniformly
     * populated with records.
     *
     * @param   value
     *          The location that should be pushed in this array.
     */
    @Override
    public void push(Storable value, LocationGenerator generator)
    {
        pushBack((AlkValue) value.toRValue(), generator);
    }

    /**
     * Implementation of the + operator. This returns an array that represents the concatenation of the
     * array operands.
     *
     * @param   operand
     *          The value having the role of the second operand in this binary operation
     * @param   generator
     *          A generator is needed to be able to create the result array in a different memory space.
     *
     * @return  An Alk array representing the concatenation of this array with the operand array.
     */
    @Override
    public AlkArray add(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkArray))
        {
            return (AlkArray) super.add(operand, generator);
        }

        AlkArray opArray = (AlkArray) operand;

        if (this.array.size() + opArray.array.size() > MAX_ARRAY)
        {
            throw InvalidOperationException.builder(Operator.ADD)
                                           .operand(this).operand(operand)
                                           .cause(new ArrayLimitExceeded())
                                           .build();
        }

        AlkArray newArray = this.clone(generator);
        opArray.forEach((value) -> newArray.push(value.toRValue(), generator));
        return newArray;
    }

    /**
     * Retrieve a value copy at the specified index. This built-in method doesn't do
     * automatic array resizing.
     *
     * @param    index
     *           The index used for access. If not valid, an exception is thrown
     *
     * @return   The element at the specified position.
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
            Location loc = array.get(getValidIndex((AlkInt) index));
            return ((AlkValue) loc.toRValue()).clone(loc.getStore());
        }
        catch (OutOfBoundsException e)
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.AT)
                                           .target(this).param(index)
                                           .cause(e)
                                           .build();
        }
    }

    /**
     * Insert a specific value at a specific index. This shift the elements after the
     * specified index to the right. The final array will be similar to this one, but
     * with a new location at the specified index. This happens in-place as this structure
     * is mutable.
     *
     * @param   index
     *          The index where the location should be inserted.
     * @param   value
     *          The value that should be inserted.
     *
     * @return  This array after insertion.
     */
    @Override
    public AlkArray insert(AlkValue index, AlkValue value, LocationGenerator generator)
    {
        if (!(index instanceof AlkInt))
        {
            return (AlkArray) super.insert(index, value, generator);
        }

        try
        {
            if (array.size() + 1 > MAX_ARRAY)
            {
                throw new ArrayLimitExceeded();
            }

            array.add(getValidIndex((AlkInt) index, true), generator.generate(value));
            return this;
        }
        catch (OutOfBoundsException | ArrayLimitExceeded e)
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.INSERT)
                                           .target(this).param(index).param(value)
                                           .cause(e)
                                           .build();
        }
    }

    /**
     * Insert a new element at the end. This will increase the size of this array
     * and will happen in-place as this array is mutable.
     *
     * @param   value
     *          The location to be pushed back at this end of this array.
     *
     * @return  This array after the push.
     */
    @Override
    public AlkArray pushBack(AlkValue value, LocationGenerator generator)
    {
        if (array.size() + 1 > MAX_ARRAY)
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.PUSH_BACK)
                                           .target(this).param(value)
                                           .cause(new ArrayLimitExceeded())
                                           .build();
        }
        array.add(generator.generate(value));
        return this;
    }

    /**
     * Remove the last element from the array. If this array is empty, an exception is thrown.
     *
     * @return   This array after the last element was popped.
     */
    @Override
    public AlkArray popBack()
    {
        if (array.isEmpty())
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.POP_BACK)
                                           .target(this)
                                           .cause(new EmptyValueException(AlkArray.class))
                                           .build();
        }
        array.remove(array.size() - 1);
        return this;
    }

    /**
     * Insert a new element at the front. This will increase the size of this array
     * and will happen in-place as this array is mutable.
     *
     * @param   value
     *          The location to be pushed front at this beginning of this array.
     *
     * @return  This array after the push.
     */
    @Override
    public AlkArray pushFront(AlkValue value, LocationGenerator generator)
    {
        if (array.size() + 1 > MAX_ARRAY)
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.PUSH_FRONT)
                                           .target(this)
                                           .cause(new ArrayLimitExceeded())
                                           .build();
        }

        array.add(0, generator.generate(value));
        return this;
    }

    /**
     * Remove the first element from the array. If this array is empty, an exception is thrown.
     * All elements will be shifted to the left, so that size will decrease.
     *
     * @return   This array after the first element was popped.
     */
    @Override
    public AlkArray popFront()
    {
        if (array.isEmpty())
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.POP_FRONT)
                                           .target(this)
                                           .cause(new EmptyValueException(AlkArray.class))
                                           .build();
        }

        array.remove(0);
        return this;
    }

    /**
     * Remove the element at the specified index. This will shift all elements from the right-side
     * to the left. This will happen in-place as the array is mutable.
     *
     * @param   index
     *          The index at which the value will be removed.
     *
     * @return  This array after the specified element was removed.
     */
    @Override
    public AlkArray removeAt(AlkValue index)
    {
        if (!(index instanceof AlkInt))
        {
            return (AlkArray) super.removeAt(index);
        }

        try
        {
            array.remove(getValidIndex((AlkInt) index));
            return this;
        }
        catch (OutOfBoundsException e)
        {
            throw InvalidOperationException.builder(AlkBuiltInMethod.REMOVE_AT)
                                           .target(this).param(index)
                                           .cause(e)
                                           .build();
        }
    }

    /**
     * This computed the size of the array in the form of an Alk integer.
     *
     * @return   The size of this array. This means, the highest index at which a
     *           known value was set - 1.
     */
    @Override
    public AlkInt size()
    {
        return AlkInt.get(array.size());
    }

    /**
     * An implementation of the canonical array representation of this structure. Make
     * sure we return a copy here to avoid any unwanted mutable operations outside this
     * class.
     *
     * @return   A copy of this array in a canonical array form.
     */
    @Override
    public List<Storable> toArray()
    {
        return new ArrayList<>(array);
    }

    /**
     * Canonical implementation of adding multiple elements into this data structure.
     * By convention, the elements will be added at the end of this array. If the final
     * array exceeds the maximum size, an exception will be thrown.
     *
     * @param    values
     *           The locations which need to be appended at the end of this array.
     */
    @Override
    public void addAll(List<Storable> values, LocationGenerator generator)
    {
        if (array.size() + values.size() > MAX_ARRAY)
        {
            throw new ArrayLimitExceeded();
        }

        for (Storable value : values)
        {
            this.push(value.toRValue(), generator);
        }
    }

    /**
     * Bracket operator implementation ([]). This is very similar to at built-in method.
     *
     * @param   operand
     *          The value to be used as an index for the [] operator.
     * @param   generator
     *          Location generator used for dynamic resizing of this array.
     *
     * @return  The location stored at the specified index. The location can be unknown.
     */
    @Override
    public Location bracket(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkInt))
        {
            return super.bracket(operand, generator);
        }

        try
        {
            return get(((AlkInt) operand).intValue((e) -> {
                throw new ArrayLimitExceeded();
            }), generator);
        }
        catch (OutOfBoundsException | ArrayLimitExceeded e)
        {
            throw InvalidOperationException.builder(Operator.BRACKET)
                                           .operand(operand)
                                           .cause(e)
                                           .build();
        }
    }

    /**
     * Retrieve a clone that uses a location mapper to remap its nested locations.
     * For this kind of value, we will need to do in-depth remapping.
     *
     * @param   locationMapper
     *          The mapper that allows remapping nested locations.
     *
     * @return  A weak clone of this value.
     */
    @Override
    public AlkArray weakClone(LocationMapper locationMapper)
    {
        AlkArray copy = new AlkArray();
        array.forEach((loc) -> copy.array.add(locationMapper.get(loc)));
        return copy;
    }

    /**
     * Basic override of the clone method, imposed by the abstract parent
     *
     * @return   A copy of this value. As this type is mutable, a new array is created. The
     *           copy is done in depth.
     */
    @Override
    public AlkArray clone(LocationGenerator locationGenerator)
    {
        AlkArray copy = new AlkArray();
        array.forEach((loc) -> copy.push(loc.toRValue(), locationGenerator));
        return copy;
    }

    /**
     * Implementation of the iterable structure iterator method. This simply returns an
     * iterator to the internal array.
     *
     * @return   An iterator to this underlying array.
     */
    @Override
    public Iterator<Storable> iterator()
    {
        return new Iterator<Storable>()
        {
            private int idx = 0;

            @Override
            public boolean hasNext()
            {
                return idx < array.size();
            }

            @Override
            public Storable next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException("Can't get next value of Alk array iterator.");
                }
                return array.get(idx++);
            }
        };
    }

    /**
     * Implementation of AST representation.
     *
     * @return   An array AST holding this value.
     */
    @Override
    public ArrayAST toAST()
    {
        ArrayAST ast = new ArrayAST(CompoundValueRepresentation.EXPRESSIONS);
        array.forEach((loc) -> {
            Storable value = loc.toRValue();
            if (!(value instanceof ASTRepresentable))
            {
                // TODO: panic!!
                throw new InternalException("Can't convert array element " + value + " into an AST!");
            }
            ast.addChild(((ASTRepresentable) value).toAST());
        });
        return ast;
    }

    /**
     * Basic override of the toString method.
     *
     * @return   String representation of this value.
     */
    @Override
    public String toString()
    {
        return "[" + array.stream()
                          .map((loc) -> loc.toRValue().toString())
                          .collect(Collectors.joining(", ")) + "]";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof AlkArray))
        {
            return false;
        }

        AlkArray otherArray = (AlkArray) o;

        try
        {
            return this.equal(otherArray).isTrue();
        }
        catch (InvalidOperationException e)
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        int hashCode = 1;
        for (Location loc : array)
        {
            hashCode = 31 * hashCode + loc.toRValue().hashCode();
        }
        return hashCode;
    }

    /**
     * Internal helper method to retrieve the element at a specific index. This should
     * do the dynamic resizing.
     *
     * @param   index
     *          The index which should be accessed. The dynamic resizing will do minimal
     *          effort to allow accessing this index.
     * @param   generator
     *          The location generator used by dynamic resizing.
     *
     * @return  The location stored at the specified index.
     */
    private Location get(int index, LocationGenerator generator)
    throws OutOfBoundsException,
           ArrayLimitExceeded
    {
        if (index < 0)
        {
            throw new OutOfBoundsException(this, AlkInt.get(index));
        }

        if (index >= MAX_ARRAY)
        {
            throw new ArrayLimitExceeded();
        }

        while (array.size() <= index)
        {
            array.add(generator.generate(AlkNotAValue.INSTANCE));
        }

        return array.get(index);
    }
}
