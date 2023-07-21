package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.UniformAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface UniformVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(UniformAST ctx);
}
