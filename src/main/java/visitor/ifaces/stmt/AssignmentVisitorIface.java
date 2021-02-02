package visitor.ifaces.stmt;

import ast.expr.AssignmentAST;
import visitor.ifaces.VisitorIface;

public interface AssignmentVisitorIface<T>
extends VisitorIface<T>
{
    T visit(AssignmentAST ctx);
}
