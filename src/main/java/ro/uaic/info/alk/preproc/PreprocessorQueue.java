package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;

import java.util.ArrayDeque;

public class PreprocessorQueue
extends ArrayDeque<Preprocessor>
{
   public AST run(AST root)
   {
      for (Preprocessor preproc : this)
      {
         root = preproc.preprocess(root);
      }

      return root;
   }
}
