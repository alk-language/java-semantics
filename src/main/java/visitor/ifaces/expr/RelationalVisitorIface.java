package visitor.ifaces.expr;

import ast.RelationalAST;
import visitor.VisitorIface;

public interface RelationalVisitorIface<T>
extends VisitorIface<T>
{
    T visit(RelationalAST ctx);
}
