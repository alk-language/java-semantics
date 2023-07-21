package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.FactorPointIdAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FactorPointIdIface<T>
   extends VisitorIface<T>
{
   T visit(FactorPointIdAST ctx);
}
