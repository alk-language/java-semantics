package visitor.ifaces.expr;

import ast.expr.StructAST;
import visitor.ifaces.VisitorIface;

public interface StructVisitorIface<T>
extends VisitorIface<T>
{
    T visit(StructAST ctx);
}
