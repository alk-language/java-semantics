package dataflow.dtype;

import ast.AST;
import ast.expr.AssignmentAST;
import ast.expr.ExpressionAST;
import ast.stmt.ExprStmtAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import control.extractor.VarsBulkExtractor;
import dataflow.CFGEdge;
import dataflow.TransferFunction;
import dataflow.domain.VarDataType;
import execution.BaseStatefulInterpreterManager;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.interpreter.SymbolicStatefulStmtInterpreter;
import execution.parser.env.Environment;
import execution.parser.env.StoreImpl;
import execution.state.ExecutionState;
import execution.utils.Stepper;
import util.Configuration;
import util.FuncManager;
import util.pc.PathCondition;
import util.types.Storable;

import java.util.Set;

public class DTypeTransferFunction
implements TransferFunction<VarDataType>
{

   public DTypeTransferFunction()
   {
   }

   @Override
   public VarDataType get(CFGEdge edge, VarDataType input)
   {
      return get(edge.getInput().getTree(), input);
   }

   public VarDataType get(AST tree, VarDataType input)
   {
      if (!(tree instanceof ExprStmtAST)) // id = expr;
         return input;
      ExprStmtAST exprStmt = (ExprStmtAST) tree;
      if (!(exprStmt.getChild(0) instanceof AssignmentAST))
         return input;

      AssignmentAST assgn = (AssignmentAST) exprStmt.getChild(0);
      VarDataType ans = VarDataType.getAllTop().meet(input);
      String id = getId(assgn.getChild(0)); // factor
      DataTypeAST value = getExpr(assgn.getChild(1), input); // expresison
      if (value != null)
      {
         ans.put(id, new FiniteDataTypeSet(value));
      }

      return ans;
   }

   private String getId(AST tree)
   {
      VarsBulkExtractor extractor = new VarsBulkExtractor();
      Set<String> vars = extractor.extract(tree);
      return vars.iterator().next();
   }

   private DataTypeAST getExpr(AST tree, VarDataType current)
   {
      ExpressionAST ast = (ExpressionAST) tree;
      try
      {
         return ast.getDataType(s -> current.getDataType(s).unique());
      }
      catch (DTypeException e)
      {
         return null;
      }
   }
}
