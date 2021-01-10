package visitor.ifaces.expr;

import ast.BracketAST;
import visitor.VisitorIface;

public interface BracketVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BracketAST ctx);
}
