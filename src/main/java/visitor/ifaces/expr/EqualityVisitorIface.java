package visitor.ifaces.expr;

import ast.expr.EqualityAST;
import visitor.ifaces.VisitorIface;

public interface EqualityVisitorIface<T>
extends VisitorIface<T>
{
    T visit(EqualityAST ctx);
}
