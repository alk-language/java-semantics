package visitor.ifaces.symbolic;

import ast.symbolic.ValidSelectAST;
import visitor.ifaces.VisitorIface;

public interface ValidSelectVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ValidSelectAST ctx);
}
