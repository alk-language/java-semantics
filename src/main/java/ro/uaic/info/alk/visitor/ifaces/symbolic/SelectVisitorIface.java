package ro.uaic.info.alk.visitor.ifaces.symbolic;

import ro.uaic.info.alk.ast.symbolic.SelectAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface SelectVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(SelectAST ctx);
}

