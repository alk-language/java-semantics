package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface UnaryVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(UnaryAST ctx);
}
