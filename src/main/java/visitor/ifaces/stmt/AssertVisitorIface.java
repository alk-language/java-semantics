package visitor.ifaces.stmt;

import ast.stmt.AssertAST;
import visitor.ifaces.VisitorIface;

public interface AssertVisitorIface<T>
extends VisitorIface<T>
{
    T visit(AssertAST ctx);
}