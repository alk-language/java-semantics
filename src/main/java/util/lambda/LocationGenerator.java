package util.lambda;

import parser.env.Location;
import execution.types.AlkValue;

public interface LocationGenerator {
    Location generate(AlkValue value);
}
