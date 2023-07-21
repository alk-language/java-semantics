package ro.uaic.info.alk.visitor.ifaces.expr;

import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

public interface DataTypeVisitorIface<T>
   extends VisitorIface<T>
{
   T visit(DataTypeAST ctx);
}
