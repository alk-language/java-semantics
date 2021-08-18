package symbolic;

import ast.AST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.ASTRepresentable;
import util.types.Storable;

public class SymbolicValue
implements ExclusiveSymbolicValue
{
    AST ast;
    ASTSimplifier simplifier = new ASTSimplifier();

    public SymbolicValue(AST ast)
    {
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
        ASTCloner cloner = new ASTCloner(locationMapper);
        return new SymbolicValue(this.ast.accept(cloner));
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
        throw new InternalException("Can't obtain a reference out of this symbolic value.");
    }

    @Override
    public AST toAST()
    {
        return ast;
    }

    @Override
    public String toString()
    {
        return ast.toString();
    }
}
