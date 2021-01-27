package visitor.ifaces.stmt;

import ast.stmt.ChooseAST;
import visitor.ifaces.VisitorIface;

public interface ChooseVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ChooseAST ctx);
}