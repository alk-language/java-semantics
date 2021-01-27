package visitor.ifaces.stmt;

import ast.stmt.BreakAST;
import visitor.ifaces.VisitorIface;

public interface BreakVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BreakAST ctx);
}
