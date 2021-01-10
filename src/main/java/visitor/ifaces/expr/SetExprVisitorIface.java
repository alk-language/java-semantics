package visitor.ifaces.expr;

import ast.SetExprAST;
import visitor.VisitorIface;

public interface SetExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SetExprAST ctx);
}
