package visitor.ifaces.expr;

import ast.expr.fol.ForAllExprAST;
import visitor.ifaces.VisitorIface;

public interface ForAllVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ForAllExprAST ctx);
}
