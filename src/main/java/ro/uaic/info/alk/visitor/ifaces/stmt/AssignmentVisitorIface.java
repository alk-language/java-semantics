package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface AssignmentVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(AssignmentAST ctx);
}
