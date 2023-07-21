package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.symbolic.SymbolicDeclsAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SymbolicDeclsVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SymbolicDeclsAST ctx);
}
