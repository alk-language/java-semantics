package parser.exceptions;

public class FailureException extends UnwindException {

    public FailureException() {
        super(null);
    }

    @Override
    public boolean isError() {
        return false;
    }
}