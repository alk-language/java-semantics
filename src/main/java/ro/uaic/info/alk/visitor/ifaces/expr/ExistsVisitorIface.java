package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ExistsExprAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ExistsVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ExistsExprAST ctx);
}
