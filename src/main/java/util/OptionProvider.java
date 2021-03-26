package util;

import org.apache.commons.cli.Options;

import java.io.File;

/**
 * A provider class for the options needed in one execution.
 */
public interface OptionProvider
{
    boolean hasMetadata();
    boolean hasExhaustive();
    File getAlkFile();
    boolean hasDebugMode();
    Integer getPrecision();
    boolean hasPrecision();
    boolean hasInput();
    String getInput();
    boolean hasVersion();
    Options getOptions();
    boolean hasHelp();
    boolean hasStaticVerif();
    String getConditionPath();
}
