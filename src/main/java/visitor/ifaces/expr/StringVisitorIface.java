package visitor.ifaces.expr;

import ast.StringAST;
import visitor.VisitorIface;

public interface StringVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(StringAST ctx);
}
