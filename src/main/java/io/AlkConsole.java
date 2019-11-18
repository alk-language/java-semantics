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
    private CommandLine cmd;

    /**
     * Constructor based on in line arguments usually provided by a main method
     * TODO: move constructor logic to another function so the parsing of the arguments will be separate
     *
     * @param args
     * The arguments formatted in classic style like in the main method
     */
    public AlkConsole(String[] args)
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

        Option trace = new Option("t", "trace", false, "print stacktrace in case of exception");
        trace.setRequired(false);
        options.addOption(trace);

        CommandLineParser cmdparser = new DefaultParser();

        try
        {
            cmd = cmdparser.parse(options, args);
        }
        catch (ParseException e)
        {
            // TODO: find a way to pass this to the ErrorManager
            write("[ERROR]: The command line couldn't be parsed. " + e.getMessage());
            throw new AlkParseException(e);
        }
    }

    /**
     * Overrides the IOManager basic writing method
     *
     * @param text
     * The text meant to be displayed on stdout
     */
    @Override
    public void write(String text)
    {
        System.out.println(text);
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

    /**
     * Used for identifying the main alk file based on the command line
     *
     * @return
     * a File reference to the main alk file to be executed
     */
    @Override
    public File getAlkFile() {
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
}
