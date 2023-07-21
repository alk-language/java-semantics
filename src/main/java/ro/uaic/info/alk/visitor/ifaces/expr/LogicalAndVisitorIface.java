package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.LogicalAndAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface LogicalAndVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(LogicalAndAST ctx);
}
