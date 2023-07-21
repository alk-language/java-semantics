package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.AdditiveAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface AdditiveVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(AdditiveAST ctx);
}
