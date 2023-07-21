package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.InExprAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface InExprVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(InExprAST ctx);
}