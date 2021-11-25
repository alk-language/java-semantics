package visitor.ifaces.symbolic;

import ast.symbolic.ValidStoreAST;
import visitor.ifaces.VisitorIface;

public interface ValidStoreVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ValidStoreAST ctx);
}
