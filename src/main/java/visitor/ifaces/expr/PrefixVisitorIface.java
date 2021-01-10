package visitor.ifaces.expr;

import ast.PrefixAST;
import visitor.VisitorIface;

public interface PrefixVisitorIface<T>
        extends VisitorIface<T>
{
    T visit(PrefixAST ctx);
}
