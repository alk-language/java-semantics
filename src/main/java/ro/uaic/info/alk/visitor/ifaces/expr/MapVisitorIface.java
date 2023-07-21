package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.MapAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface MapVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(MapAST ctx);
}
