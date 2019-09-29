package main;

@Deprecated
public class Main {

    public static void main(String[] args)
    {

        System.out.println("Deprecated!");
        return ;

        /*try {
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

            PreProcessing pre = new PreProcessing(file, new ArrayList<>());
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
        }*/
    }
}
