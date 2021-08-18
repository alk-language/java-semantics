package symbolic;

import ast.AST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.lambda.LocationGenerator;
import util.types.Storable;

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
