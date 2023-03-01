package dataflow.dtype;

import control.CFGBuilder;
import dataflow.*;
import dataflow.cpropag.CPropagTransferFunction;
import dataflow.domain.VarDataType;
import dataflow.domain.VarValue;
import dataflow.lattice.LatticeBuilder;
import dataflow.worklist.WorklistFlow;
import util.Configuration;

import java.util.Map;

import static main.DriverHelper.initManagers;

public class DTypeDriver
{

   public static void main(String[] args) throws InterruptedException
   {
      Configuration config = initManagers(args);

      CFGBuilder cfgBuilder = new CFGBuilder(config);
      cfgBuilder.start();
      cfgBuilder.join();

      LatticeBuilder<VarDataType> latticeBuilder = new DTypeLatticeBuilder(cfgBuilder.getCfg());
      latticeBuilder.start();
      latticeBuilder.join();

      CFG cfg = cfgBuilder.getCfg();
      Lattice<VarDataType> lattice = latticeBuilder.getLattice();
      Iota<VarDataType> iota = VarDataType::getAllTop;
      TransferFunction<VarDataType> fun = new DTypeTransferFunction();

      Dataflow<VarDataType> dataflow = new WorklistFlow<>(lattice, cfg, iota, fun);
      dataflow.start();
      dataflow.join();

      for (Map.Entry<CFGNode, VarDataType> entry : dataflow.getMapping().entrySet())
      {
         config.getIOManager().write(entry.getKey().toString() + " -> " + entry.getValue().toString());
      }
   }
}