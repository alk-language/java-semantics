package io;

import org.apache.commons.cli.*;
import util.OptionProvider;
import util.exception.AlkParseException;

import java.io.File;

/**
 * Basic class for IO interaction with console
 * Also used as an OptionProvider due to command line acceptability
 */
public class AlkConsole implements IOManager, OptionProvider
{

    /* Internal used by the commons library to store information about the command line */
    private final CommandLine cmd;

    private final Options options = new Options();

    /**
     * Constructor based on in line arguments usually provided by a main method
     * TODO: move constructor logic to another function so the parsing of the arguments will be separate
     *
     * @param args
     * The arguments formatted in classic style like in the main method
     */
    public AlkConsole(String[] args)
    {
        Option alk = new Option("a", "alk", true, "the file including the algorithm to be executed");
        alk.setRequired(false);
        options.addOption(alk);

        Option input = new Option("i", "init", true, "set initial configuration to <arg> (string or file)");
        input.setRequired(false);
        options.addOption(input);

        Option metadata = new Option("m", "metadata", false, "display metadata (final configuration)");
        metadata.setRequired(false);
        options.addOption(metadata);

        Option precision = new Option("p", "precision", true, "set the precision; <arg> represents the number of decimals");
        precision.setRequired(false);
        options.addOption(precision);

        Option complexity = new Option("c", "complexity", false, "display complexity (inactive)");
        complexity.setRequired(false);
        options.addOption(complexity);

        /*Option output = new Option("o", "output", true, "output file name");
        output.setRequired(false);
        options.addOption(output);*/

        Option help = new Option("h", "help", false, "display help");
        help.setRequired(false);
        options.addOption(help);

        /*Option size = new Option("z", "size", true, "set maximum array size to <arg>");
        size.setRequired(false);
        options.addOption(size);*/

        Option version = new Option("v", "version", false, "display version");
        version.setRequired(false);
        options.addOption(version);

        Option runtimeverification = new Option("r", "runtimeverification", false, "runtime verification (inactive)");
        runtimeverification.setRequired(false);
        options.addOption(runtimeverification);

        Option staticverification = new Option("s", "staticverification", false, "static verification (inactive)");
        staticverification.setRequired(false);
        options.addOption(staticverification);

        Option trace = new Option("t", "trace", false, "print stacktrace in case of exception; debugging purposes");
        trace.setRequired(false);
        options.addOption(trace);

        Option exhaustive = new Option("e", "exhaustive", false, "trigger exhaustive mode");
        trace.setRequired(false);
        options.addOption(exhaustive);

        CommandLineParser cmdparser = new DefaultParser();

        try
        {
            String[] newArgs = new String[args.length];
            for (int i = 0; i < args.length; i++)
            {
                newArgs[i] = args[i].replace("\\s+", "");
            }

            cmd = cmdparser.parse(options, newArgs);
        }
        catch (ParseException e)
        {
            // TODO: find a way to pass this to the ErrorManager
            throw new AlkParseException("[ERROR]: The command line couldn't be parsed. " + e.getMessage());
        }
    }

    /**
     * Overrides the IOManager basic writing method
     *
     * @param text
     * The text meant to be displayed on stdout
     */
    @Override
    public synchronized void write(String text)
    {
        System.out.println(text);
    }

    @Override
    public void flush()
    {
        // no-op
    }

    /**
     * Used for identifying the metadata flag based on the command line
     *
     * @return
     * true if such option was set, false otherwise
     */
    @Override
    public boolean hasMetadata() {
        return cmd.hasOption("metadata");
    }

    @Override
    public boolean hasExhaustive() {
        return cmd.hasOption("exhaustive");
    }

    /**
     * Used for identifying the main alk file based on the command line
     *
     * @return
     * a File reference to the main alk file to be executed
     */
    @Override
    public File getAlkFile() {
        if (cmd.getOptionValue("alk") == null)
            return null;
        return new File(cmd.getOptionValue("alk"));
    }

    /**
     * Used for identifying the debug mode flag based on command line
     *
     * @return
     * true if such option was set, false otherwise
     */
    @Override
    public boolean hasDebugMode() {
        return cmd.hasOption("trace");
    }

    @Override
    public Integer getPrecision() {
        if (hasPrecision())
            return Integer.parseInt(cmd.getOptionValue("precision"));
        return null;
    }

    @Override
    public boolean hasPrecision() {
        return cmd.hasOption("precision");
    }

    @Override
    public boolean hasInput() {
        return cmd.hasOption("init");
    }

    @Override
    public String getInput() {
        return cmd.getOptionValue("init");
    }

    @Override
    public boolean hasVersion() {
        return cmd.hasOption("version");
    }

    @Override
    public Options getOptions() {
        return options;
    }

    @Override
    public boolean hasHelp() {
        return cmd.hasOption("help");
    }

    @Override
    public boolean hasStaticVerif() {
        return cmd.hasOption("staticverification");
    }

    public IOManager getEndpoint()
    {
        return this;
    }
}
