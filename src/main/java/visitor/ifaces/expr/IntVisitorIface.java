package visitor.ifaces.expr;

import ast.expr.IntAST;
import visitor.ifaces.VisitorIface;

public interface IntVisitorIface<T>
extends VisitorIface<T>
{
    T visit(IntAST ctx);
}
