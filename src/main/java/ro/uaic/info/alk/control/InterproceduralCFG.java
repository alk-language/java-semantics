package ro.uaic.info.alk.control;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTHelper;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.execution.AlkFunction;
import ro.uaic.info.alk.util.AlkConfiguration;

import java.util.ArrayList;
import java.util.List;

public class InterproceduralCFG
extends ControlFlowGraph
{
   private final List<CFGAtom> atoms = new ArrayList<>();

   public InterproceduralCFG()
   {
      this.input.forceText("interprocedural-input");
      this.output.forceText("interprocedural-output");
   }

   public static ControlFlowGraph generate(AST root, AlkConfiguration config)
   {
      InterproceduralCFG cfg = new InterproceduralCFG();
      List<FunctionDeclAST> fncs = ASTHelper.getFunctions(root, false);
      for (FunctionDeclAST fnc : fncs)
      {
         AlkFunction function = AlkFunction.build(fnc);
         cfg.addAtom(function, fnc, IntraproceduralCFG.generate(fnc.getBody(), config));
      }
      return cfg;
   }

   private void addAtom(AlkFunction function, AST fncAST, IntraproceduralCFG cfg)
   {
      cfg.getInput().forceText(function.getName() + "-input");
      cfg.getOutput().forceText(function.getName() + "-output");

      Node fNode = new Node(fncAST);
      link(this.input, fNode);
      link(fNode, cfg.getInput());
      link((Node) cfg.getOutput(), this.output);

      this.atoms.add(new CFGAtom(function, cfg));
   }

   public void link(Node a, Node b)
   {
      Edge edge = new Edge(a, b, null);
      a.appendOutput(edge);
      b.appendInput(edge);
   }

   @Override
   public String graphData()
   {
      StringBuilder sb = new StringBuilder();
      for (CFGAtom atom : atoms)
      {
         sb.append(atom.function).append("\n");
         sb.append(atom.cfg.graphData());
      }
      return sb.toString();
   }

   public List<CFGAtom> getAtoms()
   {
      return atoms;
   }

   public static class CFGAtom
   {
      public AlkFunction function;
      public IntraproceduralCFG cfg;

      public CFGAtom(AlkFunction function, IntraproceduralCFG cfg)
      {
         this.function = function;
         this.cfg = cfg;
      }
   }
}


