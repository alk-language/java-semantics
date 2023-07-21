package ro.uaic.info.alk.visitor.ifaces.symbolic;

import ro.uaic.info.alk.ast.symbolic.StoreAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface StoreVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(StoreAST ctx);
}
