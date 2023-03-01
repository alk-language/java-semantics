package dataflow.domain;

import dataflow.Domain;
import dataflow.dtype.DataTypeSet;
import dataflow.dtype.FiniteDataTypeSet;
import dataflow.dtype.TopDataTypeSet;
import execution.parser.exceptions.AlkException;
import symbolic.CPValue;
import symbolic.OverdefinedValue;
import symbolic.UndefinedValue;
import util.exception.InternalException;
import util.types.Storable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VarDataType implements Domain
{
   private static Set<String> allVars = new HashSet<>();

   private Map<String, DataTypeSet> mapping = new HashMap<>();

   public static VarDataType getAllTop()
   {
      Map<String, DataTypeSet> mapping = new HashMap<>();
      allVars.forEach((var) -> mapping.put(var, new TopDataTypeSet()));
      return new VarDataType(mapping);
   }

   public static VarDataType getAllBottom()
   {
      Map<String, DataTypeSet> mapping = new HashMap<>();
      allVars.forEach((var) -> mapping.put(var, new FiniteDataTypeSet()));
      return new VarDataType(mapping);
   }

   public static void build(Set<String> vars)
   {
      allVars.addAll(vars);
   }

   public VarDataType(Map<String, DataTypeSet> mapping)
   {
      this.mapping.putAll(mapping);
   }

   public VarDataType join(VarDataType varValue)
   {
      Map<String, DataTypeSet> ans = new HashMap<>();

      allVars.forEach((var) -> {
         DataTypeSet now = mapping.get(var);
         DataTypeSet next = varValue.mapping.get(var);

         ans.put(var, now.union(next));
      });

      return new VarDataType(ans);
   }

   public VarDataType meet(VarDataType varValue)
   {
      Map<String, DataTypeSet> ans = new HashMap<>();

      allVars.forEach((var) -> {
         DataTypeSet now = mapping.get(var);
         DataTypeSet next = varValue.mapping.get(var);

         ans.put(var, now.intersect(next));
      });

      return new VarDataType(ans);
   }

   public boolean lower(VarDataType varValue)
   {
      for (String var : allVars)
      {
         DataTypeSet now = mapping.get(var);
         DataTypeSet next = varValue.mapping.get(var);

         if (!now.includes(next))
            return false;
      }

      return true;
   }

   public void put(String var, DataTypeSet value)
   {
      if (!allVars.contains(var))
         throw new InternalError("Can't put an unknown variable in VarDataType.");

      DataTypeSet now = mapping.get(var);
      mapping.put(var, now.intersect(value));
   }

   public DataTypeSet getDataType(String id)
   {
      if (!allVars.contains(id))
      {
         throw new InternalException("Unidentified variable when getting value");
      }
      return mapping.get(id);
   }

   @Override
   public String toString()
   {
      if (mapping.isEmpty())
         return "{ }";

      StringBuilder sb = new StringBuilder();
      sb.append("{");
      for (Map.Entry<String, DataTypeSet> entry : mapping.entrySet())
      {
         sb.append("(").append(entry.getKey()).append(" -> ").append(entry.getValue()).append(")").append(", ");
      }
      sb.deleteCharAt(sb.length()-1);
      sb.deleteCharAt(sb.length()-1);
      sb.append("}");
      return sb.toString();
   }
}

