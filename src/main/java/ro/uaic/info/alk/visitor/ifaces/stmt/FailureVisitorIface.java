package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.FailureAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface FailureVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(FailureAST ctx);
}