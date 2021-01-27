package visitor.ifaces.expr;

import ast.expr.BoolAST;
import visitor.ifaces.VisitorIface;

public interface BoolVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BoolAST ctx);
}
