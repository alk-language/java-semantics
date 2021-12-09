package visitor.ifaces.expr;

import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import visitor.ifaces.VisitorIface;

public interface ExistsVisitorIface<T>
extends VisitorIface<T>
{
    T visit(ExistsExprAST ctx);
}
