package ro.uaic.info.alk.visitor.ifaces.symbolic;

import ro.uaic.info.alk.ast.symbolic.ValidStoreAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ValidStoreVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ValidStoreAST ctx);
}
