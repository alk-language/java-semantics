package ro.uaic.info.alk.parser;

import ro.uaic.info.alk.ast.AST;

import java.io.File;

public interface GeneralParser
{
   AST parse(File file);
   AST parse(String code);
   AST parseExpr(String expr);
}
