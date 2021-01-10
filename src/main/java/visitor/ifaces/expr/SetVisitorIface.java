package visitor.ifaces.expr;

import ast.SetAST;
import visitor.VisitorIface;

public interface SetVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(SetAST ctx);
}
