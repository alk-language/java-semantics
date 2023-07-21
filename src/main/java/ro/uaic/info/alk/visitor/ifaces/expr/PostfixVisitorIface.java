package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.expr.PostfixAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface PostfixVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(PostfixAST ctx);
}
