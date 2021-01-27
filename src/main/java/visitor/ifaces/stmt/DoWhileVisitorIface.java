package visitor.ifaces.stmt;

import ast.stmt.DoWhileAST;
import visitor.ifaces.VisitorIface;

public interface DoWhileVisitorIface<T>
extends VisitorIface<T>
{
    T visit(DoWhileAST ctx);
}
