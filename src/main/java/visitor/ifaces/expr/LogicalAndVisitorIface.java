package visitor.ifaces.expr;

import ast.LogicalAndAST;
import visitor.VisitorIface;

public interface LogicalAndVisitorIface<T>
extends VisitorIface<T>
{
    T visit(LogicalAndAST ctx);
}
