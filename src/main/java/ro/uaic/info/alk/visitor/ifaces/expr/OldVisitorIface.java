package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.OldAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface OldVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(OldAST ctx);
}

