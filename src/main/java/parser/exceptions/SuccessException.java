package parser.exceptions;

public class SuccessException extends UnwindException {

    public SuccessException() {
        super("success");
    }

    @Override
    public boolean isError() {
        return false;
    }
}
