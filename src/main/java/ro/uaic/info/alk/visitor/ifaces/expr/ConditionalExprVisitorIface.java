package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ConditionalExprAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ConditionalExprVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ConditionalExprAST ctx);
}
