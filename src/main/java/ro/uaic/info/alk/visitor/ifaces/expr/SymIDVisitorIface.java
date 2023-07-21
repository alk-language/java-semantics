package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.SymIDAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SymIDVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SymIDAST ctx);
}
