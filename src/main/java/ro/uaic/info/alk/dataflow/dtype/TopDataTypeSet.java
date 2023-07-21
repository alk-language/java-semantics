package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.ast.type.DataTypeAST;

public class TopDataTypeSet
implements DataTypeSet
{
   @Override
   public DataTypeSet union(DataTypeSet value)
   {
      return new TopDataTypeSet();
   }

   @Override
   public boolean includes(DataTypeSet now)
   {
      return true;
   }

   @Override
   public DataTypeSet intersect(DataTypeSet next)
   {
      if (next instanceof TopDataTypeSet)
      {
         return new TopDataTypeSet();
      }
      return next.intersect(this);
   }

   @Override
   public DataTypeAST unique()
   {
      throw new DTypeException("Too many data types possible!");
   }


   @Override
   public String toString()
   {
      return "ANY";
   }
}
