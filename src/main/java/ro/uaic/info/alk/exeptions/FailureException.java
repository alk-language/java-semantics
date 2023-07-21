package ro.uaic.info.alk.exeptions;

public class FailureException extends UnwindException {

    public FailureException() {
        super("failure");
    }

    @Override
    public boolean isError() {
        return false;
    }
}