package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.RelationalAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface RelationalVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(RelationalAST ctx);
}
