package visitor.ifaces.expr;

import ast.BracketAST;
import ast.ComponentAST;
import visitor.VisitorIface;

public interface ComponentVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ComponentAST ctx);
}
