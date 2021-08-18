package visitor.ifaces.stmt;

import ast.symbolic.SymbolicIdDeclAST;
import visitor.ifaces.VisitorIface;

public interface SymbolicIdDeclVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SymbolicIdDeclAST ctx);
}