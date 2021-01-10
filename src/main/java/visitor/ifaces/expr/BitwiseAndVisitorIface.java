package visitor.ifaces.expr;

import ast.BitwiseAndAST;
import visitor.VisitorIface;

public interface BitwiseAndVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BitwiseAndAST ctx);
}
