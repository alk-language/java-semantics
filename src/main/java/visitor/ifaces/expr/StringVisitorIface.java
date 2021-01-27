package visitor.ifaces.expr;

import ast.expr.StringAST;
import visitor.ifaces.VisitorIface;

public interface StringVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(StringAST ctx);
}
