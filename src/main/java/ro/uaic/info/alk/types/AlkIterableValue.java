package ro.uaic.info.alk.types;

import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.Iterator;
import java.util.List;

public abstract class AlkIterableValue
extends AlkValue
implements Iterable<Storable>
{

    public abstract void shuffle();
    public abstract List<Storable> toArray();
    public abstract void addAll(List<Storable> values, LocationGenerator generator);
    public abstract void push(Storable value, LocationGenerator generator);

    @Override
    public AlkBool equal(AlkValue operand)
    {
        if (this == operand)
        {
            return AlkBool.TRUE;
        }

        if (operand.getClass() != this.getClass())
        {
            throw new InvalidOperationException(Operator.EQUAL, this, operand);
        }

        AlkIterableValue iterableValue = (AlkIterableValue) operand;

        if (!size().equals(iterableValue.size()))
        {
            return AlkBool.FALSE;
        }

        Iterator<Storable> it = this.iterator();
        Iterator<Storable> it2 = iterableValue.iterator();
        while (it.hasNext() && it2.hasNext())
        {
            Storable value1 = it.next().toRValue();
            Storable value2 = it2.next().toRValue();
            if (value1 instanceof AlkValue && value2 instanceof AlkValue)
            {
                if (((AlkValue) value1).equal((AlkValue) value2).isFalse())
                {
                    return AlkBool.FALSE;
                }
            }
            else
            {
                throw new NotImplementedException("Can't compare properly yet array with non-concrete values");
            }
        }

        return it.hasNext() || it2.hasNext() ? AlkBool.FALSE : AlkBool.TRUE;
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (operand.getClass() != this.getClass())
        {
            throw new InvalidOperationException(Operator.LOWER, this, operand);
        }

        AlkIterableValue iterableValue = (AlkIterableValue) operand;

        Iterator<Storable> it = this.iterator();
        Iterator<Storable> it2 = iterableValue.iterator();
        while (it.hasNext() && it2.hasNext())
        {
            Storable value1 = it.next().toRValue();
            Storable value2 = it2.next().toRValue();
            if (value1 instanceof AlkValue && value2 instanceof AlkValue)
            {
                if (!((AlkValue) value1).lower((AlkValue) value2).isTrue()) // compareTo
                {
                    return AlkBool.FALSE;
                }
            }
            else
            {
                throw new NotImplementedException("Can't compare properly yet array with non-concrete values");
            }
        }

        return it.hasNext() ? AlkBool.FALSE : AlkBool.TRUE;
    }

    public boolean has(Storable operand)
    {
        for (Storable elem : this)
        {
            try
            {
                Storable value = elem.toRValue();
                // TODO: this doesn't look right; we should have an uniform way to handle this
                if (value instanceof AlkValue && operand instanceof AlkValue)
                {
                    if (((AlkValue) value).equal((AlkValue) operand).isTrue())
                    {
                        return true;
                    }
                }
                else
                {
                    if (value.equals(operand))
                    {
                        return true;
                    }
                }
            }
            catch (InvalidOperationException ignored)
            {
                // no-op
            }
        }

        return false;
    }

    @Override
    public boolean isFullConcrete()
    {
        for (Storable elem : this)
        {
            Storable value = elem.toRValue();
            if (value instanceof ConcreteValue && ((ConcreteValue) value).isFullConcrete())
            {
                continue;
            }
            return false;
        }
        return true;
    }

    public AlkValue removeAllEqTo(AlkValue value)
    {
        Iterator<Storable> it = iterator();
        while (it.hasNext())
        {
            Storable elem = it.next().toRValue();
            try
            {
                if (elem instanceof AlkValue)
                {
                    if (((AlkValue) elem).equal(value).isTrue())
                    {
                        it.remove();
                    }
                }
                else
                {
                    if (elem.equals(value))
                    {
                        it.remove();
                    }
                }
            }
            catch (InvalidOperationException ignored)
            {

            }
        }
        return this;
    }
}
