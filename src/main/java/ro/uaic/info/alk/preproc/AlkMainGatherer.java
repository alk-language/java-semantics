package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.expr.FunctionCallAST;
import ro.uaic.info.alk.ast.stmt.*;
import ro.uaic.info.alk.util.Constants;
import ro.uaic.info.alk.exeptions.InternalException;

public class AlkMainGatherer
implements Preprocessor
{
   private final boolean addMainCall;

   public AlkMainGatherer(boolean addMainCall)
   {
      this.addMainCall = addMainCall;
   }

   @Override
   public AST preprocess(AST root)
   {
      if (!(root instanceof StmtSeqAST))
      {
         throw new InternalException("Bad main gatherer preprocessor usage!");
      }

      AST newRoot = new StmtSeqAST(root.getCtx());
      FunctionDeclAST mainFnc = new FunctionDeclAST(root.getCtx());
      mainFnc.addAttribute(ParamASTAttr.class, new ParamASTAttr());
      mainFnc.addAttribute(IdASTAttr.class, new IdASTAttr(Constants.MAIN_FNC));
      StmtSeqAST body = new StmtSeqAST(root.getCtx());
      mainFnc.addChild(body);
      for (int i = 0; i < root.getChildCount(); i++)
      {
         if (root.getChild(i) instanceof FunctionDeclAST)
         {
            newRoot.addChild(root.getChild(i));
            continue;
         }
         AST tree = root.getChild(i);
         body.addChild(tree);
      }
      newRoot.addChild(mainFnc);
      if (addMainCall)
      {
         AST exprStmt = new ExprStmtAST(root.getCtx());
         AST fncCall = new FunctionCallAST(root.getCtx());
         exprStmt.addChild(fncCall);
         fncCall.addAttribute(IdASTAttr.class, new IdASTAttr(Constants.MAIN_FNC));
         newRoot.addChild(fncCall);
      }
      return newRoot;
   }
}
