package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ContinueAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ContinueVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ContinueAST ctx);
}