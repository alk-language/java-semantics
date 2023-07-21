package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ArrayAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ArrayVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ArrayAST ctx);
}
