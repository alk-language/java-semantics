package visitor.ifaces.stmt;

import ast.stmt.ForAST;
import visitor.ifaces.VisitorIface;

public interface ForVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ForAST ctx);
}
