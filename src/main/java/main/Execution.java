package main;

import grammar.alkLexer;
import grammar.alkParser;
import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.visitors.MainVisitor;
import util.exception.InternalException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import preprocessing.PreProcessing;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * The main class responsible for one alk file execution. It is implemented
 * under a thread paradigm to parallelize multiple file interpreting if needed.
 * It also wraps the data necessary for one execution only.
 */
public class Execution extends Thread
{

    /** The main configuration delivery instance.*/
    private Configuration config;

    /**
     * Constructor with specific configuration
     *
     * @param config
     * The configuration meant to be used for this execution
     */
    Execution(Configuration config) {
        this.config = config;
    }

    /**
     * The main method which fires the parsing
     *
     * @throws InternalException
     * An AlkException provided by the execution, or a wrapped non-runtime exception
     */
    private void execute() throws InternalException
    {
        ErrorManager em = config.getErrorManager();

        // get the main algorithm file and obtain the CharStream in order to be parsed
        File file = config.getAlkFile();
        InputStream alkInStr = null;
        CharStream alkFile = null;
        try
        {
            alkInStr = new FileInputStream(file);
            alkFile = CharStreams.fromStream(alkInStr);
        }
        catch (IOException e)
        {
            em.handleError(e, file.getPath());
        }

        // setup the initial environment
        Environment e = new Environment();

        // start preprocessing stage
        PreProcessing pre = null;
        try
        {
            pre = new PreProcessing(file, new ArrayList<>());
        }
        catch (AlkException ex)
        {
            em.handleError(ex);
        }
        pre.execute(e, true);

        // start parsing the main alk file
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);

        ParseTree tree = parserAlk.main();

        MainVisitor alkVisitor = new MainVisitor(e);
        alkVisitor.visit(tree);

        if (config.hasMetadata())
            Output.printAll(e);
    }

    /**
     * The entry point for the thread
     */
    @Override
    public void run()
    {
        try
        {
            execute();
        }
        catch (InternalException e)
        {
            OptionProvider op = config;
            if (op.hasDebugMode())
            {
                e.printStackTrace();
            }
        }
    }
}
