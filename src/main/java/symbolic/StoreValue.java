package symbolic;

import ast.AST;
import ast.symbolic.StoreAST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.Storable;

public class StoreValue
implements ExclusiveSymbolicValue
{
    private Storable data;
    private Storable position;
    private Storable value;

    @Override
    public Storable weakClone(LocationMapper locationMapper)
    {
        // TODO: do weak clone
        return null;
    }

    @Override
    public Storable clone(LocationGenerator generator)
    {
        // TODO: do clone
        return null;
    }

    @Override
    public Storable toRValue()
    {
        return this;
    }

    @Override
    public Location toLValue()
    {
        throw new InternalException("Can't obtain a reference out of this store value.");
    }

    @Override
    public AST toAST()
    {
        AST ast = new StoreAST(null);
        ast.addChild(SymbolicValue.toSymbolic(data.toRValue()).toAST());
        ast.addChild(SymbolicValue.toSymbolic(position.toRValue()).toAST());
        ast.addChild(SymbolicValue.toSymbolic(value.toRValue()).toAST());
        return ast;
    }

    public String toString()
    {
        return "(store " + data.toRValue().toString() + " " +
                           position.toRValue().toString() + " " +
                           value.toRValue().toString() + ")";
    }

    public void setData(Storable data)
    {
        this.data = data;
    }

    public void setPosition(Storable position)
    {
        this.position = position;
    }

    public void setValue(Storable value)
    {
        this.value = value;
    }
}
