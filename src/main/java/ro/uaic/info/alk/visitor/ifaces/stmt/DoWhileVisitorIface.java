package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.DoWhileAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface DoWhileVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(DoWhileAST ctx);
}
