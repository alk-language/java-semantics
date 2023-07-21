package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ComponentAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ComponentVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ComponentAST ctx);
}
