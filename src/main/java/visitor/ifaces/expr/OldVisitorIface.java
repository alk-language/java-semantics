package visitor.ifaces.expr;

import ast.expr.OldAST;
import visitor.ifaces.VisitorIface;

public interface OldVisitorIface<T>
extends VisitorIface<T>
{
    T visit(OldAST ctx);
}

