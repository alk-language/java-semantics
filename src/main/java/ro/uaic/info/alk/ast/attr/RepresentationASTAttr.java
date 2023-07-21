package ro.uaic.info.alk.ast.attr;

import ro.uaic.info.alk.enums.CompoundValueRepresentation;

public class RepresentationASTAttr
extends ASTAttr
{
    private final CompoundValueRepresentation repr;

    public RepresentationASTAttr(CompoundValueRepresentation repr)
    {
        this.repr = repr;
    }

    public CompoundValueRepresentation getRepresentation()
    {
        return repr;
    }
}
