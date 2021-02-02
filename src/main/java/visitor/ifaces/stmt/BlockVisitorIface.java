package visitor.ifaces.stmt;

import ast.stmt.BlockAST;
import visitor.ifaces.VisitorIface;

public interface BlockVisitorIface<T>
extends VisitorIface<T>
{
    T visit(BlockAST ctx);
}
