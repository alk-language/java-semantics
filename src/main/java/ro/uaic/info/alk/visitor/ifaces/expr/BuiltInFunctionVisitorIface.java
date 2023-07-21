package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.BuiltinFunctionAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BuiltInFunctionVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BuiltinFunctionAST ctx);
}