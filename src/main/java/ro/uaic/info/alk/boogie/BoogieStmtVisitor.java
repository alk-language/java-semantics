package ro.uaic.info.alk.boogie;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.stmt.*;
import ro.uaic.info.alk.ast.symbolic.IdDeclAST;
import ro.uaic.info.alk.ast.symbolic.SymbolicDeclsAST;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.visitor.SmallStepExpressionVisitor;
import ro.uaic.info.alk.visitor.ifaces.StmtVisitorIface;

import java.util.ArrayList;
import java.util.List;

public class BoogieStmtVisitor
implements StmtVisitorIface<String>
{
   private int ident = 0;
   private final SmallStepExpressionVisitor<String> exprVisitor;
   public List<String> variables = new ArrayList<>();

   public BoogieStmtVisitor(SmallStepExpressionVisitor<String> exprVisitor)
   {
      this.exprVisitor = exprVisitor;
   }

   @Override
   public String visit(AssertAST ctx)
   {
      return "assert " + ctx.getChild(0).accept(exprVisitor);
   }

   @Override
   public String visit(AssumeAST ctx)
   {
      return "assume " + ctx.getChild(0).accept(exprVisitor);
   }

   @Override
   public String visit(BlockAST ctx)
   {
      StringBuilder sb = new StringBuilder();
      sb.append(getIdent()).append("{\n");
      ident += 3;
      for (int i = 0; i < ctx.getChildCount(); i++)
      {
         sb.append(ctx.getChild(i).accept(this));
      }
      ident -= 3;
      sb.append(getIdent()).append("}\n");
      return sb.toString();
   }

   @Override
   public String visit(BreakAST ctx)
   {
      return null; // break
   }

   @Override
   public String visit(ChooseAST ctx)
   {
      // choose x in A s.t. f(x);
      // ==============
      // @havoc i : int;
      // @assume 0 <= i && i < A.size();
      // @assume f(A[i]);
      // x = A[i];

      // choose x in S s.t. f(x);
      // ==============
      // @havoc x
      // @assume x in S;
      // @assume f(A[i]);
      return null; // choose
   }

   @Override
   public String visit(ContinueAST ctx)
   {
      return null; // continue
   }

   @Override
   public String visit(DoWhileAST ctx)
   {
      return null; // WHILE
   }

   @Override
   public String visit(ExprStmtAST ctx)
   {
      return ctx.getChild(0).accept(exprVisitor) + ";\n";
   }

   @Override
   public String visit(FailureAST ctx)
   {
      return null; // @assert false;
   }

   @Override
   public String visit(ForEachAST ctx)
   {
      // WHILE
      return null;
   }

   @Override
   public String visit(ForAST ctx)
   {
      return null; // WHILE
   }

   @Override
   public String visit(FunctionDeclAST ctx)
   {
      throw new AlkException("Can't define functions inside other functions!");
   }

   @Override
   public String visit(HavocAST ctx)
   {
      return null;
   }

   @Override
   public String visit(IdDeclAST ctx)
   {
      return null;
   }

   @Override
   public String visit(IfThenAST ctx)
   {
      StringBuilder sb = new StringBuilder();
      sb.append("if (").append(ctx.getCondition().accept(exprVisitor)).append(")\n");
      sb.append(ctx.getThenBranch().accept(this));
      if (ctx.getElseBranch() != null)
      {
         sb.append(getIdent()).append("else\n");
         sb.append(ctx.getElseBranch().accept(this));
      }
      return sb.toString();
   }


   @Override
   public String visit(RepeatUntilAST ctx)
   {
      return null; // WHILE
   }

   @Override
   public String visit(ReturnAST ctx)
   {
      return "\\result := " + ctx.getChild(0).accept(exprVisitor) + ";\n" +
             getIdent() + "return ;\n";
   }

   @Override
   public String visit(StmtSeqAST ctx)
   {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < ctx.getChildCount(); i++)
      {
         sb.append(getIdent()).append(ctx.getChild(i).accept(this));
      }
      return sb.toString();
   }

   @Override
   public String visit(SuccessAST ctx)
   {
      return null; // @assert true;
   }

   @Override
   public String visit(SymbolicDeclsAST ctx)
   {
      return null; // @symbolic $a : int; ==> @havoc a : int;
   }

   @Override
   public String visit(UniformAST ctx)
   {
      return null; // TODO
   }

   @Override
   public String visit(VarAST ctx)
   {
      StringBuilder sb = new StringBuilder();
      boolean first = true;
      for (AST child : ctx.getChildren())
      {
         IdASTAttr attr = child.getAttribute(IdASTAttr.class);
         if (!first)
         {
            sb.append(",");
         }
         first = false;
         sb.append(attr.getId()).append(" : ").append(child.getChild(0).getText());
      }
      variables.add(sb.toString());
      return "";
   }

   @Override
   public String visit(WhileAST ctx)
   {
      return "while (" + ctx.getChild(0).accept(exprVisitor) + ")\n" +
         ctx.getChild(1).accept(this);
   }

   private String getIdent()
   {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < ident; i++)
      {
         sb.append(" ");
      }
      return sb.toString();
   }
}
