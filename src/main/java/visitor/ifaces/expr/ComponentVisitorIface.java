package visitor.ifaces.expr;

import ast.expr.ComponentAST;
import visitor.ifaces.VisitorIface;

public interface ComponentVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ComponentAST ctx);
}
