package main;

import impl.constants.Constants;
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

        Option metadata = new Option("m", "metadata", false, "metadata display");
        metadata.setRequired(false);
        options.addOption(metadata);

        Option precision = new Option("p", "precision", true, "precision set");
        precision.setRequired(false);
        options.addOption(precision);

        Option demonic = new Option("d", "demonic", false, "demonic execution");
        demonic.setRequired(false);
        options.addOption(demonic);

        Option complexity = new Option("c", "complexity", false, "complexity display");
        complexity.setRequired(false);
        options.addOption(complexity);

        Option output = new Option("o", "output", true, "output file name");
        output.setRequired(false);
        options.addOption(output);

        Option help = new Option("h", "help", false, "show help");
        help.setRequired(false);
        options.addOption(help);

        Option size = new Option("z", "size", true, "maximum array size");
        size.setRequired(false);
        options.addOption(size);

        Option version = new Option("v", "version", false, "display version");
        version.setRequired(false);
        options.addOption(version);

        Option runtimeverification = new Option("r", "runtimeverification", false, "runtime verification");
        runtimeverification.setRequired(false);
        options.addOption(runtimeverification);

        Option staticverification = new Option("s", "staticverification", false, "static verification");
        staticverification.setRequired(false);
        options.addOption(staticverification);

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

            if (cmd.getOptionValue("precision") != null)
            {
                Constants.MAX_DECIMALS = Integer.parseInt(cmd.getOptionValue("precision"));
            }

            if (cmd.hasOption("help"))
            {
                formatter.printHelp("help", options);
            }

            if (cmd.hasOption("version"))
            {
                System.out.println("The current version is: " + Constants.VERSION);
            }

            if (cmd.getOptionValue("size") != null)
            {
                Constants.MAX_ARRAY = Integer.parseInt(cmd.getOptionValue("size"));
            }

            if (cmd.getOptionValue("output") != null)
            {
                String url = cmd.getOptionValue("output");
                File file2 = new File(url);
                file2.createNewFile();
                System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(url)), true));
            }

            PreProcessing pre = new PreProcessing(file, new ArrayList());
            pre.execute(e, true);

            alkLexer lexerAlk = new alkLexer(alkFile);
            CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
            alkParser parserAlk = new alkParser(tokensAlk);

            ParseTree tree = parserAlk.main();

            MainVisitor alkVisitor = new MainVisitor(e);
            alkVisitor.visit(tree);

            if (cmd.hasOption("metadata"))
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
