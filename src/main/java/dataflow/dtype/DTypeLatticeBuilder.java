package dataflow.dtype;

import control.extractor.VarsBulkExtractor;
import dataflow.CFG;
import dataflow.Lattice;
import dataflow.domain.VarDataType;
import dataflow.lattice.LatticeBuilder;

import java.util.Set;

public class DTypeLatticeBuilder
extends LatticeBuilder<VarDataType>
{
   private CFG cfg;
   private Lattice<VarDataType> lattice;

   public DTypeLatticeBuilder(CFG cfg)
   {
      this.cfg = cfg;
   }

   @Override
   public void run()
   {
      Set<String> vars = new VarsBulkExtractor().extract(cfg);
      VarDataType.build(vars);
      lattice = new VarDataTypeLattice();
   }

   @Override
   public Lattice<VarDataType> getLattice() {
      return lattice;
   }
}
