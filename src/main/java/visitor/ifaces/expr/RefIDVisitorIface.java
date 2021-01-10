package visitor.ifaces.expr;

import ast.RefIDAST;
import visitor.VisitorIface;

public interface RefIDVisitorIface<T>
extends VisitorIface<T>
{
    T visit(RefIDAST ctx);
}
