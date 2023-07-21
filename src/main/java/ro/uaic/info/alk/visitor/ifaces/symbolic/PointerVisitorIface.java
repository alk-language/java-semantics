package ro.uaic.info.alk.visitor.ifaces.symbolic;

import ro.uaic.info.alk.ast.symbolic.PointerAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface PointerVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(PointerAST ctx);
}
