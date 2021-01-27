package visitor.ifaces.expr;

import ast.expr.InExprAST;
import visitor.ifaces.VisitorIface;

public interface InExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(InExprAST ctx);
}