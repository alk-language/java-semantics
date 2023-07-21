package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.HavocAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface HavocVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(HavocAST ctx);
}
