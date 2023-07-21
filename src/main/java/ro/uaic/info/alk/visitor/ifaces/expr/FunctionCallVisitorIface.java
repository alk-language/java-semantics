package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.FunctionCallAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FunctionCallVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(FunctionCallAST ctx);
}
