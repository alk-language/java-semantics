package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.PrefixAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface PrefixVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(PrefixAST ctx);
}
