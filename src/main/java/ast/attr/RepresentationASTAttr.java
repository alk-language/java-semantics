package ast.attr;

import ast.attr.ASTAttr;
import ast.enums.CompoundValueRepresentation;

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
