package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.FloatAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FloatVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(FloatAST ctx);
}
