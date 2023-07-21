package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.StructAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface StructVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(StructAST ctx);
}
