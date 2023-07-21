package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.SetExprAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SetExprVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SetExprAST ctx);
}
