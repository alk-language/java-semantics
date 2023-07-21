package ro.uaic.info.alk.symbolic;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.LocationMapperIface;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.types.ASTRepresentable;
import ro.uaic.info.alk.util.types.Storable;
import ro.uaic.info.alk.util.lambda.LocationGenerator;

public class SymbolicValue
implements ExclusiveSymbolicValue
{
    // Only expression AST!
    private final AST ast;

    public SymbolicValue(AST ast)
    {
        this(ast, false);
    }

    public SymbolicValue(AST ast, boolean fixedLocations)
    {
        this(ast, loc -> loc, fixedLocations);
    }

    public SymbolicValue(AST ast, LocationMapperIface lm, boolean fixedLocations)
    {
        ASTSimplifier simplifier = new ASTSimplifier(lm, fixedLocations);
        this.ast = ast.accept(simplifier);
    }

    public static SymbolicValue toSymbolic(Storable value)
    {
        value = value.toRValue();

        if (value == null)
        {
            throw new InternalException("Value is null when converting to symbolic");
        }

        if (value instanceof ASTRepresentable)
        {
            return new SymbolicValue(((ASTRepresentable) value).toAST());
        }

        throw new InternalException("Can't build symbolic value out of: " + value.toString());
    }


    @Override
    public Storable weakClone(LocationMapper locationMapper)
    {
        return new SymbolicValue(ast, locationMapper, false);
    }

    @Override
    public Storable clone(LocationGenerator generator)
    {
        ASTCloner cloner = new ASTCloner(generator);
        return new SymbolicValue(this.ast.accept(cloner));
    }

    @Override
    public Storable toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new AlkException("Can't obtain a reference out of this symbolic value.");
    }

    @Override
    public AST toAST()
    {
        return ast;
    }

    @Override
    public String toString()
    {
        LocationMapperIface lm = loc -> loc;
        return ast.accept(new ASTSimplifier(lm, true)).toString();
    }
}
