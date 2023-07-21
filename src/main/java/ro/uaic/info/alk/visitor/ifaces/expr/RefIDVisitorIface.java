package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface RefIDVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(RefIDAST ctx);
}
