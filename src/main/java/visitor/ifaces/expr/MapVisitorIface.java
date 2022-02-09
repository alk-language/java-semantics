package visitor.ifaces.expr;

import ast.expr.MapAST;
import visitor.ifaces.VisitorIface;

public interface MapVisitorIface<T>
extends VisitorIface<T>
{
    T visit(MapAST ctx);
}
