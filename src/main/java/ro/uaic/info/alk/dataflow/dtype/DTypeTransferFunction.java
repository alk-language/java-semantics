package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.expr.ExpressionAST;
import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.control.extractor.VarsBulkExtractor;
import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.dataflow.TransferFunction;
import ro.uaic.info.alk.dataflow.domain.VarDataType;
import ro.uaic.info.alk.util.functions.Parameter;

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
      if (tree instanceof FunctionDeclAST)
      {
         return handleFunction((FunctionDeclAST) tree, input);
      }
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

   private VarDataType handleFunction(FunctionDeclAST tree, VarDataType input)
   {
      ParamASTAttr params = tree.getAttribute(ParamASTAttr.class);
      VarDataType ans = VarDataType.getAllTop().meet(input);
      for (int i = 0; i < params.getParamCount(); i++)
      {
         Parameter param = params.getParameter(i);
         String paramName = param.getName();
         DataTypeAST dt = param.getDataType();
         if (dt != null)
         {
            ans.put(paramName, new FiniteDataTypeSet(dt));
         }
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
