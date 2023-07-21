package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.VirtualAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface VirtualVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(VirtualAST ctx);
}
