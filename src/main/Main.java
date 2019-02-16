package main;

import impl.env.Environment;
import impl.visitors.ConfigVisitator;
import impl.visitors.MainVisitor;
import impl.visitors.StmtVisitor;
import impl.visitors.expression.ExpressionVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.*;
import grammar.*;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        Option input = new Option("i", "init", true, "initial configuration file path");
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
                CharStream initFile = CharStreams.fromPath(Paths.get(cmd.getOptionValue("init")));

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
            MainVisitor alkVisitor = new MainVisitor(e);
            alkVisitor.visit(tree);
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
            ;
        }
    }
}
