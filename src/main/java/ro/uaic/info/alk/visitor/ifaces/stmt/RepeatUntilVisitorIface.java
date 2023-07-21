package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.RepeatUntilAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface RepeatUntilVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(RepeatUntilAST ctx);
}