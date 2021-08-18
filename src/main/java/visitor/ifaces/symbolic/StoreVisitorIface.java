package visitor.ifaces.symbolic;

import ast.symbolic.StoreAST;
import visitor.ifaces.VisitorIface;

public interface StoreVisitorIface<T>
extends VisitorIface<T>
{
    T visit(StoreAST ctx);
}
