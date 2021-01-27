package visitor.ifaces.stmt;

import ast.stmt.FailureAST;
import visitor.ifaces.VisitorIface;

public interface FailureVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FailureAST ctx);
}