package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.symbolic.IdDeclAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface IdDeclVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(IdDeclAST ctx);
}