package impl.types.alkDouble;

import impl.types.AlkValue;

import java.math.BigDecimal;

public class UnaryDoubleHelper {
    private BigDecimal value;

    UnaryDoubleHelper(BigDecimal value)
    {
        this.value = value;
    }

    AlkValue positive()
    {
        return new AlkDouble(value);
    }

    AlkValue negative()
    {
        return new AlkDouble(value.negate());
    }
}
