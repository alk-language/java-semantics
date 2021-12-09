package visitor.ifaces.stmt;

import ast.stmt.HavocAST;
import visitor.ifaces.VisitorIface;

public interface HavocVisitorIface<T>
extends VisitorIface<T>
{
    T visit(HavocAST ctx);
}
