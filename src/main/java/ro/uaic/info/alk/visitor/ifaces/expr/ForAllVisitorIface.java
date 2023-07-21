package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ForAllExprAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ForAllVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ForAllExprAST ctx);
}
