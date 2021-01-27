package visitor.ifaces.expr;

import ast.expr.BracketAST;
import visitor.ifaces.VisitorIface;

public interface BracketVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BracketAST ctx);
}
