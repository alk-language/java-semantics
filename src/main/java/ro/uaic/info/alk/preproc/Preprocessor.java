package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;

public interface Preprocessor
{
   AST preprocess(AST input);
}
