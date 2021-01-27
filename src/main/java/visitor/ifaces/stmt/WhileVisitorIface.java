package visitor.ifaces.stmt;

import ast.stmt.WhileAST;
import visitor.ifaces.VisitorIface;

public interface WhileVisitorIface<T>
extends VisitorIface<T>
{
    T visit(WhileAST ctx);
}
