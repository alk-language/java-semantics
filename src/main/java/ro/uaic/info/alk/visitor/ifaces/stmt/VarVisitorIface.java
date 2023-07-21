package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.VarAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface VarVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(VarAST ctx);
}
