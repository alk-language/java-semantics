package visitor.ifaces.stmt;

import ast.stmt.FunctionDeclAST;
import visitor.ifaces.VisitorIface;

public interface FunctionDeclVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FunctionDeclAST ctx);
}
