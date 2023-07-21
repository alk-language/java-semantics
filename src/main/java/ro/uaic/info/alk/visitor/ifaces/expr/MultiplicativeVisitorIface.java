package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.MultiplicativeAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface MultiplicativeVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(MultiplicativeAST ctx);
}
