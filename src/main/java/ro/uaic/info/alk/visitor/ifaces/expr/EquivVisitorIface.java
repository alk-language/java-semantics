package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.EquivAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface EquivVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(EquivAST ctx);
}
