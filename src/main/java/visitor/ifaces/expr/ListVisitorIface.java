package visitor.ifaces.expr;

import ast.expr.ListAST;
import visitor.ifaces.VisitorIface;

public interface ListVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ListAST ctx);
}