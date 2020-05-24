package util;

import java.math.BigDecimal;

public interface ProbabilityComputer {

    void interpretProbability(BigDecimal probab);

    BigDecimal getProbability();

}
