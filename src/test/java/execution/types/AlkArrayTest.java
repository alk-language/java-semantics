package execution.types;

import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.Store;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.types.AlkArray;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkString;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class AlkArrayTest
{
    private final static int TEST_MAX_ARRAY = 100;
    private final Store store = new StoreImpl();

    @Test
    void shuffle()
    {
        AlkArray array = new AlkArray();
        array.pushBack(AlkInt.ZERO, store);
        array.pushBack(AlkInt.ONE, store);
        array.pushBack(AlkInt.TWO, store);
        AlkArray orig = array.clone(store);
        Assertions.assertTrue(array.equal(orig).isTrue());

        int times = 0;
        for (int i = 0; i < 100; i++)
        {
            Assertions.assertDoesNotThrow(array::shuffle);
            Assertions.assertEquals(array.size(), AlkInt.get(3));
            Assertions.assertTrue(array.has(AlkInt.ZERO));
            Assertions.assertTrue(array.has(AlkInt.ONE));
            Assertions.assertTrue(array.has(AlkInt.TWO));
            if (array.equal(orig).isTrue())
            {
                times++;
            }
        }
        Assertions.assertTrue(5 <= times && times <= 25); // may generate false-negative

        AlkArray emptyArray = new AlkArray();
        for (int i = 0; i < 10; i++)
        {
            Assertions.assertDoesNotThrow(emptyArray::shuffle);
            Assertions.assertEquals(emptyArray.size(), AlkInt.ZERO);
        }

        AlkArray largeArray = new AlkArray();

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray.pushBack(AlkInt.get(i), store);
            }
            AlkArray orig2 = largeArray.clone(store);
            Assertions.assertTrue(largeArray.equal(orig2).isTrue());
            for (int i = 0; i < 10; i++)
            {
                Assertions.assertDoesNotThrow(largeArray::shuffle);
                Assertions.assertEquals(largeArray.size(), AlkInt.get(AlkArray.MAX_ARRAY));
                Assertions.assertTrue(largeArray.equal(orig2).isFalse()); // may generate false-negative
            }
        });
    }

    @Test
    void push()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.push(AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);

        array.push(AlkInt.ONE, store);
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);

        array.push(AlkInt.TWO, store);
        Assertions.assertEquals(array.size(), AlkInt.get(3));
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(2)).toRValue(), AlkInt.TWO);

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray = new AlkArray();
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray.push(AlkInt.ZERO, store);
            }
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray.push(AlkInt.ZERO, store);
            });
        });
    }

    @Test
    void add()
    {
        AlkArray a = new AlkArray();
        a.push(AlkInt.ZERO, store);
        a.push(AlkInt.ONE, store);
        AlkArray b = new AlkArray();
        b.push(AlkInt.TWO, store);
        AlkArray c = new AlkArray();

        AlkArray concatAB = a.add(b, store);
        Assertions.assertEquals(concatAB.size(), AlkInt.get(3));
        Assertions.assertEquals(concatAB.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(concatAB.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(concatAB.at(AlkInt.get(2)).toRValue(), AlkInt.TWO);

        AlkArray concatAC = a.add(c, store);
        Assertions.assertEquals(concatAC.size(), AlkInt.TWO);
        Assertions.assertEquals(concatAC.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(concatAC.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);

        AlkArray concatCB = c.add(b, store);
        Assertions.assertEquals(concatCB.size(), AlkInt.ONE);
        Assertions.assertEquals(concatCB.at(AlkInt.get(0)).toRValue(), AlkInt.TWO);

        AlkArray concatCC = c.add(c, store);
        Assertions.assertEquals(concatCC.size(), AlkInt.ZERO);

        Assertions.assertThrows(InvalidOperationException.class, () -> a.add(AlkInt.TWO, store));

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray1 = new AlkArray();
            AlkArray largeArray2 = new AlkArray();
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray1.push(AlkInt.ZERO, store);
            }
            Assertions.assertDoesNotThrow(() -> {
                largeArray1.add(largeArray2, store);
            });
            largeArray2.push(AlkInt.ZERO, store);
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray1.add(largeArray2, store);
            });
        });
    }

    @Test
    void at()
    {
        AlkArray array = new AlkArray();
        Assertions.assertThrows(InvalidOperationException.class, () -> array.at(AlkInt.ZERO));

        array.push(AlkInt.ZERO, store);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertThrows(InvalidOperationException.class, () -> array.at(AlkInt.ONE));

        array.push(AlkInt.ONE, store);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);

        Assertions.assertThrows(InvalidOperationException.class, () -> array.at(AlkInt.TWO));
        Assertions.assertThrows(InvalidOperationException.class, () -> array.at(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () -> array.bracket(AlkInt.get(-1), store));
    }

    @Test
    void insert()
    {
        AlkArray array = new AlkArray();
        Assertions.assertThrows(InvalidOperationException.class, () ->
            array.insert(AlkInt.ONE, AlkInt.ZERO, store));
        Assertions.assertDoesNotThrow(() -> array.insert(AlkInt.ZERO, AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.ZERO), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.insert(AlkInt.ONE, AlkInt.TWO, store));
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.ZERO), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.ONE), AlkInt.TWO);

        Assertions.assertDoesNotThrow(() -> array.insert(AlkInt.ONE, AlkInt.ONE, store));
        Assertions.assertEquals(array.size(), AlkInt.get(3));
        Assertions.assertEquals(array.at(AlkInt.ZERO), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.ONE), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.TWO), AlkInt.TWO);

        Assertions.assertThrows(InvalidOperationException.class, () ->
            array.insert(AlkString.EMPTY, AlkInt.ONE, store));

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray = new AlkArray();
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray.push(AlkInt.ZERO, store);
            }
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray.insert(AlkInt.ONE, AlkInt.ONE, store);
            });
        });
    }

    @Test
    void pushBack()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);

        array.pushBack(AlkInt.ONE, store);
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);

        array.pushBack(AlkInt.TWO, store);
        Assertions.assertEquals(array.size(), AlkInt.get(3));
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(2)).toRValue(), AlkInt.TWO);

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray = new AlkArray();
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray.pushBack(AlkInt.ZERO, store);
            }
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray.pushBack(AlkInt.ZERO, store);
            });
        });
    }

    @Test
    void popBack()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ONE, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.TWO, store));
        Assertions.assertEquals(array.size(), AlkInt.get(3));

        Assertions.assertDoesNotThrow(array::popBack);
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);

        Assertions.assertDoesNotThrow(array::popBack);
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(array::popBack);
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertThrows(InvalidOperationException.class, array::popBack);
    }

    @Test
    void pushFront()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.pushFront(AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.pushFront(AlkInt.ONE, store));
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.pushFront(AlkInt.TWO, store));
        Assertions.assertEquals(array.size(), AlkInt.get(3));
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(2)).toRValue(), AlkInt.ZERO);

        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray = new AlkArray();
            for (int i = 0; i < TEST_MAX_ARRAY; i++)
            {
                largeArray.pushFront(AlkInt.ZERO, store);
            }
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray.pushFront(AlkInt.ZERO, store);
            });
        });
    }

    @Test
    void popFront()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ONE, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.TWO, store));
        Assertions.assertEquals(array.size(), AlkInt.get(3));

        Assertions.assertDoesNotThrow(array::popFront);
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(1)).toRValue(), AlkInt.TWO);

        Assertions.assertDoesNotThrow(array::popFront);
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.get(0)).toRValue(), AlkInt.TWO);

        Assertions.assertDoesNotThrow(array::popFront);
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertThrows(InvalidOperationException.class, array::popFront);
    }

    @Test
    void removeAt()
    {
        AlkArray array = new AlkArray();
        Assertions.assertThrows(InvalidOperationException.class, () -> array.removeAt(AlkInt.ZERO));

        Assertions.assertEquals(array.size(), AlkInt.ZERO);
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ONE, store));
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.TWO, store));
        Assertions.assertEquals(array.size(), AlkInt.get(3));

        Assertions.assertDoesNotThrow(() -> array.removeAt(AlkInt.ONE));
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertEquals(array.at(AlkInt.ZERO), AlkInt.ZERO);
        Assertions.assertEquals(array.at(AlkInt.ONE), AlkInt.TWO);

        Assertions.assertDoesNotThrow(() -> array.removeAt(AlkInt.ONE));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertEquals(array.at(AlkInt.ZERO), AlkInt.ZERO);

        Assertions.assertDoesNotThrow(() -> array.removeAt(AlkInt.ZERO));
        Assertions.assertEquals(array.size(), AlkInt.ZERO);

        Assertions.assertThrows(InvalidOperationException.class, () -> array.removeAt(AlkString.EMPTY));
    }

    @Test
    void size()
    {
        AlkArray array = new AlkArray();
        Assertions.assertEquals(array.size(), AlkInt.ZERO);
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertDoesNotThrow(() -> array.pushBack(AlkInt.ZERO, store));
        Assertions.assertEquals(array.size(), AlkInt.TWO);
        Assertions.assertDoesNotThrow(array::popBack);
        Assertions.assertEquals(array.size(), AlkInt.ONE);
        Assertions.assertDoesNotThrow(array::popBack);
        Assertions.assertEquals(array.size(), AlkInt.ZERO);
    }

    @Test
    void addAll()
    {
    }

    @Test
    void bracket()
    {
        AlkArray array = new AlkArray();

        array.push(AlkInt.ZERO, store);
        Assertions.assertEquals(array.bracket(AlkInt.get(0), store).toRValue(), AlkInt.ZERO);

        array.push(AlkInt.ONE, store);
        Assertions.assertEquals(array.bracket(AlkInt.get(0), store).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.bracket(AlkInt.get(1), store).toRValue(), AlkInt.ONE);

        Assertions.assertThrows(InvalidOperationException.class, () -> array.bracket(AlkString.EMPTY, store));
        Assertions.assertThrows(InvalidOperationException.class, () -> array.bracket(AlkInt.get(-1), store));
        Assertions.assertThrows(InvalidOperationException.class, () -> array.bracket(AlkInt.get(-1), store));

        Assertions.assertDoesNotThrow(() -> array.bracket(AlkInt.TWO, store).setValue(AlkInt.TWO));
        Assertions.assertEquals(array.size(), AlkInt.get(3));
        Assertions.assertEquals(array.bracket(AlkInt.get(0), store).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.bracket(AlkInt.get(1), store).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.bracket(AlkInt.get(2), store).toRValue(), AlkInt.TWO);

        Assertions.assertDoesNotThrow(() -> array.bracket(AlkInt.get(100), store).setValue(AlkInt.get(-1)));
        Assertions.assertEquals(array.size(), AlkInt.get(101));
        Assertions.assertEquals(array.bracket(AlkInt.get(0), store).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(array.bracket(AlkInt.get(1), store).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(array.bracket(AlkInt.get(2), store).toRValue(), AlkInt.TWO);
        for (int i = 3; i < 100; i++)
        {
            Assertions.assertTrue(array.bracket(AlkInt.get(i), store).isUnknown());
        }
        Assertions.assertEquals(array.bracket(AlkInt.get(100), store).toRValue(), AlkInt.get(-1));

        Assertions.assertThrows(InvalidOperationException.class, () -> {
            AlkArray largeArray = new AlkArray();
            largeArray.bracket(AlkInt.get(new BigInteger("123123123123123123123123123123123123")), store);
        });
        withArrayMaxSize(TEST_MAX_ARRAY, () ->
        {
            AlkArray largeArray = new AlkArray();
            Assertions.assertThrows(InvalidOperationException.class, () -> {
                largeArray.bracket(AlkInt.get(TEST_MAX_ARRAY), store);
            });
        });
    }

    @Test
    void weakClone()
    {
        StoreImpl a = new StoreImpl();
        StoreImpl b = new StoreImpl();

        AlkArray array = new AlkArray();
        array.pushBack(AlkInt.ZERO, a);
        array.pushBack(AlkInt.ONE, a);
        array.pushBack(AlkInt.TWO, a);

        LocationMapper mapper = new LocationMapper(a, b);
        a.getLocations().forEach((loc) -> mapper.put(loc, b.malloc().setValue(AlkInt.ONE)));

        AlkArray cloned = array.weakClone(mapper);
        Assertions.assertEquals(cloned.size(), AlkInt.get(3));
        Assertions.assertEquals(cloned.bracket(AlkInt.get(0), store).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(cloned.bracket(AlkInt.get(1), store).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(cloned.bracket(AlkInt.get(2), store).toRValue(), AlkInt.ONE);
    }

    @Test
    void testClone()
    {
        AlkArray array = new AlkArray();
        array.pushBack(AlkInt.ZERO, store);
        array.pushBack(AlkInt.ONE, store);
        array.pushBack(AlkInt.TWO, store);

        AlkArray cloned = (AlkArray) array.clone(store);
        array.popBack(); // test mutability
        array.bracket(AlkInt.ZERO, store).setValue(AlkString.EMPTY);
        Assertions.assertEquals(cloned.size(), AlkInt.get(3));
        Assertions.assertEquals(cloned.bracket(AlkInt.ZERO, store).toRValue(), AlkInt.ZERO);
        Assertions.assertEquals(cloned.bracket(AlkInt.ONE, store).toRValue(), AlkInt.ONE);
        Assertions.assertEquals(cloned.bracket(AlkInt.TWO, store).toRValue(), AlkInt.TWO);
        cloned.popBack();
        cloned.bracket(AlkInt.ZERO, store).setValue(AlkString.EMPTY);
        Assertions.assertEquals(array, cloned);
    }

    private void withArrayMaxSize(int size, Runnable code)
    {
        int oldSize = AlkArray.MAX_ARRAY;
        AlkArray.MAX_ARRAY = size;
        try
        {
            code.run();
        }
        finally
        {
            AlkArray.MAX_ARRAY = oldSize;
        }
    }
}