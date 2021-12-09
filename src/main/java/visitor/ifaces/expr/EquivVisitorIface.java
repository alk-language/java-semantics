package visitor.ifaces.expr;

import ast.expr.fol.EquivAST;
import visitor.ifaces.VisitorIface;

public interface EquivVisitorIface<T>
extends VisitorIface<T>
{
    T visit(EquivAST ctx);
}
