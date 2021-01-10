package visitor.ifaces.expr;

import ast.MultiplicativeAST;
import visitor.VisitorIface;

public interface MultiplicativeVisitorIface<T>
extends VisitorIface<T>
{
    T visit(MultiplicativeAST ctx);
}
