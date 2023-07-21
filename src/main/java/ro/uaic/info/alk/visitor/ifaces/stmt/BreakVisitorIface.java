package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.BreakAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BreakVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BreakAST ctx);
}
