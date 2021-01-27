package visitor.ifaces.expr;

import ast.expr.FunctionCallAST;
import visitor.ifaces.VisitorIface;

public interface FunctionCallVisitorIface<T>
extends VisitorIface<T>
{
    T visit(FunctionCallAST ctx);
}
