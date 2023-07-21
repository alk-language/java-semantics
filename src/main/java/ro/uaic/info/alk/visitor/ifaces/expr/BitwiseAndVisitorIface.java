package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.BitwiseAndAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BitwiseAndVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BitwiseAndAST ctx);
}
