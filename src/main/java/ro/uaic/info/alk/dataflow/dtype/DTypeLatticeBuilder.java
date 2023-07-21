package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFG;
import ro.uaic.info.alk.dataflow.Lattice;
import ro.uaic.info.alk.dataflow.domain.VarDataType;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;

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
      Set<String> vars = new VarsBulkExtractor(true).extract(cfg);
      VarDataType.build(vars);
      lattice = new VarDataTypeLattice();
   }

   @Override
   public Lattice<VarDataType> getLattice() {
      return lattice;
   }
}
