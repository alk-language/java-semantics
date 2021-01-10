package visitor.ifaces.expr;

import ast.UnaryAST;
import visitor.VisitorIface;

public interface UnaryVisitorIface<T>
extends VisitorIface<T>
{
    T visit(UnaryAST ctx);
}
