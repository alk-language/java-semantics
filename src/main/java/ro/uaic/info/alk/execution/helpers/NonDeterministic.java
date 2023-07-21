package ro.uaic.info.alk.execution.helpers;

import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.exeptions.FailureException;
import ro.uaic.info.alk.util.types.Storable;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class NonDeterministic
{
    private static final Random RAND = new Random();

    public static AlkInt getRandom(AlkValue valmax)
    {
        if (!(valmax instanceof AlkInt))
            throw new AlkException(AlkException.ERR_RANDOM_INT);

        AlkInt intValue = (AlkInt) valmax;
        AlkInt result = AlkInt.get(new BigInteger(intValue.bitLength(), RAND));
        while (result.compareTo(intValue) >= 0)
        {
            result = AlkInt.get(new BigInteger(intValue.bitLength(), RAND));
        }
        return result;
    }

    public static Storable choose(List<Storable> struct)
    {
        if (struct.size() == 0)
        {
            throw new FailureException();
        }

        int poz = RAND.nextInt(struct.size());
        return struct.get(poz);
    }
}
