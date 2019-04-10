package main;

import impl.Parsing;
import impl.env.Environment;
import impl.env.Store;
import impl.exceptions.AlkWarning;
import impl.visitors.ConfigVisitator;
import impl.visitors.MainVisitor;
import impl.visitors.StmtVisitor;
import impl.visitors.expression.ExpressionVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.*;
import grammar.*;
import org.apache.commons.cli.*;
import preparsing.PreParsing;
import preparsing.visitors.PreMainVisitor;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static impl.constants.Constants.DEBUG;

public class Main {

    public static void testExpression(ParseTree tree)
    {
        ExpressionVisitor exprVis = new ExpressionVisitor(new Environment());
        System.out.print(exprVis.visit(tree).toString());
    }

    public static void parseDebug(CharStream alkFile)
    {

        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);

        ParseTree tree = parserAlk.main();
        Environment e = new Environment();
        MainVisitor alkVisitor = new MainVisitor(e);
        alkVisitor.visit(tree);
        System.out.println(e);
    }

    public static void main( String[] args )
    {
        if (DEBUG)
        {
            try {
                CharStream alkFile = CharStreams.fromPath(Paths.get("/home/alex/work/Alk/input/test.in"));
                parseDebug(alkFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch(RuntimeException e)
            {
                ;
            }
            System.exit(1);
        }
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

            alkLexer lexerAlk = new alkLexer(alkFile);
            CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
            alkParser parserAlk = new alkParser(tokensAlk);

            ParseTree tree = parserAlk.main();

            PreParsing data = new PreParsing();
            PreMainVisitor preMainVisitor = new PreMainVisitor(data);
            preMainVisitor.visit(tree);

            MainVisitor alkVisitor = new MainVisitor(e);
            alkVisitor.visit(tree);
            System.out.println(e);

            if (data.getType().equals("probabilist"))
                System.out.println("The probability for this execution is: " + Parsing.getProbability());
            else if (data.getType().equals("nedeterminist"))
                System.out.println("Note that the executed algorithm is nondeterministic.");
            AlkWarning.printAll();
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
        catch(RuntimeException e)
        {
            //e.printStackTrace();
        }
    }
}
