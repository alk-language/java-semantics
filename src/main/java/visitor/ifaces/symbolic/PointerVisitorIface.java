package visitor.ifaces.symbolic;

import ast.symbolic.PointerAST;
import visitor.ifaces.VisitorIface;

public interface PointerVisitorIface<T>
extends VisitorIface<T>
{
    T visit(PointerAST ctx);
}
