package visitor.ifaces.expr;

import ast.expr.RelationalAST;
import visitor.ifaces.VisitorIface;

public interface RelationalVisitorIface<T>
extends VisitorIface<T>
{
    T visit(RelationalAST ctx);
}
