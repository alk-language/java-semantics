package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTVisitor;
import ro.uaic.info.alk.preproc.FlattenFunctions;
import ro.uaic.info.alk.preproc.UniqueVarRenamer;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.control.CFGBuilder;
import ro.uaic.info.alk.control.InterproceduralCFG;
import ro.uaic.info.alk.control.Node;
import ro.uaic.info.alk.dataflow.domain.VarDataType;
import ro.uaic.info.alk.dataflow.lattice.LatticeBuilder;
import ro.uaic.info.alk.dataflow.worklist.WorklistFlow;
import ro.uaic.info.alk.dataflow.*;
import ro.uaic.info.alk.main.DriverHelper;
import ro.uaic.info.alk.util.AlkConfiguration;

import java.util.*;

import static ro.uaic.info.alk.main.DriverHelper.initManagers;

public class DTypeDriver
{

   public static void main(String[] args) throws InterruptedException
   {
      AlkConfiguration config = DriverHelper.initManagers(args);

      CFGBuilder cfgBuilder = new CFGBuilder(config, false);
      cfgBuilder.registerProcessor(new FlattenFunctions());
      cfgBuilder.registerProcessor(new UniqueVarRenamer());
      cfgBuilder.start();
      cfgBuilder.join();

      List<CFGNode> nodes = cfgBuilder.getCfg().getNodes();
      InterproceduralCFG inter = (InterproceduralCFG) cfgBuilder.getCfg();
      for (CFGNode node : nodes)
      {
         AST root = node.getTree();

         Set<String> funCalls = new HashSet<>();
         ASTVisitor<Set<String>> visitor = new ASTVisitor<>(funCalls);
         visitor.registerPre((tree) -> true, (tree, payload) -> {
            if (tree instanceof RefIDAST)
            {
               IdASTAttr attr = tree.getAttribute(IdASTAttr.class);
               String name = attr.getId();
               if (name.contains("-\\result"))
               {
                  funCalls.add(name.substring(0, name.indexOf("-")));
               }
            }
         });
         visitor.visit(root);

         for (String call : funCalls)
         {
            for (InterproceduralCFG.CFGAtom atom : inter.getAtoms())
            {
               if (atom.function.getName().equals(call))
               {
                  inter.link((Node) node, atom.cfg.getInput());
                  inter.link((Node) atom.cfg.getOutput(), (Node) node);
               }
            }
         }
      }

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