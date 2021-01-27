package visitor.ifaces.expr;

import ast.expr.LogicalOrAST;
import visitor.ifaces.VisitorIface;

public interface LogicalOrVisitorIface<T>
extends VisitorIface<T>
{
    T visit(LogicalOrAST ctx);
}