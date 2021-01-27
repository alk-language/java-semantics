package visitor.ifaces.stmt;

import ast.stmt.StmtSeqAST;
import visitor.ifaces.VisitorIface;

public interface StmtSeqVisitorIface<T>
extends VisitorIface<T>
{
    T visit(StmtSeqAST ctx);
}
