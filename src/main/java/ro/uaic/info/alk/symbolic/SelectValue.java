package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public class SelectValue
implements ExclusiveSymbolicValue
{
    private Storable data;
    private Storable position;

    @Override
    public AST toAST()
    {
        return null;
    }

    @Override
    public Storable weakClone(LocationMapper locationMapper)
    {
        return null;
    }

    @Override
    public Storable clone(LocationGenerator generator)
    {
        return null;
    }

    @Override
    public Storable toRValue()
    {
        return null;
    }

    @Override
    public Location toLValue()
    {
        return null;
    }

    public void setData(Storable data)
    {
        this.data = data;
    }

    public void setPosition(Storable position)
    {
        this.position = position;
    }
}
