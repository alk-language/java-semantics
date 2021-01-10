package visitor.ifaces.expr;

import ast.StructAST;
import visitor.VisitorIface;

public interface StructVisitorIface<T>
extends VisitorIface<T>
{
    T visit(StructAST ctx);
}
