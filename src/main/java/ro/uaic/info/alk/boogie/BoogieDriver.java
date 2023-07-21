package ro.uaic.info.alk.boogie;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTHelper;
import ro.uaic.info.alk.ast.attr.OpsASTAttr;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.enums.ParamType;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.ast.stmt.BlockAST;
import ro.uaic.info.alk.ast.stmt.ExprStmtAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.execution.AlkFunction;
import ro.uaic.info.alk.exeptions.AlkException;
import org.antlr.v4.runtime.tree.ParseTree;
import ro.uaic.info.alk.parser.ParseTreeGlobals;
import ro.uaic.info.alk.preproc.AlkPreprocessor;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.exeptions.AlkParseException;
import ro.uaic.info.alk.util.functions.Parameter;
import ro.uaic.info.alk.visitor.SmallStepExpressionVisitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ro.uaic.info.alk.main.DriverHelper.initManagers;

public class BoogieDriver
{
   public static void main(String[] args)
   {
      AlkConfiguration config;
      try
      {
         config = initManagers(args, true);
      }
      catch (AlkParseException e)
      {
         System.out.println(e.getMessage());
         return;
      }

      File file = config.getAlkFile();
      AST root = new SimpleAlkParser().parse(file);
      if (root == null)
      {
         throw new AlkException("Syntax error!");
      }
      root = new AlkPreprocessor().run(root);

      HashMap<String, String> renamer = new HashMap<>();
      SmallStepExpressionVisitor<String> exprVisitor = new SmallStepExpressionVisitor<>(
         new BoogieExpressionInterpreter(renamer)
      );

      StringBuilder sb = new StringBuilder();
      List<FunctionDeclAST> fncs = ASTHelper.getFunctions(root, false);
      for (FunctionDeclAST decl : fncs)
      {
         BoogieStmtVisitor stmtVisitor = new BoogieStmtVisitor(exprVisitor);
         AlkFunction func = AlkFunction.build(decl);
         sb.append("procedure ").append(func.getName()).append("(");
         boolean first =  true;
         List<Parameter> outParams = new ArrayList<>();
         for (Parameter param : func.getParams())
         {
            if (!first)
            {
               sb.append(", ");
            }
            first = false;
            if (param.getType() == ParamType.OUTPUT)
            {
               outParams.add(param);
            }
            renamer.put(param.getName(), "\\old_" + param.getName());
            sb.append("\\old_").append(param.getName()).append(": ")
              .append(BoogieHelper.asBoogieType(param.getDataType()));
         }
         sb.append(")");
         if (decl.getDataType() != null || !outParams.isEmpty())
         {
            sb.append(" returns (");
            first = true;
            if (decl.getDataType() != null)
            {
               sb.append("\\result: ").append(BoogieHelper.asBoogieType(decl.getDataType()));
               first = false;
            }
            for (Parameter param : outParams)
            {
               if (!first)
               {
                  sb.append(", ");
               }
               first = false;
               sb.append(param.getName()).append(": ").append(BoogieHelper.asBoogieType(param.getDataType()));
            }
            sb.append(")");
         }
         sb.append("\n");

         for (AST req : func.getRequires())
         {
            sb.append("requires ").append(req.accept(exprVisitor)).append(";\n");
         }

         renamer.clear();

         for (AST req : func.getEnsures())
         {
            sb.append("ensures ").append(req.accept(exprVisitor)).append(";\n");
         }

         BlockAST body;
         if (func.getBody() instanceof BlockAST)
         {
            body = (BlockAST) func.getBody();
         }
         else
         {
            // always wrap with {  }
            BlockAST block = new BlockAST(null);
            block.addChild(func.getBody());
            body = block;
         }

         for (Parameter param : func.getParams())
         {
            AST stmt = new ExprStmtAST(null);
            AST assignAST = new AssignmentAST(null);

            assignAST.addChild(new RefIDAST(param.getName()));
            assignAST.addChild(new RefIDAST("\\old_" + param.getName()));
            OpsASTAttr attr = new OpsASTAttr();
            attr.add(Operator.ASSIGN);
            assignAST.addAttribute(OpsASTAttr.class, attr);

            stmt.addChild(assignAST);
            body.getChild(0).addChild(0, stmt);
            if (param.getType() != ParamType.OUTPUT)
            {
               stmtVisitor.variables.add(param.getName() + " : " + BoogieHelper.asBoogieType(param.getDataType()));
            }
//            renamer.put(param.getName(), "\\old_" + param.getName());
         }

         String bodyCode = body.getChild(0).accept(stmtVisitor);
         sb.append("{\n");

         if (!stmtVisitor.variables.isEmpty())
            sb.append("var ").append(String.join(", ", stmtVisitor.variables)).append(";\n");
         sb.append(bodyCode);
         sb.append("}\n\n");
      }

      String boogieCode = sb.toString();
//      config.getIOManager().write(boodieCode);
//      config.getIOManager().flush();

      try
      {
         FileWriter fileWriter = new FileWriter("alk.bpl");
         BufferedWriter writer = new BufferedWriter(fileWriter);
         writer.write(boogieCode);
         writer.close();

         String path = System.getProperty("user.dir") + File.separator + "alk.bpl";
         String[] command = {"ro/uaic/info/alk/boogie", path};
         Process process = new ProcessBuilder(command)
            .directory(new File("/"))
            .inheritIO()
            .redirectErrorStream(true)
            .start();
         process.waitFor();

//         new File(path).delete();
      }
      catch (IOException | InterruptedException e)
      {
         throw new RuntimeException(e);
      }

   }

}
