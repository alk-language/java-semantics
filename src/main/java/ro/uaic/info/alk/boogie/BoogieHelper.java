package ro.uaic.info.alk.boogie;

import ro.uaic.info.alk.ast.type.BoolDataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.IntDataTypeAST;
import ro.uaic.info.alk.exeptions.InternalException;

public class BoogieHelper
{
   public static String asBoogieType(DataTypeAST ast)
   {
      if (ast instanceof IntDataTypeAST)
      {
         return "int";
      }
      else if (ast instanceof BoolDataTypeAST)
      {
         return "bool";
      }
      else
      {
         throw new InternalException("Can't convert Alk type to Boogie type: " + ast);
      }
   }
}
