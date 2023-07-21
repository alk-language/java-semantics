package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.ShiftAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ShiftVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ShiftAST ctx);
}
