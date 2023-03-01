package dataflow.dtype;

import ast.type.DataTypeAST;
import execution.parser.exceptions.AlkException;
import util.exception.InternalException;

import java.util.HashSet;
import java.util.Set;

public class FiniteDataTypeSet
implements DataTypeSet
{
   private final Set<DataTypeAST> dataTypes = new HashSet<>();

   public FiniteDataTypeSet()
   {

   }

   public FiniteDataTypeSet(Set<DataTypeAST> dataTypes)
   {
      this.dataTypes.addAll(dataTypes);
   }

   public FiniteDataTypeSet(DataTypeAST value)
   {
      this.dataTypes.add(value);
   }

   @Override
   public DataTypeSet union(DataTypeSet value)
   {
      if (value instanceof TopDataTypeSet)
      {
         return new TopDataTypeSet();
      }
      FiniteDataTypeSet other = (FiniteDataTypeSet) value;
      Set<DataTypeAST> temp = new HashSet<>(this.dataTypes);
      temp.addAll(other.dataTypes);
      return new FiniteDataTypeSet(temp);
   }

   @Override
   public boolean includes(DataTypeSet value)
   {
      if (value instanceof TopDataTypeSet)
      {
         return false;
      }
      FiniteDataTypeSet other = (FiniteDataTypeSet) value;
      return dataTypes.containsAll(other.dataTypes);
   }

   @Override
   public DataTypeSet intersect(DataTypeSet value)
   {
      if (value instanceof TopDataTypeSet)
      {
         return new FiniteDataTypeSet(this.dataTypes);
      }
      FiniteDataTypeSet other = (FiniteDataTypeSet) value;
      Set<DataTypeAST> temp = new HashSet<>(this.dataTypes);
      temp.retainAll(other.dataTypes);
      return new FiniteDataTypeSet(temp);
   }

   @Override
   public DataTypeAST unique()
   {
      if (dataTypes.size() > 1)
         throw new DTypeException("Too many data types possible");
      if (dataTypes.size() < 1)
         throw new DTypeException("Can't interfere data type");
      return dataTypes.iterator().next();
   }

   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append("{ ");
      boolean hasComma = false;
      for (DataTypeAST ast : dataTypes)
      {
         if (!hasComma)
         {
            hasComma = true;
         }
         else
         {
            sb.append(",");
         }
         sb.append(ast);
      }
      sb.append(" }");
      return sb.toString();
   }
}
