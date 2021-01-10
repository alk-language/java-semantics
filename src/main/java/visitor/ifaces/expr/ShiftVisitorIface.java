package visitor.ifaces.expr;

import ast.ShiftAST;
import visitor.VisitorIface;

public interface ShiftVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ShiftAST ctx);
}
