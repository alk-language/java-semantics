package util.lambda;

import execution.parser.env.Location;
import execution.types.AlkValue;
import util.types.Value;

public interface LocationGenerator {
    Location generate(Value value);
}
