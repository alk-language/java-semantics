package visitor.ifaces.stmt;

import ast.symbolic.IdDeclAST;
import visitor.ifaces.VisitorIface;

public interface IdDeclVisitorIface<T>
extends VisitorIface<T>
{
    T visit(IdDeclAST ctx);
}