package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FunctionDeclVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(FunctionDeclAST ctx);
}
