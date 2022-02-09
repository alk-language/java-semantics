package visitor.ifaces.expr;

import ast.VirtualAST;
import visitor.ifaces.VisitorIface;

public interface VirtualVisitorIface<T>
extends VisitorIface<T>
{
    T visit(VirtualAST ctx);
}
