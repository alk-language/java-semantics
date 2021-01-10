package visitor.ifaces.expr;

import ast.ArrayAST;
import visitor.VisitorIface;

public interface ArrayVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ArrayAST ctx);
}
