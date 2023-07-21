package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.AssumeAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface AssumeVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(AssumeAST ctx);
}
