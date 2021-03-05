package symbolic;

import ast.AST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import util.types.ASTRepresentable;
import util.types.Storable;

public class SymbolicValue
implements SymbolicValueIface,
           ASTRepresentable
{
    AST ast;

    public SymbolicValue(AST ast)
    {
        this.ast = ast;
    }

    public static SymbolicValue toSymbolic(Storable value)
    {
        if (value == null)
        {
            return null;
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
        return new SymbolicValue(this.ast);
    }

    @Override
    public Storable clone(LocationGenerator generator)
    {
        return new SymbolicValue(this.ast);
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
