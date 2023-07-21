package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.BitwiseOrAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BitwiseOrVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BitwiseOrAST ctx);
}
