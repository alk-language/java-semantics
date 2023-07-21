package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.BracketAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BracketVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BracketAST ctx);
}
