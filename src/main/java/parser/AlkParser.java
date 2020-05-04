package parser;

import execution.PreProcessing;
import grammar.alkLexer;
import grammar.alkParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import util.exception.InternalException;

import java.io.*;

/**
 * Responsible for one file parsing, returning the parse tree after executing the parser.
 */
public class AlkParser
{
    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree executeInit(File alkFile)
    {
        try {
            InputStream alkInStr= new FileInputStream(alkFile);
            CharStream file = CharStreams.fromStream(alkInStr);
            return new alkParser(new CommonTokenStream(new alkLexer(file))).configuration();
        } catch (IOException e) {
            throw new InternalException("Can't find file to parse!");
        }
    }

    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree execute(File alkFile)
    {
        return execute(alkFile, PreProcessing.newContext(alkFile.getAbsolutePath()));
    }

    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @param context
     *        The preProcessing context to be used for this file. This should be used when there
     *        is already a context which should be taken in consideration when preprocessing.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree execute(File alkFile, PreProcessing.PreProcessingContext context)
    {
        try {
            InputStream alkInStr= new FileInputStream(alkFile);
            CharStream file = CharStreams.fromStream(alkInStr);
            ParseTree tree = new alkParser(new CommonTokenStream(new alkLexer(file))).main();
            PreProcessing.expandIncludes(context, tree);
            return tree;
        } catch (IOException e) {
            throw new InternalException("Can't find file to parse!");
        }
    }
}
