package visitor.ifaces.stmt;

import ast.stmt.IfThenAST;
import visitor.ifaces.VisitorIface;

public interface IfThenVisitorIface<T>
extends VisitorIface<T>
{
    T visit(IfThenAST ctx);
}
