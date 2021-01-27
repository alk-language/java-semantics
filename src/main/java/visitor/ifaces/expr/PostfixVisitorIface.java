package visitor.ifaces.expr;

import ast.expr.PostfixAST;
import visitor.ifaces.VisitorIface;

public interface PostfixVisitorIface<T>
extends VisitorIface<T>
{
    T visit(PostfixAST ctx);
}
