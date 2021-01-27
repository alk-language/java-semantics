package visitor.ifaces.expr;

import ast.expr.RefIDAST;
import visitor.ifaces.VisitorIface;

public interface RefIDVisitorIface<T>
extends VisitorIface<T>
{
    T visit(RefIDAST ctx);
}
