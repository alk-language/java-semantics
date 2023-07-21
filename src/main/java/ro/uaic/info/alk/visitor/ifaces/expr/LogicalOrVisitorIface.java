package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.LogicalOrAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface LogicalOrVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(LogicalOrAST ctx);
}