package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ImpliesAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ImpliesVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ImpliesAST ctx);
}
