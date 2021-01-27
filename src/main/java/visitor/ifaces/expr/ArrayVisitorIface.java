package visitor.ifaces.expr;

import ast.expr.ArrayAST;
import visitor.ifaces.VisitorIface;

public interface ArrayVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ArrayAST ctx);
}
