package visitor.ifaces.expr;

import ast.expr.AdditiveAST;
import visitor.ifaces.VisitorIface;

public interface AdditiveVisitorIface<T>
extends VisitorIface<T>
{
    T visit(AdditiveAST ctx);
}
