package visitor.ifaces.expr;

import ast.expr.PrefixAST;
import visitor.ifaces.VisitorIface;

public interface PrefixVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(PrefixAST ctx);
}
