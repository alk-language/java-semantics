package execution.types;

import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.execution.types.*;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.uaic.info.alk.types.*;
import ro.uaic.info.alk.util.types.Storable;

import java.math.BigInteger;

class AlkStringTest
{

    @Test
    void get()
    {
        AlkString str = AlkString.get("a");
        Assertions.assertEquals(AlkString.EMPTY, AlkString.get(""));
        Assertions.assertEquals(AlkString.EMPTY.size(), AlkInt.ZERO);
        Assertions.assertEquals(AlkString.get("").size(), AlkInt.ZERO);
        Assertions.assertEquals(str.size(), AlkInt.ONE);
        Assertions.assertEquals(str.at(AlkInt.ZERO), AlkString.get("a"));
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < 1e6; i++)
        {
            x.append("a");
        }
        AlkString longStr = AlkString.get(x.toString());
        Assertions.assertEquals(longStr.size(), AlkInt.get(1000000));
    }

    @Test
    void equal()
    {
        Assertions.assertTrue(AlkString.EMPTY.equal(AlkString.get("")).isTrue());
        Assertions.assertTrue(AlkString.get("a").equal(AlkString.get("a")).isTrue());
        Assertions.assertTrue(AlkString.get("A").equal(AlkString.get("a")).isFalse());
        Assertions.assertTrue(AlkString.get("a").equal(AlkString.get("A")).isFalse());
        Assertions.assertTrue(AlkString.get("A").equal(AlkString.get("A")).isTrue());
        Assertions.assertTrue(AlkString.get("abc").equal(AlkString.get("abc")).isTrue());
        Assertions.assertTrue(AlkString.get("abc").equal(AlkString.get("abcd")).isFalse());
        Assertions.assertTrue(AlkString.get("abc").equal(AlkString.get("abd")).isFalse());
        Assertions.assertTrue(AlkString.get("abc").equal(AlkString.EMPTY).isFalse());
        Assertions.assertTrue(AlkString.get("abcd").equal(AlkString.get("abc")).isFalse());
        Assertions.assertTrue(AlkString.get("abcd").equal(AlkString.get("abcd")).isTrue());
        Assertions.assertTrue(AlkString.get("abcd").equal(AlkString.get("abd")).isFalse());
        Assertions.assertTrue(AlkString.EMPTY.equal(AlkString.get("abc")).isFalse());

        Assertions.assertThrows(InvalidOperationException.class, () -> AlkString.get("a").equal(AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> AlkString.get("b").equal(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> AlkString.EMPTY.equal(new AlkArray()));
    }

    @Test
    void lower()
    {
        AlkString s1 = AlkString.EMPTY;
        AlkString s2 = AlkString.get("aB");
        AlkString s3 = AlkString.get("ab");
        AlkString s4 = AlkString.get("abc");

        Assertions.assertTrue(s1.lower(s1).isFalse());
        Assertions.assertTrue(s1.lower(s2).isTrue());
        Assertions.assertTrue(s1.lower(s3).isTrue());
        Assertions.assertTrue(s1.lower(s4).isTrue());

        Assertions.assertTrue(s2.lower(s1).isFalse());
        Assertions.assertTrue(s2.lower(s2).isFalse());
        Assertions.assertTrue(s2.lower(s3).isTrue());
        Assertions.assertTrue(s2.lower(s4).isTrue());

        Assertions.assertTrue(s3.lower(s1).isFalse());
        Assertions.assertTrue(s3.lower(s2).isFalse());
        Assertions.assertTrue(s3.lower(s3).isFalse());
        Assertions.assertTrue(s3.lower(s4).isTrue());

        Assertions.assertTrue(s4.lower(s1).isFalse());
        Assertions.assertTrue(s4.lower(s2).isFalse());
        Assertions.assertTrue(s4.lower(s3).isFalse());
        Assertions.assertTrue(s4.lower(s4).isFalse());

        Assertions.assertThrows(InvalidOperationException.class, () -> s1.lower(AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> s2.lower(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> s3.lower(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> s4.lower(new AlkArray()));
    }

    @Test
    void at()
    {
        AlkString empty = AlkString.EMPTY;
        Assertions.assertThrows(InvalidOperationException.class, () -> empty.at(AlkInt.ZERO));
        AlkString s0 = AlkString.get("a");
        Assertions.assertEquals(s0.at(AlkInt.ZERO), s0);
        Assertions.assertThrows(InvalidOperationException.class, () -> empty.at(AlkInt.ONE));
        Assertions.assertThrows(InvalidOperationException.class, () -> empty.at(AlkInt.get(-1)));
        Assertions.assertThrows(InvalidOperationException.class, () ->
            empty.at(AlkInt.get(new BigInteger("123456789123456789"))));

        Assertions.assertThrows(InvalidOperationException.class, () -> s0.at(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () -> s0.at(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> s0.at(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> s0.at(new AlkArray()));
    }

    @Test
    void split()
    {
        StoreImpl store = new StoreImpl();
        String intern = "one two three four";
        AlkString s0 = AlkString.get(intern);
        AlkArray arr = s0.split(store);
        Assertions.assertEquals(arr.size(), AlkInt.get(18));
        int i = 0;
        for (Storable value : arr)
        {
            Assertions.assertTrue(value.toRValue() instanceof AlkString);
            Assertions.assertEquals(value.toRValue(), s0.at(AlkInt.get(i)));
            Assertions.assertEquals(value.toRValue(), AlkString.get(String.valueOf(intern.charAt(i++))));
        }

        arr = s0.split(AlkString.get(" "), store);
        Assertions.assertEquals(arr.size(), AlkInt.get(4));
        Assertions.assertEquals(arr.at(AlkInt.get(0)), AlkString.get("one"));
        Assertions.assertEquals(arr.at(AlkInt.get(1)), AlkString.get("two"));
        Assertions.assertEquals(arr.at(AlkInt.get(2)), AlkString.get("three"));
        Assertions.assertEquals(arr.at(AlkInt.get(3)), AlkString.get("four"));

        Assertions.assertThrows(InvalidOperationException.class, () -> s0.split(AlkBool.TRUE, store));
        Assertions.assertThrows(InvalidOperationException.class, () -> s0.split(AlkFloat.get(BigInteger.ZERO), store));
        Assertions.assertThrows(InvalidOperationException.class, () -> s0.split(new AlkArray(), store));
    }

    @Test
    void insert()
    {
        AlkString a = AlkString.EMPTY;
        a = (AlkString) a.insert(AlkInt.ZERO, AlkString.get("c"));
        Assertions.assertEquals(a.size(), AlkInt.ONE);
        a = (AlkString) a.insert(AlkInt.ZERO, AlkString.get("a"));
        Assertions.assertEquals(a.size(), AlkInt.TWO);
        a = (AlkString) a.insert(AlkInt.ONE, AlkString.get("b"));
        Assertions.assertEquals(a.size(), AlkInt.get(3));
        Assertions.assertEquals(a, AlkString.get("abc"));
        a = (AlkString) a.insert(AlkInt.ONE, AlkString.get("xyz"));
        Assertions.assertEquals(a, AlkString.get("axyzbc"));
        a = (AlkString) a.insert(AlkInt.ONE, AlkString.EMPTY);
        Assertions.assertEquals(a, AlkString.get("axyzbc"));

        AlkString oob = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> oob.insert(AlkInt.get(-1), AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () -> oob.insert(AlkInt.get(10), AlkString.EMPTY));

        AlkString x = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(AlkBool.TRUE, AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(AlkFloat.get(BigInteger.ZERO), AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(new AlkArray(), AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(AlkInt.ZERO, AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(AlkInt.ZERO, AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.insert(AlkInt.ZERO, new AlkArray()));
    }

    @Test
    void update()
    {
        AlkString a = AlkString.get("ab");
        a = (AlkString) a.update(AlkInt.ZERO, AlkString.get("c"));
        Assertions.assertEquals(a.size(), AlkInt.TWO);
        Assertions.assertEquals(a.at(AlkInt.ZERO), AlkString.get("c"));
        Assertions.assertEquals(a.at(AlkInt.ONE), AlkString.get("b"));

        a = (AlkString) a.update(AlkInt.ONE, AlkString.get("c"));
        Assertions.assertEquals(a.size(), AlkInt.TWO);
        Assertions.assertEquals(a.at(AlkInt.ZERO), AlkString.get("c"));
        Assertions.assertEquals(a.at(AlkInt.ONE), AlkString.get("c"));

        final AlkString b = a;
        Assertions.assertThrows(InvalidOperationException.class, () -> b.update(AlkInt.ONE, AlkString.get("xy")));
        Assertions.assertThrows(InvalidOperationException.class, () -> b.update(AlkInt.ONE, AlkString.EMPTY));

        AlkString oob = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> oob.update(AlkInt.get(-1), AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () -> oob.update(AlkInt.get(3), AlkString.EMPTY));

        AlkString x = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> x.update(AlkBool.TRUE, AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.update(AlkFloat.get(BigInteger.ZERO), AlkInt.ZERO));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.update(new AlkArray(), AlkInt.ZERO));
    }

    @Test
    void removeAt()
    {
        AlkString a = AlkString.get("abc");
        a = (AlkString) a.removeAt(AlkInt.ZERO);
        Assertions.assertEquals(a.size(), AlkInt.TWO);
        Assertions.assertEquals(a.at(AlkInt.ZERO), AlkString.get("b"));
        Assertions.assertEquals(a.at(AlkInt.ONE), AlkString.get("c"));

        a = (AlkString) a.removeAt(AlkInt.ONE);
        Assertions.assertEquals(a.size(), AlkInt.ONE);
        Assertions.assertEquals(a.at(AlkInt.ZERO), AlkString.get("b"));

        AlkString x = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> x.removeAt(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.removeAt(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.removeAt(new AlkArray()));
    }

    @Test
    void size()
    {
        AlkString a = AlkString.EMPTY;
        AlkString b = AlkString.get("a");
        AlkString c = AlkString.get("abc def");

        Assertions.assertEquals(a.size(), AlkInt.ZERO);
        Assertions.assertEquals(b.size(), AlkInt.ONE);
        Assertions.assertEquals(c.size(), AlkInt.get(7));
    }

    @Test
    void add()
    {
        AlkString a = AlkString.get("ab");
        AlkString b = AlkString.get("xy");
        AlkString ab = a.add(b);
        Assertions.assertEquals(ab.size(), AlkInt.get(4));
        Assertions.assertEquals(ab.at(AlkInt.get(0)), AlkString.get("a"));
        Assertions.assertEquals(ab.at(AlkInt.get(1)), AlkString.get("b"));
        Assertions.assertEquals(ab.at(AlkInt.get(2)), AlkString.get("x"));
        Assertions.assertEquals(ab.at(AlkInt.get(3)), AlkString.get("y"));

        AlkString a2 = a.add(AlkString.EMPTY);
        Assertions.assertEquals(a, a2);
        AlkString b2 = b.add(AlkString.EMPTY);
        Assertions.assertEquals(b, b2);
        Assertions.assertEquals(AlkString.EMPTY.add(AlkString.EMPTY), AlkString.EMPTY);

        AlkString x = AlkString.get("a");
        Assertions.assertThrows(InvalidOperationException.class, () -> x.add(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.add(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> x.add(new AlkArray()));
    }
}