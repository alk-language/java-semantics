package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.WhileAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface WhileVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(WhileAST ctx);
}
