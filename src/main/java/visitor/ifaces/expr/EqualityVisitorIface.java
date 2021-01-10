package visitor.ifaces.expr;

import ast.EqualityAST;
import visitor.VisitorIface;

public interface EqualityVisitorIface<T>
extends VisitorIface<T>
{
    T visit(EqualityAST ctx);
}
