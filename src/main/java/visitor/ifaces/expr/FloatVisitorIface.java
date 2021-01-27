package visitor.ifaces.expr;

import ast.expr.FloatAST;
import visitor.ifaces.VisitorIface;

public interface FloatVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FloatAST ctx);
}
