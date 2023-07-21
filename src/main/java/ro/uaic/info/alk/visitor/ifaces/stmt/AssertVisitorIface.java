package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.AssertAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface AssertVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(AssertAST ctx);
}