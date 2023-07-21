package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.EqualityAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface EqualityVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(EqualityAST ctx);
}
