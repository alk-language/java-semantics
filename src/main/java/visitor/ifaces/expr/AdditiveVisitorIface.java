package visitor.ifaces.expr;

import ast.AdditiveAST;
import visitor.VisitorIface;

public interface AdditiveVisitorIface<T>
extends VisitorIface<T>
{
    T visit(AdditiveAST ctx);
}
