package ro.uaic.info.alk.visitor.ifaces.stmt;

import ro.uaic.info.alk.ast.stmt.StmtSeqAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface StmtSeqVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(StmtSeqAST ctx);
}
