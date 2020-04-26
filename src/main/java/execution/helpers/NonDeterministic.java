package execution.helpers;

import parser.env.Location;
import parser.exceptions.AlkException;
import execution.types.AlkIterableValue;
import execution.types.AlkValue;
import execution.types.alkInt.AlkInt;
import parser.exceptions.FailureException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static parser.exceptions.AlkException.*;

public class NonDeterministic {

    // generated random value
    public static AlkInt getRandom(AlkValue valmax) throws AlkException {
        if (!valmax.type.equals("Int"))
            throw new AlkException(ERR_RANDOM_INT);
        AlkInt intValue = (AlkInt) valmax;
        Random rand = new Random();
        BigInteger result = new BigInteger(intValue.value.bitLength(), rand);
        while( result.compareTo(intValue.value) >= 0 ) {
            result = new BigInteger(intValue.value.bitLength(), rand);
        }
        return new AlkInt(result);
    }

    public static Location choose(List<Location> struct) {
        if (struct.size() == 0)
        {
            throw new FailureException();
        }
        Random rand = new Random();
        int poz = rand.nextInt(struct.size());
        return struct.get(poz);
    }
}
