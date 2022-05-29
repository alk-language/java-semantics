package execution.parser;

import execution.PreProcessing;
import grammar.alkLexer;
import grammar.alkParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.exceptions.AlkException;

import java.io.*;

/**
 * Responsible for one file parsing, returning the parse tree after executing the execution.parser.
 */
public class AlkParser
{
    /**
     * Main entry point of the parsing process.
     * @param input
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree executeInit(String input)
    {
        try
        {
            File file = new File(input);
            InputStream alkInStr= new FileInputStream(file);
            CharStream stream = CharStreams.fromStream(alkInStr);
            alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(stream)));
            ParseTree tree = parser.configuration();
            if (parser.getNumberOfSyntaxErrors() != 0)
            {
                return null;
            }
            return tree;
        }
        catch (IOException e)
        {
            // maybe it is inline
            try
            {
                InputStream alkInStr = new ByteArrayInputStream(input.getBytes());
                CharStream stream = CharStreams.fromStream(alkInStr);
                alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(stream)));
                ParseTree tree = parser.configuration();
                if (parser.getNumberOfSyntaxErrors() != 0)
                {
                    return null;
                }
                return tree;
            }
            catch (IOException ex)
            {
               throw new AlkException("Can't parse input");
            }
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
        return execute(alkFile, false);
    }

    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree execute(File alkFile, PreProcessing.PreProcessingContext context)
    {
        return execute(alkFile, false, false, PreProcessing.newContext(alkFile.getAbsolutePath()));
    }

    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree execute(File alkFile, boolean forExpression)
    {
        return execute(alkFile, forExpression, false, PreProcessing.newContext(alkFile.getAbsolutePath()));
    }

    /**
     * Main entry point of the parsing process.
     * @param alkFile
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    public static ParseTree execute(File alkFile, boolean forExpression, boolean errorTolerant)
    {
        return execute(alkFile, forExpression, errorTolerant, PreProcessing.newContext(alkFile.getAbsolutePath()));
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
    public static ParseTree execute(File alkFile, boolean forExpression, boolean errorTolerant, PreProcessing.PreProcessingContext context)
    {
        try
        {
            InputStream alkInStr= new FileInputStream(alkFile);
            CharStream file = CharStreams.fromStream(alkInStr);
            ParseTree tree;
            alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(file)));
            if (forExpression)
                tree = parser.expression();
            else
                tree = parser.main();

            if (parser.getNumberOfSyntaxErrors() != 0 && !errorTolerant)
            {
                return null;
            }
            PreProcessing.expandIncludes(context, tree);
            return tree;
        }
        catch (IOException e)
        {
            throw new AlkException("Can't find file to parse!");
        }
    }

    /**
     * Main entry point of the parsing process.
     * @param alkExpression
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the expression.
     */
    public static ParseTree execute(String alkExpression)
    {
        CharStream expression = CharStreams.fromString(alkExpression);
        alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(expression)));
        ParseTree tree = parser.expression();

        if (parser.getNumberOfSyntaxErrors() != 0)
        {
            return null;
        }
        return tree;
    }

    public static Object executeConditionPath(String conditionPath)
    {
        try
        {
            File file = new File(conditionPath);
            InputStream alkInStr= new FileInputStream(file);
            CharStream stream = CharStreams.fromStream(alkInStr);
            alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(stream)));
            ParseTree tree = parser.configuration();
            if (parser.getNumberOfSyntaxErrors() != 0)
            {
                return null;
            }
            return tree;
        }
        catch (IOException e)
        {
            // maybe it is inline
            try
            {
                InputStream alkInStr = new ByteArrayInputStream(conditionPath.getBytes());
                CharStream stream = CharStreams.fromStream(alkInStr);
                alkParser parser = new alkParser(new CommonTokenStream(new alkLexer(stream)));
                ParseTree tree = parser.expression();
                if (parser.getNumberOfSyntaxErrors() != 0)
                {
                    return null;
                }
                return tree;
            }
            catch (IOException ex)
            {
                throw new AlkException("Can't parse condition path");
            }
        }
    }
}
