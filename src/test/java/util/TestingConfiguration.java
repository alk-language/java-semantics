package util;

import io.IOManager;
import org.apache.commons.cli.Options;

import java.io.File;

public class TestingConfiguration extends Configuration {

    StringBuilder sb = new StringBuilder();

    public TestingConfiguration(String alkFile) {
        super();
        IOManager io = new TestingIO(sb);
        OptionProvider op = new TestingOptionProvider(alkFile);

        ErrorManager em = new ErrorManager();
        em.attach(io);
        em.attach(op);

        super.attach(io);
        super.attach(em);
        super.importOptions(op);
    }

    public String getOutput() {
        return sb.toString();
    }
}

class TestingOptionProvider implements OptionProvider{

    String alkFile;

    public TestingOptionProvider(String alkFile) {
        this.alkFile = alkFile;
    }

    @Override
    public boolean hasMetadata() {
        return false;
    }

    @Override
    public boolean hasExhaustive() {
        return false;
    }

    @Override
    public File getAlkFile() {
        return new File(alkFile);
    }

    @Override
    public boolean hasDebugMode() {
        return false;
    }

    @Override
    public Integer getPrecision() {
        return 10;
    }

    @Override
    public boolean hasPrecision() {
        return false;
    }

    @Override
    public boolean hasInput() {
        return false;
    }

    @Override
    public File getInput() {
        return null;
    }

    @Override
    public boolean hasVersion() {
        return false;
    }

    @Override
    public Options getOptions() {
        return null;
    }

    @Override
    public boolean hasHelp() {
        return false;
    }
}

class TestingIO implements IOManager {

    StringBuilder sb;

    public TestingIO(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(String text) {
        sb.append(text).append('\n');
    }

    @Override
    public void flush() {
        // no-op
    }

    @Override
    public IOManager getEndpoint() {
        return this;
    }
}