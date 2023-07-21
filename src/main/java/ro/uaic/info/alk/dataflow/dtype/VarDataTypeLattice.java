package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.VarDataType;

import java.util.Set;

public class VarDataTypeLattice implements Lattice<VarDataType>
{
   @Override
   public boolean compare(VarDataType a, VarDataType b)
   {
      return a.lower(b);
   }

   @Override
   public VarDataType getLUB(Set<VarDataType> set)
   {
      VarDataType mapping = getBottom();
      for (VarDataType varValue : set)
      {
         mapping = mapping.meet(varValue);
      }
      return mapping;
   }

   @Override
   public VarDataType getGLB(Set<VarDataType> set)
   {
      VarDataType mapping = getTop();
      for (VarDataType varValue : set)
      {
         mapping = mapping.join(varValue);
      }
      return mapping;
   }

   @Override
   public VarDataType getTop() {
      return VarDataType.getAllBottom();
   }

   @Override
   public VarDataType getBottom() {
      return VarDataType.getAllTop();
   }
}
