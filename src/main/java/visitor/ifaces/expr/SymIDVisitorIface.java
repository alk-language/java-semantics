package visitor.ifaces.expr;

import ast.expr.SymIDAST;
import visitor.ifaces.VisitorIface;

public interface SymIDVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SymIDAST ctx);
}
