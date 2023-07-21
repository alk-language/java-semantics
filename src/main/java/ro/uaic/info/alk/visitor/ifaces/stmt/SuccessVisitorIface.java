package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.SuccessAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SuccessVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SuccessAST ctx);
}
