package visitor.ifaces.symbolic;

import ast.expr.FloatAST;
import ast.symbolic.SelectAST;
import visitor.ifaces.VisitorIface;

public interface SelectVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SelectAST ctx);
}

