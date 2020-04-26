package parser;

import execution.PreProcessing;
import grammar.alkLexer;
import grammar.alkParser;
import execution.Execution;
import execution.state.ExecutionState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.visitors.MainVisitor;
import util.Configuration;
import util.Payload;

/**
 * Responsible for one file parsing. It starts with one empty global environment and a predefined configuration.
 * This is basically the main part where visitors are fired for visiting the antlr4 parse tree.
 */
public class AlkParser {

    /* The main char stream meant to be parsed */
    private CharStream alkFile;

    /* Basic constructor meant to initialize the main char stream */
    public AlkParser(CharStream alkFile)
    {
        this.alkFile = alkFile;
    }

    public ParseTree execute()
    {
        return execute(new PreProcessing());
    }

    /**
     * Main entry point of the parsing process.
     */
    public ParseTree execute(PreProcessing preProcessing)
    {
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);

        ParseTree tree = parserAlk.main();
        preProcessing.exapandIncludes(tree);

        return tree;
    }
}
