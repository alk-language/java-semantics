package util;

import org.apache.commons.cli.Options;

import java.io.File;

/**
 * A provider class for the options needed in one execution.
 */
public interface OptionProvider
{

    /**
     * Used for identifying the metadata flag
     *
     * @return
     * true if such option was set, false otherwise
     */
    boolean hasMetadata();


    boolean hasExhaustive();

    /**
     * Used for identifying the main alk file
     *
     * @return
     * a File reference to the main alk file to be executed
     */
    File getAlkFile();

    /**
     * Used for identifying the debug mode flag
     *
     * @return
     * true if such option was set, false otherwise
     */
    boolean hasDebugMode();

    Integer getPrecision();

    boolean hasPrecision();

    boolean hasInput();

    String getInput();

    boolean hasVersion();

    Options getOptions();

    boolean hasHelp();

    boolean hasStaticVerif();
}
