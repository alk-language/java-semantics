package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ForEachAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ForEachVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ForEachAST ctx);
}
