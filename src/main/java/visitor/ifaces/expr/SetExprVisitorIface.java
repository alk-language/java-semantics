package visitor.ifaces.expr;

import ast.expr.SetExprAST;
import visitor.ifaces.VisitorIface;

public interface SetExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SetExprAST ctx);
}
