package visitor.ifaces.expr;

import ast.expr.FactorPointIdAST;
import visitor.ifaces.VisitorIface;

public interface FactorPointIdIface<T>
extends VisitorIface<T>
{
    T visit(FactorPointIdAST ctx);
}
