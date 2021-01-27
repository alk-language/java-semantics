package visitor.ifaces.expr;

import ast.expr.ShiftAST;
import visitor.ifaces.VisitorIface;

public interface ShiftVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ShiftAST ctx);
}
