package visitor.ifaces.expr;

import ast.PostfixAST;
import visitor.VisitorIface;

public interface PostfixVisitorIface<T>
extends VisitorIface<T>
{
    T visit(PostfixAST ctx);
}
