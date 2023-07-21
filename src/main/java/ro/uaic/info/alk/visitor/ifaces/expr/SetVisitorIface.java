package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.SetAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SetVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SetAST ctx);
}
