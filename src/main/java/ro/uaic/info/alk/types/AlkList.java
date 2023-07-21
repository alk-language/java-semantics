package ro.uaic.info.alk.types;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.RepresentationASTAttr;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.ast.expr.ListAST;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.NotImplementedException;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.ASTRepresentable;
import ro.uaic.info.alk.util.types.Storable;

import java.util.*;
import java.util.stream.Collectors;

import static ro.uaic.info.alk.exeptions.AlkException.*;

@TypeName("list")
public class AlkList
extends AlkIndexedValue
{
    private final LinkedList<Location> list;

    public AlkList()
    {
        list = new LinkedList<>();
    }

    @Override
    public AlkValue add(AlkValue operand, LocationGenerator generator)
    {
        if (!(operand instanceof AlkList))
        {
            return super.add(operand, generator);
        }
        AlkList list = (AlkList) operand;
        AlkList newList = (AlkList) this.clone(generator);
        list.list.forEach((loc) -> newList.push(loc.toRValue(), generator));
        return newList;
    }

    @Override
    public AlkValue at(AlkValue operand)
    {
        if (!(operand instanceof AlkInt))
        {
            return super.at(operand);
        }

        Location loc = list.get(getValidIndex((AlkInt) operand, false));
        if (loc.isUnknown())
        {
            throw new AlkException("Unknown value at this position.");
        }

        return (AlkValue) loc.toRValue();
    }

    @Override
    public AlkValue insert(AlkValue position, AlkValue value, LocationGenerator generator)
    {
        if (!(position instanceof AlkInt))
        {
            return super.insert(position, value, generator);
        }

        list.add(getValidIndex((AlkInt) position, true), generator.generate(value));
        return this;
    }

    @Override
    public AlkValue popBack()
    {
        if (list.isEmpty())
        {
            throw new AlkException(ERR_POPBACK_EMPTY);
        }
        list.removeLast();
        return this;
    }

    @Override
    public AlkValue popFront()
    {
        if (list.isEmpty())
        {
            throw new AlkException(ERR_POPFRONT_EMPTY);
        }
        list.removeFirst();
        return this;
    }

    @Override
    public void push(Storable value, LocationGenerator generator)
    {
        pushBack(generator.generate(value));
    }

    @Override
    public void shuffle()
    {
        Collections.shuffle(list);
    }

    public AlkValue pushBack(Location value)
    {
        list.addLast(value);
        return this;
    }

    public AlkValue pushFront(Location value)
    {
        list.addFirst(value);
        return this;
    }

    public AlkValue removeAt(AlkValue position)
    {
        if (!(position instanceof AlkInt))
        {
            return super.removeAt(position);
        }
        list.remove(getValidIndex((AlkInt) position, false));
        return this;
    }

    public AlkValue size()
    {
        return AlkInt.get(list.size());
    }

    public AlkValue topBack()
    {
        if (list.isEmpty())
        {
            throw new AlkException(ERR_TOPBACK_EMPTY);
        }

        return (AlkValue) list.getLast().toRValue();
    }

    public AlkValue topFront()
    {
        if (list.isEmpty())
        {
            throw new AlkException(ERR_TOPFRONT_EMPTY);
        }

        return (AlkValue) list.getFirst().toRValue();
    }

    @Override
    public AlkValue update(AlkValue position, AlkValue value, LocationGenerator generator)
    {
        if (!(position instanceof AlkInt))
        {
            return super.removeAt(position);
        }
        list.set(getValidIndex((AlkInt) position, false), generator.generate(value));
        return this;
    }

    @Override
    public AlkValue weakClone(LocationMapper locationMapper)
    {
        AlkList copy = new AlkList();
        list.forEach((loc) -> copy.list.add(locationMapper.get(loc)));
        return copy;
    }

    @Override
    public AlkValue clone(LocationGenerator generator)
    {
        AlkList copy = new AlkList();
        list.forEach((loc) -> copy.push(loc.toRValue(), generator));
        return copy;
    }

    @Override
    public Iterator<Storable> iterator()
    {
        return new Iterator<Storable>()
        {
            Iterator<Location> it;

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
    public ArrayList<Storable> toArray()
    {
        return new ArrayList<>(list);
    }

    @Override
    public void addAll(List<Storable> values, LocationGenerator generator)
    {
        for (Storable value : values)
        {
            list.add(generator.generate(value));
        }
    }

    @Override
    public AST toAST()
    {
        ListAST ast = new ListAST(null);
        RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
        ast.addAttribute(RepresentationASTAttr.class, attr);
        for (Location loc : list)
        {
            if (!(loc.toRValue() instanceof ASTRepresentable))
                throw new NotImplementedException("Can't convert to AST an AlkList");
            ast.addChild(((ASTRepresentable) loc.toRValue()).toAST());
        }
        return ast;
    }

    @Override
    public String toString()
    {
        return "< " + list.stream()
                         .map((loc) -> loc.toRValue().toString())
                         .collect(Collectors.joining(", ")) + " >";
    }
}
