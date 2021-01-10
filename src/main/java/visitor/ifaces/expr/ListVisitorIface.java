package visitor.ifaces.expr;

import ast.ListAST;
import visitor.VisitorIface;

public interface ListVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ListAST ctx);
}