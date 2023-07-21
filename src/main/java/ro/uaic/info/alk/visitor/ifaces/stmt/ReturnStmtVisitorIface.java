package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ReturnAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ReturnStmtVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ReturnAST ctx);
}