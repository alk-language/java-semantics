package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.UnknownAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface UnknownVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(UnknownAST ctx);
}
