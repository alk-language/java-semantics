package visitor.ifaces.stmt;

import ast.stmt.SuccessAST;
import visitor.ifaces.VisitorIface;

public interface SuccessVisitorIface<T>
extends VisitorIface<T>
{
    T visit(SuccessAST ctx);
}
