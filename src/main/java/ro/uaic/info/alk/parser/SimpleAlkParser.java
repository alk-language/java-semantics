package ro.uaic.info.alk.parser;

import ro.uaic.info.alk.ast.AST;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.util.LanguageServerErrorListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Responsible for one file parsing, returning the parse tree after executing the execution.parser.
 */
public class SimpleAlkParser
implements AlkParserIface
{
    @Override
    public AST parse(File file)
    {
        try
        {
            return this.parse(new String(Files.readAllBytes(Paths.get(file.getAbsolutePath()))));
        }
        catch (IOException e)
        {
            throw new AlkException("File not found: " + file.getAbsolutePath());
        }
    }

    @Override
    public AST parse(String alkCode)
    {
        ParseTree tree = parseFromString(alkCode, ParsingTarget.CODE, false);
        return tree == null ? null : new AlkParseTreeVisitor().visit(tree);
    }

    @Override
    public AST parseExpr(String alkExpr)
    {
        ParseTree tree = parseFromString(alkExpr, ParsingTarget.EXPR, false);
        return tree == null ? null : new AlkParseTreeExprVisitor().visit(tree);
    }

    /**
     * Main entry point of the parsing process.
     * @param input
     *        The input code to be taken in consideration when generating the parse tree.
     * @return
     *        The parse tree resulted from parsing the file.
     */
    @Override
    public AST parseInit(String input)
    {
        ParseTree tree = parseFromString(input, ParsingTarget.INIT, false);
        return tree == null ? null : new AlkParseTreeExprVisitor().visit(tree);
    }

    private ParseTree parseFromString(String input,
                                      ParsingTarget target,
                                      boolean errorTolerant)
    {
        AlkLexer lexer = new AlkLexer(CharStreams.fromString(input));
        AlkParser parser = new AlkParser(new CommonTokenStream(lexer));

        if (errorTolerant)
        {
            parser.addErrorListener(new LanguageServerErrorListener());
        }

        ParseTree tree;
        switch (target)
        {
            case EXPR:
            case PATH_CONDITION:
                tree = parser.expression(); break;
            case INIT:
                tree = parser.configuration(); break;
            case CODE:
            default:
                tree = parser.main(); break;
        }

        if (parser.getNumberOfSyntaxErrors() != 0 && !errorTolerant)
        {
            return null;
        }

        return tree;
    }

    private enum ParsingTarget
    {
        CODE,
        EXPR,
        INIT,
        PATH_CONDITION
    }
}
