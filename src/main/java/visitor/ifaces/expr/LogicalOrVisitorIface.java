package visitor.ifaces.expr;

import ast.ListAST;
import ast.LogicalOrAST;
import visitor.VisitorIface;

public interface LogicalOrVisitorIface<T>
extends VisitorIface<T>
{
    T visit(LogicalOrAST ctx);
}