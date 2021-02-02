package execution.helpers;

import execution.parser.env.Location;
import execution.parser.exceptions.AlkException;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import execution.parser.exceptions.FailureException;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import static execution.parser.exceptions.AlkException.*;

public class NonDeterministic
{
    private static final Random RAND = new Random();

    public static AlkInt getRandom(AlkValue valmax)
    {
        if (!(valmax instanceof AlkInt))
            throw new AlkException(ERR_RANDOM_INT);

        AlkInt intValue = (AlkInt) valmax;
        BigInteger result = new BigInteger(intValue.value.bitLength(), RAND);
        while( result.compareTo(intValue.value) >= 0)
        {
            result = new BigInteger(intValue.value.bitLength(), RAND);
        }
        return new AlkInt(result);
    }

    public static Location choose(List<Location> struct)
    {
        if (struct.size() == 0)
        {
            throw new FailureException();
        }

        int poz = RAND.nextInt(struct.size());
        return struct.get(poz);
    }
}
