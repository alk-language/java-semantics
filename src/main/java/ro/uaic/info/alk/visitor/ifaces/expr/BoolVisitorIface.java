package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.BoolAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BoolVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BoolAST ctx);
}
