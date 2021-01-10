package visitor.ifaces.expr;

import ast.FloatAST;
import visitor.VisitorIface;

public interface FloatVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FloatAST ctx);
}
