package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.RepresentationASTAttr;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.ast.expr.SetAST;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.ASTRepresentable;
import ro.uaic.info.alk.util.types.Storable;

import java.util.*;
import java.util.stream.Collectors;

import static ro.uaic.info.alk.exeptions.AlkException.*;

@TypeName("set")
public class AlkSet 
extends AlkIterableValue
{
    private final Set<AlkValue> set;

    public AlkSet()
    {
        set = new HashSet<>();
    }

    @Override
    public AlkSet insert(AlkValue value)
    {
        if (!has(value.toRValue()))
        {
            set.add(value.toRValue());
        }
        return this;
    }

    @Override
    public AlkValue union(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkSet))
        {
            return super.union(operand, generator);
        }

        AlkSet other = (AlkSet) operand.clone(generator);
        for (Storable value : this)
        {
            other.insert((AlkValue) value.toRValue().clone(generator));
        }
        return other;
    }

    @Override
    public AlkValue intersect(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkSet))
        {
            return super.intersect(operand, generator);
        }

        AlkSet intersect = new AlkSet();
        for (Storable value : (AlkSet) operand)
        {
            if (has(value))
            {
                intersect.insert((AlkValue) value.clone(generator));
            }
        }
        return intersect;
    }

    @Override
    public AlkValue setsubtract(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkSet))
        {
            return super.setsubtract(operand, generator);
        }
        AlkSet subtract = new AlkSet();
        for (AlkValue value : set)
        {
            if (!((AlkSet) operand).has(value))
            {
                subtract.insert(value.toRValue().clone(generator));
            }
        }
        return subtract;
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        AlkSet copy = new AlkSet();
        set.forEach((value) -> copy.insert(value.clone(generator)));
        return copy;
    }

    @Override
    public String toString()
    {
        return "{" + set.stream()
                        .map(AlkValue::toString)
                        .sorted(String::compareTo)
                        .collect(Collectors.joining(", ")) + "}";
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException
    {
        if (!(operand instanceof AlkSet))
            throw new AlkException(ERR_EQUAL_SET);

        AlkSet opSet = (AlkSet) operand;

        if (!size().equals(opSet.size()))
        {
            return AlkBool.FALSE;
        }

        boolean isEqual = true;
        for (Storable value : set)
        {
            isEqual = isEqual && opSet.has(value);
        }
        for (Storable value : opSet)
        {
            isEqual = isEqual && this.has(value);
        }

        return AlkBool.get(isEqual);
    }

    @Override
    public AlkBool lower(AlkValue operand)
    {
        if (!(operand instanceof AlkSet))
            throw new AlkException(ERR_LOWER_SET);
        AlkSet op = (AlkSet) operand;
        return AlkBool.get(this.toString().compareTo(op.toString()) < 0);
    }

    @Override
    public AlkSet s(AlkValue value)
    {
        if (!has(value))
            throw new AlkException(ERR_REMOVE_NO_SUCH_ELEMENT);

        Iterator<AlkValue> it = set.iterator();
        while (it.hasNext())
        {
            AlkValue act = it.next();
            if (act.toRValue().getClass().equals(value.getClass()) && act.toRValue().equals(value))
            {
                it.remove();
                break;
            }
        }
        return this;
    }

    @Override
    public AlkInt size()
    {
        return AlkInt.get(set.size());
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping)
    {
        AlkSet copy = new AlkSet();
        for (AlkValue value : set)
            copy.set.add(value.weakClone(locMapping));
        return copy;
    }

    @Override
    public Iterator<Storable> iterator()
    {
        return new Iterator<Storable>()
        {
            Iterator<AlkValue> it;

            @Override
            public boolean hasNext()
            {
                return it.hasNext();
            }

            @Override
            public Storable next()
            {
                return it.next();
            }
        };
    }

    @Override
    public List<Storable> toArray()
    {
        return new ArrayList<>(set);
    }

    @Override
    public void addAll(List<Storable> values, LocationGenerator generator)
    {
        for (Storable value : values)
        {
            if (!(value.toRValue() instanceof AlkValue))
            {
                throw new InternalException("Can't add non-value to Alk set: " + value);
            }
            set.add((AlkValue) value.toRValue());
        }
    }

    @Override
    public void push(Storable value, LocationGenerator generator)
    {
        if (!(value.toRValue() instanceof AlkValue))
        {
            throw new InternalException("Can't push non-value to Alk set: " + value);
        }
        insert((AlkValue) value.toRValue());
    }

    @Override
    public void shuffle()
    {
        throw new AlkException("Can't shuffle a set!");
    }

    @Override
    public AST toAST()
    {
        SetAST ast = new SetAST(null);
        RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
        ast.addAttribute(RepresentationASTAttr.class, attr);
        for (Storable value : set)
        {
            if (!(value.toRValue() instanceof ASTRepresentable))
                throw new NotImplementedException("Can't convert to AST an AlkArray");
            ast.addChild(((ASTRepresentable) value.toRValue()).toAST());
        }
        return ast;
    }

    @Override
    public boolean isFullConcrete()
    {
        for (AlkValue value : set)
        {
            if (!value.isFullConcrete())
            {
                return false;
            }
        }
        return true;
    }
}