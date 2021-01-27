package visitor.ifaces.stmt;

import ast.stmt.RepeatUntilAST;
import visitor.ifaces.VisitorIface;

public interface RepeatUntilVisitorIface<T>
extends VisitorIface<T>
{
    T visit(RepeatUntilAST ctx);
}