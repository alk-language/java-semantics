package symbolic;

import util.types.Storable;

public interface CPValue
extends Storable
{
    boolean equals(CPValue value);
}