package ro.uaic.info.alk.util;

import java.math.BigDecimal;

public interface ProbabilityComputer {

    void interpretProbability(BigDecimal probab);

    BigDecimal getProbability();

}
