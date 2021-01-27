package visitor.ifaces.expr;

import ast.expr.LogicalAndAST;
import visitor.ifaces.VisitorIface;

public interface LogicalAndVisitorIface<T>
extends VisitorIface<T>
{
    T visit(LogicalAndAST ctx);
}
