package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.ChooseAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface ChooseVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(ChooseAST ctx);
}