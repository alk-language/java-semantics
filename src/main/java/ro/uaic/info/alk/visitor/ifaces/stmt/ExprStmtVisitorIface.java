package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ExprStmtVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ExprStmtAST ctx);
}