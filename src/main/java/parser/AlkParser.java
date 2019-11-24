package parser;

import grammar.alkLexer;
import grammar.alkParser;
import execution.Execution;
import execution.state.ExecutionState;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import parser.visitors.MainVisitor;
import parser.visitors.StmtVisitor;
import parser.visitors.expression.ExpressionVisitor;
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

    /* The execution to which this parser is linked */
    private Execution execution;

    /* Basic constructor meant to initialize the main char stream */
    public AlkParser(CharStream alkFile)
    {
        this.alkFile = alkFile;
    }

    /* Basic constructor meant to initialize the main char stream */
    @Deprecated
    public AlkParser(CharStream alkFile, Environment e, Execution execution)
    {
        this.alkFile = alkFile;
        this.global = e;
        this.execution = execution;
    }


    /**
     * Main entry point of the parsing process.
     * @param config
     * A predefined set of parameters under which the parser should run
     */
    public ExecutionState execute (Configuration config)
    {
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);

        ParseTree tree = parserAlk.main();

        MainVisitor visitor = new MainVisitor(global);
        return (ExecutionState) visitor.visit(tree);
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
