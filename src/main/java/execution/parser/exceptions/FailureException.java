package execution.parser.exceptions;

public class FailureException extends UnwindException {

    public FailureException() {
        super("failure");
    }

    @Override
    public boolean isError() {
        return false;
    }
}