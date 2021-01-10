package visitor.ifaces.expr;

import ast.BitwiseOrAST;
import visitor.VisitorIface;

public interface BitwiseOrVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BitwiseOrAST ctx);
}
