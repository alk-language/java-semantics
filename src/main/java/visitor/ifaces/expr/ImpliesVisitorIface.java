package visitor.ifaces.expr;

import ast.expr.fol.ImpliesAST;
import visitor.ifaces.VisitorIface;

public interface ImpliesVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ImpliesAST ctx);
}
