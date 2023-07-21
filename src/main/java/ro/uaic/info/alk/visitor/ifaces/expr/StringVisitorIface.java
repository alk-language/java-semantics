package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.StringAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface StringVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(StringAST ctx);
}
