package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.VarVisitorIface;

import java.util.stream.Collectors;

public class VarAST
extends StmtAST
{
   public VarAST(ASTContext ctx)
   {
      super(ctx);
   }

   @Override
   public <T> T accept(VisitorIface<T> visitor)
   {
      if (visitor instanceof VarVisitorIface)
         return ((VarVisitorIface<T>) visitor).visit(this);

      return super.accept(visitor);
   }

   @Override
   public String toString()
   {
      String decls = children.stream().map(Object::toString).collect(Collectors.joining(", "));
      return "@var " + decls + ";" + System.lineSeparator();
   }
}
