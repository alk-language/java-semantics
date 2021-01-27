package visitor.ifaces.expr;

import ast.expr.ConditionalExprAST;
import visitor.ifaces.VisitorIface;

public interface ConditionalExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ConditionalExprAST ctx);
}
