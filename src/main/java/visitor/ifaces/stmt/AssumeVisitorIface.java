package visitor.ifaces.stmt;

import ast.stmt.AssumeAST;
import visitor.ifaces.VisitorIface;

public interface AssumeVisitorIface<T>
extends VisitorIface<T>
{
    T visit(AssumeAST ctx);
}
