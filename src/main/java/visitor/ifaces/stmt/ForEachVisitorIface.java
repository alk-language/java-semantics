package visitor.ifaces.stmt;

import ast.stmt.ForEachAST;
import visitor.ifaces.VisitorIface;

public interface ForEachVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ForEachAST ctx);
}
