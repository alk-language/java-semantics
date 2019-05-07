package impl;


import impl.constants.Constants;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class Parsing {

    private static BigDecimal probability = BigDecimal.ONE;

    public static void callRandom(BigInteger possiblePaths)
    {
        probability = probability.multiply(BigDecimal.ONE.divide(new BigDecimal(possiblePaths), Constants.MAX_DECIMALS, BigDecimal.ROUND_HALF_UP));
        probability = probability.setScale(Constants.MAX_DECIMALS, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getProbability() {
        return probability;
    }
}
