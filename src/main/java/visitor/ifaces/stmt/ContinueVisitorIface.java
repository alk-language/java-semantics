package visitor.ifaces.stmt;

import ast.stmt.ContinueAST;
import visitor.ifaces.VisitorIface;

public interface ContinueVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ContinueAST ctx);
}