package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ForAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ForVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ForAST ctx);
}
