package visitor.ifaces.expr;

import ast.expr.UnknownAST;
import visitor.ifaces.VisitorIface;

public interface UnknownVisitorIface<T>
extends VisitorIface<T>
{
    T visit(UnknownAST ctx);
}
