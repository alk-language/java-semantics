package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.IntAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface IntVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(IntAST ctx);
}
