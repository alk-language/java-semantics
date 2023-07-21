package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ListAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ListVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ListAST ctx);
}