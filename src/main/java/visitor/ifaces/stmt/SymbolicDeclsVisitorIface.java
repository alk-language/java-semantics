package visitor.ifaces.stmt;

import ast.symbolic.SymbolicDeclsAST;
import visitor.ifaces.VisitorIface;

public interface SymbolicDeclsVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SymbolicDeclsAST ctx);
}
