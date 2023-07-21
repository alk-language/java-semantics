package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.IfThenAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface IfThenVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(IfThenAST ctx);
}
