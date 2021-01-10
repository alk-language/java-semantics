package visitor.ifaces.expr;

import ast.BoolAST;
import visitor.VisitorIface;

public interface BoolVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BoolAST ctx);
}
