package visitor.ifaces.expr;

import ast.InExprAST;
import visitor.VisitorIface;

public interface InExprVisitorIface<T>
extends VisitorIface<T>
{
    T visit(InExprAST ctx);
}