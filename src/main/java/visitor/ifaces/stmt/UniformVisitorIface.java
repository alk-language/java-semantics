package visitor.ifaces.stmt;

import ast.stmt.UniformAST;
import visitor.ifaces.VisitorIface;

public interface UniformVisitorIface<T>
extends VisitorIface<T>
{
    T visit(UniformAST ctx);
}
