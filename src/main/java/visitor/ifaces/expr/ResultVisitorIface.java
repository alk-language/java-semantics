package visitor.ifaces.expr;

import ast.expr.ResultAST;
import visitor.ifaces.VisitorIface;

public interface ResultVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ResultAST ctx);
}
