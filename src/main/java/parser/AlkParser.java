package parser;

import grammar.alkLexer;
import grammar.alkParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.visitors.MainVisitor;
import util.Configuration;

/**
 * Responsible for one file parsing. It starts with one empty global environment and a predefined configuration.
 * This is basically the main part where visitors are fired for visiting the antlr4 parse tree.
 */
public class AlkParser {

    /* The main char stream meant to be parsed */
    private CharStream alkFile;

    /* The global environment initially empty */
    private Environment global = new Environment();

    /* Basic constructor meant to initialize the main char stream */
    public AlkParser(CharStream alkFile)
    {
        this.alkFile = alkFile;
    }

    /* Basic constructor meant to initialize the main char stream */
    @Deprecated
    public AlkParser(CharStream alkFile, Environment e)
    {
        this.alkFile = alkFile;
        this.global = e;
    }


    /**
     * Main entry point of the parsing process.
     * @param config
     * A predefined set of parameters under which the parser should run
     */
    public void execute(Configuration config)
    {
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);
        ParseTree tree = parserAlk.main();
        MainVisitor alkVisitor = new MainVisitor(global);
        alkVisitor.visit(tree);
    }

    /**
     * A getter for the global environmentenvironment.
     * @return
     * The global environment.
     */
    public Environment getGlobalEnvironment() {
        return global;
    }
}
