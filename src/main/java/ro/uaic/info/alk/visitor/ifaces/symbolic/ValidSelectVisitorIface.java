package ro.uaic.info.alk.visitor.ifaces.symbolic;

import ro.uaic.info.alk.ast.symbolic.ValidSelectAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ValidSelectVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ValidSelectAST ctx);
}
