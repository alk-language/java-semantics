package visitor.ifaces.expr;

import ast.IntAST;
import visitor.VisitorIface;

public interface IntVisitorIface<T>
extends VisitorIface<T>
{
    T visit(IntAST ctx);
}
