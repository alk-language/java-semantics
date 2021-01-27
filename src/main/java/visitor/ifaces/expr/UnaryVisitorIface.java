package visitor.ifaces.expr;

import ast.expr.UnaryAST;
import visitor.ifaces.VisitorIface;

public interface UnaryVisitorIface<T>
extends VisitorIface<T>
{
    T visit(UnaryAST ctx);
}
