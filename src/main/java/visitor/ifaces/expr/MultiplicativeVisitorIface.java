package visitor.ifaces.expr;

import ast.expr.MultiplicativeAST;
import visitor.ifaces.VisitorIface;

public interface MultiplicativeVisitorIface<T>
extends VisitorIface<T>
{
    T visit(MultiplicativeAST ctx);
}
