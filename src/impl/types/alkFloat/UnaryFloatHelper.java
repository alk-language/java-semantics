package impl.types.alkFloat;

import impl.types.AlkValue;

import java.math.BigDecimal;

public class UnaryFloatHelper {
    private BigDecimal value;

    UnaryFloatHelper(BigDecimal value)
    {
        this.value = value;
    }

    AlkValue positive()
    {
        return new AlkFloat(value);
    }

    AlkValue negative()
    {
        return new AlkFloat(value.negate());
    }
}
