package main;

import impl.env.Environment;
import impl.exceptions.AlkException;
import impl.visitors.ConfigVisitator;
import impl.visitors.MainVisitor;
import impl.visitors.expression.ExpressionVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.*;
import grammar.*;
import org.apache.commons.cli.*;

import preprocessing.PreProcessing;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

import static impl.constants.Constants.DEBUG;

public class Main {

    public static void testExpression(ParseTree tree)
    {
        ExpressionVisitor exprVis = new ExpressionVisitor(new Environment());
        System.out.print(exprVis.visit(tree).toString());
    }

    public static void main( String[] args )
    {
        Options options = new Options();

        Option alk = new Option("a", "alk", true, "algorithm file path");
        alk.setRequired(true);
        options.addOption(alk);

        Option input = new Option("i", "init", true, "initial configuration");
        input.setRequired(false);
        options.addOption(input);

        CommandLineParser cmdparser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = cmdparser.parse(options, args);

            File file=new File(cmd.getOptionValue("alk"));
            InputStream alkInStr= new FileInputStream(file);
            CharStream alkFile = CharStreams.fromStream(alkInStr);

            Environment e = new Environment();

            if (cmd.getOptionValue("init") != null)
            {
                CharStream initFile;
                try {
                    initFile = CharStreams.fromPath(Paths.get(cmd.getOptionValue("init")));
                } catch (Exception exp)
                {
                    initFile = new ANTLRInputStream(cmd.getOptionValue("init"));
                }
                alkLexer lexerInit = new alkLexer(initFile);
                CommonTokenStream tokensInit = new CommonTokenStream(lexerInit);
                alkParser parserInit = new alkParser(tokensInit);
                ParseTree treeInit = parserInit.configuration();
                ConfigVisitator configVisitator = new ConfigVisitator(e);
                configVisitator.visit(treeInit);
            }

            PreProcessing pre = new PreProcessing(file, new ArrayList());
            pre.execute(e, true);

            alkLexer lexerAlk = new alkLexer(alkFile);
            CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
            alkParser parserAlk = new alkParser(tokensAlk);

            ParseTree tree = parserAlk.main();

            MainVisitor alkVisitor = new MainVisitor(e);
            alkVisitor.visit(tree);
            Output.printAll(e);
        }
        catch (ParseException e)
        {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (AlkException e) {
            System.out.println(e.message);
        }
        catch(RuntimeException e)
        {
            //e.printStackTrace();
        }
    }
}
