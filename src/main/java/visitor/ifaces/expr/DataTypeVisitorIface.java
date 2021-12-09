package visitor.ifaces.expr;

import ast.type.DataTypeAST;
import visitor.ifaces.VisitorIface;

public interface DataTypeVisitorIface<T>
extends VisitorIface<T>
{
    T visit(DataTypeAST ctx);
}
