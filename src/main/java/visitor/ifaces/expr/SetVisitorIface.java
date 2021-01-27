package visitor.ifaces.expr;

import ast.expr.SetAST;
import visitor.ifaces.VisitorIface;

public interface SetVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(SetAST ctx);
}
