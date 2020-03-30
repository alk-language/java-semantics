package parser.exceptions;

public class SuccessException extends UnwindException {

    public SuccessException() {
        super(null);
    }

    @Override
    public boolean isError() {
        return false;
    }
}
