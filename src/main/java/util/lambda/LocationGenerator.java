package util.lambda;

import execution.parser.env.Location;
import util.types.Storable;

public interface LocationGenerator {
    Location generate(Storable value);
}
