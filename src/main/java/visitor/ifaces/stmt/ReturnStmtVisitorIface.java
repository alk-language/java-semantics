package visitor.ifaces.stmt;

import ast.stmt.ReturnAST;
import visitor.ifaces.VisitorIface;

public interface ReturnStmtVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ReturnAST ctx);
}