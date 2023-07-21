package ro.uaic.info.alk.parser;

import ro.uaic.info.alk.ast.AST;

import java.io.File;

public interface AlkParserIface
extends GeneralParser
{
   AST parseInit(String input);
}
