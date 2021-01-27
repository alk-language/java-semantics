package visitor.ifaces.stmt;

import ast.stmt.ExprStmtAST;
import visitor.ifaces.VisitorIface;

public interface ExprStmtVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ExprStmtAST ctx);
}