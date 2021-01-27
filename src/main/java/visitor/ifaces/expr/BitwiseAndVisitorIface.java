package visitor.ifaces.expr;

import ast.expr.BitwiseAndAST;
import visitor.ifaces.VisitorIface;

public interface BitwiseAndVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BitwiseAndAST ctx);
}
