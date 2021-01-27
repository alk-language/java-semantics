package visitor.ifaces.expr;

import ast.expr.FactorPointMethodAST;
import visitor.ifaces.VisitorIface;

public interface FactorPointMethodVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FactorPointMethodAST ctx);
}
