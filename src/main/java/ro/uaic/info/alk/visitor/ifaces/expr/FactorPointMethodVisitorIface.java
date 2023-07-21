package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.FactorPointMethodAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FactorPointMethodVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(FactorPointMethodAST ctx);
}
