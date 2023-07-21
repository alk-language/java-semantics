package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.BlockAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface BlockVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(BlockAST ctx);
}
