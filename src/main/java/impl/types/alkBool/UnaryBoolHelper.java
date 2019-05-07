package impl.types.alkBool;

public class UnaryBoolHelper {
    private Boolean value;

    UnaryBoolHelper(Boolean value)
    {
        this.value = value;
    }

    AlkBool not()
    {
        return new AlkBool(!value);
    }
}
