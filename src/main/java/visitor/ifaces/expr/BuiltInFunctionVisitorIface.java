package visitor.ifaces.expr;

import ast.expr.BuiltinFunctionAST;
import visitor.ifaces.VisitorIface;

public interface BuiltInFunctionVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BuiltinFunctionAST ctx);
}