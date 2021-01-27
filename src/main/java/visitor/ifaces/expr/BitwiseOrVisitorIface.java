package visitor.ifaces.expr;

import ast.expr.BitwiseOrAST;
import visitor.ifaces.VisitorIface;

public interface BitwiseOrVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BitwiseOrAST ctx);
}
