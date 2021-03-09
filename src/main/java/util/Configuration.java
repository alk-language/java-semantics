package util;

import execution.parser.constants.Constants;
import io.IOManager;
import org.apache.commons.cli.Options;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Responsible for registering important details regarding one execution.
 * I also serves as an option provider.
 */
public class Configuration
implements OptionProvider,
           AlgorithmTypeDetector,
           ProbabilityComputer
{
    /** The main file to be parsed */
    private File alkFile;

    private String input;

    /** The metadata flag, used to inform an IOManager if the metadata should be printed at the end */
    private boolean metadata;

    private boolean exhaustive;

    private boolean version;

    private boolean hasPrecision;

    private Integer precision;

    private Options options;

    private boolean help;

    private boolean staticVerif;

    /** The debugMode flag, used to print the stach trace in case of one exception*/
    private boolean debugMode;

    /** The IOManager used in the execution linked with this configuration */
    protected IOManager io;

    /** The ErrorManager used in the execution linked with this configuration*/
    protected ErrorManager em;

    /**
     * Used for identifying the main alk file based on the internal members
     *
     * @return
     * a File reference to the main alk file to be executed
     */
    @Override
    public File getAlkFile()
    {
        return alkFile;
    }

    /**
     * Used for identifying the debug mode flag based on the internal members
     *
     * @return
     * true if such option was set, false otherwise
     */
    @Override
    public boolean hasDebugMode() {
        return debugMode;
    }

    @Override
    public Integer getPrecision() {
        return precision;
    }

    @Override
    public boolean hasPrecision() {
        return hasPrecision;
    }

    @Override
    public boolean hasInput() {
        return input != null;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public boolean hasVersion() {
        return version;
    }

    @Override
    public Options getOptions() {
        return options;
    }

    @Override
    public boolean hasHelp() {
        return help;
    }

    @Override
    public boolean hasStaticVerif()
    {
        return staticVerif;
    }

    /**
     * Used for identifying the metadata flag based on the internal members
     *
     * @return
     * true if such option was set, false otherwise
     */
    @Override
    public boolean hasMetadata() {
        return metadata;
    }

    @Override
    public boolean hasExhaustive() {
        return exhaustive;
    }

    /**
     * Used for attaching an ErrorManager to the execution with this configuration.
     * Works like a setter
     *
     * @param em
     * The error manager meant to be attached
     */
    public void attach(ErrorManager em) {
        this.em = em;
    }

    /**
     * Used for attaching an IOManager to the execution with this configuration.
     * Works like a setter
     *
     * @param io
     * The io manager meant to be attached
     */
    public void attach(IOManager io)
    {
        this.io = io;
    }

    /**
     * Used for importing options from another OptionProvider.
     *
     * @param op
     * The option provider whom options are meant to be copied
     */
    public void importOptions(OptionProvider op)
    {
        this.metadata = op.hasMetadata();
        this.alkFile = op.getAlkFile();
        this.debugMode = op.hasDebugMode();
        this.exhaustive = op.hasExhaustive();
        this.hasPrecision = op.hasPrecision();
        this.precision = op.getPrecision();
        this.input = op.getInput();
        this.version = op.hasVersion();
        this.options = op.getOptions();
        this.help = op.hasHelp();
        this.staticVerif = op.hasStaticVerif();
    }

    /**
     * Getter for the ErrorManager
     *
     * @return
     * Configuration's ErrorManager
     */
    public ErrorManager getErrorManager() {
        return em;
    }

    public IOManager getIOManager()
    {
        return io;
    }

    public Configuration clone() {
        Configuration copy = new Configuration();
        copy.importOptions(this);
        IOManager newIO = io.getEndpoint();
        copy.attach(newIO);
        ErrorManager newEm = em.getEndpoint();
        newEm.attach(newIO);
        copy.attach(newEm);
        return copy;
    }

    boolean probabilistic;
    boolean nonDeterministic;
    BigDecimal probability = BigDecimal.ONE;

    @Override
    public boolean isProbabilistic() {
        return probabilistic;
    }

    @Override
    public boolean nonDeterministic() {
        return nonDeterministic && !probabilistic;
    }

    @Override
    public void setProbabilistic(boolean probabilistic) {
        this.probabilistic = probabilistic;
    }

    @Override
    public void setNonDeterministic(boolean nonDeterministic) {
        this.nonDeterministic = nonDeterministic;
    }

    @Override
    public void interpretProbability(BigDecimal probab) {
        probability = probability.multiply(probab).setScale(Constants.MAX_DECIMALS, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal getProbability() {
        return probability;
    }
}
