package visitor.ifaces.expr;

import ast.ConditionalExprAST;
import visitor.VisitorIface;

public interface ConditionalExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ConditionalExprAST ctx);
}
