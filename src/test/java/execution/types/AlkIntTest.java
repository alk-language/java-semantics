package execution.types;

import ro.uaic.info.alk.execution.types.*;
import ro.uaic.info.alk.exeptions.DivisionByZeroException;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.uaic.info.alk.types.*;

import java.math.BigDecimal;
import java.math.BigInteger;

class AlkIntTest
{

    @Test
    void get()
    {
        Assertions.assertTrue(AlkInt.get(AlkFloat.get(BigInteger.ZERO)).equal(AlkFloat.get(BigInteger.ZERO)).isTrue());
        Assertions.assertTrue(AlkInt.get(AlkFloat.get(BigInteger.ONE)).equal(AlkFloat.get(BigInteger.ZERO)).isFalse());
        Assertions.assertTrue(AlkInt.get(AlkFloat.get(BigInteger.ZERO)).equal(AlkFloat.get(BigInteger.ONE)).isFalse());
        Assertions.assertTrue(AlkInt.get(AlkFloat.get(BigInteger.ONE)).equal(AlkFloat.get(BigInteger.ONE)).isTrue());

        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("1234.0"))),
                                AlkInt.get(1234));
        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("-1234.142"))),
                                AlkInt.get(-1234));
        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("1234.0"))),
                                AlkInt.get(BigInteger.valueOf(1234)));
        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("-1234.142"))),
                                AlkInt.get(BigInteger.valueOf(-1234)));
        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("1.3"))),
                                AlkInt.get(AlkFloat.get(new BigDecimal("1.2"))));
        Assertions.assertEquals(AlkInt.get(AlkFloat.get(new BigDecimal("-1234.142"))),
                                AlkInt.get(AlkFloat.get(new BigDecimal("-1234.0"))));

        Assertions.assertEquals(AlkInt.get(0), AlkInt.ZERO);
        Assertions.assertEquals(AlkInt.get(1), AlkInt.ONE);
        Assertions.assertEquals(AlkInt.get(1234), AlkInt.get(BigInteger.valueOf(1234)));
        Assertions.assertEquals(AlkInt.get(-1), AlkInt.get(BigInteger.valueOf(-1)));
        Assertions.assertEquals(AlkInt.get(BigInteger.valueOf(0)), AlkInt.get(BigInteger.ZERO));
        Assertions.assertEquals(AlkInt.get(BigInteger.valueOf(-10)), AlkInt.get(BigInteger.TEN).negative());
        Assertions.assertEquals(AlkInt.get(new BigInteger("123456789123456789")),
                                AlkInt.get(new BigInteger("123456789123456789")));
    }

    @Test
    void equal()
    {
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.get(-1234);
        AlkInt i3 = AlkInt.get(BigInteger.valueOf(123456789));
        AlkFloat f1 = AlkFloat.get(BigInteger.ONE);
        AlkFloat f2 = AlkFloat.get(BigDecimal.valueOf(-1234.0));
        AlkFloat f2WithDecs = AlkFloat.get(BigDecimal.valueOf(-1234.12));
        AlkFloat f3 = AlkFloat.get(BigInteger.valueOf(123456789));

        Assertions.assertTrue(i1.equal(AlkInt.get(1)).isTrue());
        Assertions.assertTrue(i1.equal(i1).isTrue());
        Assertions.assertTrue(i1.equal(i2).isFalse());
        Assertions.assertTrue(i1.equal(i3).isFalse());
        Assertions.assertTrue(i1.equal(f1).isTrue());
        Assertions.assertTrue(i1.equal(f2).isFalse());
        Assertions.assertTrue(i1.equal(f3).isFalse());

        Assertions.assertTrue(i2.equal(AlkInt.get(BigInteger.valueOf(-1234))).isTrue());
        Assertions.assertTrue(i2.equal(i1).isFalse());
        Assertions.assertTrue(i2.equal(i2).isTrue());
        Assertions.assertTrue(i2.equal(i3).isFalse());
        Assertions.assertTrue(i2.equal(f1).isFalse());
        Assertions.assertTrue(i2.equal(f2).isTrue());
        Assertions.assertTrue(i2.equal(f3).isFalse());

        // ensure same cast - always to float
        Assertions.assertTrue(i2.equal(f2WithDecs).isFalse());
        Assertions.assertTrue(f2WithDecs.equal(i2).isFalse());

        Assertions.assertTrue(i3.equal(AlkInt.get(123456789)).isTrue());
        Assertions.assertTrue(i3.equal(i1).isFalse());
        Assertions.assertTrue(i3.equal(i2).isFalse());
        Assertions.assertTrue(i3.equal(i3).isTrue());
        Assertions.assertTrue(i3.equal(f1).isFalse());
        Assertions.assertTrue(i3.equal(f2).isFalse());
        Assertions.assertTrue(i3.equal(f3).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i1.equal(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.equal(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.equal(new AlkArray()));
    }

    @Test
    void lower()
    {
        AlkInt i1 = AlkInt.get(-1234);
        AlkInt i2 = AlkInt.ONE;
        AlkInt i3 = AlkInt.get(BigInteger.valueOf(123456789));
        AlkFloat f2 = AlkFloat.get(BigDecimal.valueOf(-1));
        AlkFloat f3 = AlkFloat.get(BigInteger.valueOf(123456789));
        AlkFloat f4 = AlkFloat.get(BigDecimal.valueOf(123456789.12));

        Assertions.assertTrue(i1.lower(i2).isTrue());
        Assertions.assertTrue(i2.lower(i3).isTrue());
        Assertions.assertTrue(i1.lower(i3).isTrue());

        Assertions.assertTrue(i2.lower(i1).isFalse());
        Assertions.assertTrue(i3.lower(i2).isFalse());
        Assertions.assertTrue(i3.lower(i1).isFalse());

        Assertions.assertTrue(i1.lower(f2).isTrue() && f2.lower(i1).isFalse());
        Assertions.assertTrue(i1.lower(f3).isTrue() && f3.lower(i1).isFalse());
        Assertions.assertTrue(i1.lower(f4).isTrue() && f4.lower(i1).isFalse());

        Assertions.assertTrue(i2.lower(f3).isTrue() && f3.lower(i2).isFalse());
        Assertions.assertTrue(i2.lower(f4).isTrue() && f4.lower(i2).isFalse());

        Assertions.assertTrue(i3.lower(f4).isTrue() && f4.lower(i3).isFalse());

        Assertions.assertThrows(InvalidOperationException.class, () -> i1.lower(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.lower(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.lower(new AlkArray()));
    }

    @Test
    void bitwiseOr()
    {
        // TODO: negative numbers?
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.TWO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertTrue(i1.bitwiseOr(i2).equal(i3).isTrue());
        Assertions.assertTrue(i2.bitwiseOr(i1).equal(i3).isTrue());
        Assertions.assertTrue(i1.bitwiseOr(i3).equal(i3).isTrue());
        Assertions.assertTrue(i3.bitwiseOr(i1).equal(i3).isTrue());
        Assertions.assertTrue(i2.bitwiseOr(i3).equal(i3).isTrue());
        Assertions.assertTrue(i3.bitwiseOr(i2).equal(i3).isTrue());
        Assertions.assertTrue(i1.bitwiseOr(i1).equal(i1).isTrue());
        Assertions.assertTrue(i2.bitwiseOr(i2).equal(i2).isTrue());
        Assertions.assertTrue(i3.bitwiseOr(i3).equal(i3).isTrue());

        Assertions.assertTrue(i0.bitwiseOr(i1).equal(i1).isTrue());
        Assertions.assertTrue(i0.bitwiseOr(i2).equal(i2).isTrue());
        Assertions.assertTrue(i0.bitwiseOr(i3).equal(i3).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i0.bitwiseOr(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i1.bitwiseOr(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.bitwiseOr(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.bitwiseOr(new AlkArray()));
    }

    @Test
    void bitwiseXor()
    {
        // TODO: negative numbers?
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.TWO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertTrue(i1.bitwiseXor(i2).equal(i3).isTrue());
        Assertions.assertTrue(i2.bitwiseXor(i1).equal(i3).isTrue());
        Assertions.assertTrue(i1.bitwiseXor(i3).equal(i2).isTrue());
        Assertions.assertTrue(i3.bitwiseXor(i1).equal(i2).isTrue());
        Assertions.assertTrue(i2.bitwiseXor(i3).equal(i1).isTrue());
        Assertions.assertTrue(i3.bitwiseXor(i2).equal(i1).isTrue());
        Assertions.assertTrue(i1.bitwiseXor(i1).equal(i0).isTrue());
        Assertions.assertTrue(i2.bitwiseXor(i2).equal(i0).isTrue());
        Assertions.assertTrue(i3.bitwiseXor(i3).equal(i0).isTrue());

        Assertions.assertTrue(i0.bitwiseXor(i1).equal(i1).isTrue());
        Assertions.assertTrue(i0.bitwiseXor(i2).equal(i2).isTrue());
        Assertions.assertTrue(i0.bitwiseXor(i3).equal(i3).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i0.bitwiseXor(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i1.bitwiseXor(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.bitwiseXor(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.bitwiseXor(new AlkArray()));
    }

    @Test
    void bitwiseAnd()
    {
        // TODO: negative numbers?
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.TWO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertTrue(i1.bitwiseAnd(i2).equal(i0).isTrue());
        Assertions.assertTrue(i2.bitwiseAnd(i1).equal(i0).isTrue());
        Assertions.assertTrue(i1.bitwiseAnd(i3).equal(i1).isTrue());
        Assertions.assertTrue(i3.bitwiseAnd(i1).equal(i1).isTrue());
        Assertions.assertTrue(i2.bitwiseAnd(i3).equal(i2).isTrue());
        Assertions.assertTrue(i3.bitwiseAnd(i2).equal(i2).isTrue());
        Assertions.assertTrue(i1.bitwiseAnd(i1).equal(i1).isTrue());
        Assertions.assertTrue(i2.bitwiseAnd(i2).equal(i2).isTrue());
        Assertions.assertTrue(i3.bitwiseAnd(i3).equal(i3).isTrue());

        Assertions.assertTrue(i0.bitwiseAnd(i1).equal(i0).isTrue());
        Assertions.assertTrue(i0.bitwiseAnd(i2).equal(i0).isTrue());
        Assertions.assertTrue(i0.bitwiseAnd(i3).equal(i0).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i0.bitwiseAnd(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i1.bitwiseAnd(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.bitwiseAnd(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.bitwiseAnd(new AlkArray()));
    }

    @Test
    void shiftLeft()
    {
        // TODO: negative numbers?
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.TWO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertTrue(i1.shiftLeft(i2).equal(AlkInt.get(4)).isTrue());
        Assertions.assertTrue(i2.shiftLeft(i1).equal(AlkInt.get(4)).isTrue());
        Assertions.assertTrue(i1.shiftLeft(i3).equal(AlkInt.get(8)).isTrue());
        Assertions.assertTrue(i3.shiftLeft(i1).equal(AlkInt.get(6)).isTrue());
        Assertions.assertTrue(i2.shiftLeft(i3).equal(AlkInt.get(16)).isTrue());
        Assertions.assertTrue(i3.shiftLeft(i2).equal(AlkInt.get(12)).isTrue());
        Assertions.assertTrue(i1.shiftLeft(i1).equal(AlkInt.get(2)).isTrue());
        Assertions.assertTrue(i2.shiftLeft(i2).equal(AlkInt.get(8)).isTrue());
        Assertions.assertTrue(i3.shiftLeft(i3).equal(AlkInt.get(24)).isTrue());

        Assertions.assertTrue(i0.shiftLeft(i1).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i0.shiftLeft(i2).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i0.shiftLeft(i3).equal(AlkInt.get(0)).isTrue());

        Assertions.assertTrue(i1.shiftLeft(i0).equal(i1).isTrue());
        Assertions.assertTrue(i2.shiftLeft(i0).equal(i2).isTrue());
        Assertions.assertTrue(i3.shiftLeft(i0).equal(i3).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i0.shiftLeft(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i1.shiftLeft(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.shiftLeft(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.shiftLeft(new AlkArray()));
    }

    @Test
    void shiftRight()
    {
        // TODO: negative numbers?
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i1 = AlkInt.ONE;
        AlkInt i2 = AlkInt.TWO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertTrue(i1.shiftRight(i2).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i2.shiftRight(i1).equal(AlkInt.get(1)).isTrue());
        Assertions.assertTrue(i1.shiftRight(i3).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i3.shiftRight(i1).equal(AlkInt.get(1)).isTrue());
        Assertions.assertTrue(i2.shiftRight(i3).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i3.shiftRight(i2).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i1.shiftRight(i1).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i2.shiftRight(i2).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i3.shiftRight(i3).equal(AlkInt.get(0)).isTrue());

        Assertions.assertTrue(i0.shiftRight(i1).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i0.shiftRight(i2).equal(AlkInt.get(0)).isTrue());
        Assertions.assertTrue(i0.shiftRight(i3).equal(AlkInt.get(0)).isTrue());

        Assertions.assertTrue(i1.shiftRight(i0).equal(i1).isTrue());
        Assertions.assertTrue(i2.shiftRight(i0).equal(i2).isTrue());
        Assertions.assertTrue(i3.shiftRight(i0).equal(i3).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () -> i0.shiftRight(AlkFloat.get(BigInteger.ZERO)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i1.shiftRight(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i2.shiftRight(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.shiftRight(new AlkArray()));
    }

    @Test
    void divide()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);
        AlkFloat f1 = AlkFloat.get(BigInteger.ONE);
        AlkFloat f2 = AlkInt.get(-2).toFloat();

        Assertions.assertEquals(i_10.divide(i_10), AlkInt.ONE);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i_10.divide(i0));
        Assertions.assertEquals(i_10.divide(i3), i3.negative());
        Assertions.assertEquals(i_10.divide(f1), i_10.toFloat());
        Assertions.assertEquals(i_10.divide(f2), AlkInt.get(5).toFloat());

        Assertions.assertEquals(i0.divide(i_10), i0);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i0.divide(i0));
        Assertions.assertEquals(i0.divide(i3), i0);
        Assertions.assertEquals(i0.divide(f1), AlkFloat.get(BigInteger.ZERO));
        Assertions.assertEquals(i0.divide(f2), AlkFloat.get(BigInteger.ZERO));

        Assertions.assertEquals(i3.divide(i_10), i0);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i3.divide(i0));
        Assertions.assertEquals(i3.divide(i3), AlkInt.ONE);
        Assertions.assertEquals(i3.divide(f1), i3.toFloat());
        Assertions.assertEquals(i3.divide(f2), AlkFloat.get(BigDecimal.valueOf(-1.5)));

        Assertions.assertThrows(InvalidOperationException.class, () -> i_10.divide(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i0.divide(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.divide(new AlkArray()));
    }

    @Test
    void mod()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertEquals(i_10.mod(i_10), AlkInt.ZERO);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i_10.mod(i0));
        Assertions.assertEquals(i_10.mod(i3), AlkInt.get(-1));

        Assertions.assertEquals(i0.mod(i_10), i0);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i0.mod(i0));
        Assertions.assertEquals(i0.mod(i3), i0);

        Assertions.assertEquals(i3.mod(i_10), i3);
        Assertions.assertThrows(DivisionByZeroException.class, () -> i3.mod(i0));
        Assertions.assertEquals(i3.mod(i3), AlkInt.ZERO);

        Assertions.assertThrows(InvalidOperationException.class, () -> i_10.mod(AlkFloat.get(BigInteger.ONE)));
        Assertions.assertThrows(InvalidOperationException.class, () -> i0.mod(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.mod(new AlkArray()));
    }

    @Test
    void multiply()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);
        AlkFloat f1 = AlkFloat.get(BigInteger.ONE);
        AlkFloat f2 = AlkInt.get(-2).toFloat();

        Assertions.assertEquals(i_10.multiply(i_10), AlkInt.get(100));
        Assertions.assertEquals(i_10.multiply(i0), AlkInt.ZERO);
        Assertions.assertEquals(i_10.multiply(i3), AlkInt.get(-30));
        Assertions.assertEquals(i_10.multiply(f1), i_10.toFloat());
        Assertions.assertEquals(i_10.multiply(f2), AlkInt.get(20).toFloat());

        Assertions.assertEquals(i0.multiply(i_10), i0);
        Assertions.assertEquals(i0.multiply(i0), i0);
        Assertions.assertEquals(i0.multiply(i3), i0);
        Assertions.assertEquals(i0.multiply(f1), AlkFloat.get(BigInteger.ZERO));
        Assertions.assertEquals(i0.multiply(f2), AlkFloat.get(BigInteger.ZERO));

        Assertions.assertEquals(i3.multiply(i_10), AlkInt.get(-30));
        Assertions.assertEquals(i3.multiply(i0), i0);
        Assertions.assertEquals(i3.multiply(i3), AlkInt.get(9));
        Assertions.assertEquals(i3.multiply(f1), i3.toFloat());
        Assertions.assertEquals(i3.multiply(f2), AlkInt.get(-6).toFloat());

        Assertions.assertThrows(InvalidOperationException.class, () -> i_10.multiply(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i0.multiply(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.multiply(new AlkArray()));
    }

    @Test
    void add()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);
        AlkFloat f1 = AlkFloat.get(BigInteger.ONE);
        AlkFloat f2 = AlkInt.get(-2).toFloat();

        Assertions.assertEquals(i_10.add(i_10), AlkInt.get(-20));
        Assertions.assertEquals(i_10.add(i0), i_10);
        Assertions.assertEquals(i_10.add(i3), AlkInt.get(-7));
        Assertions.assertEquals(i_10.add(f1), AlkInt.get(-9).toFloat());
        Assertions.assertEquals(i_10.add(f2), AlkInt.get(-12).toFloat());

        Assertions.assertEquals(i0.add(i_10), i_10);
        Assertions.assertEquals(i0.add(i0), i0);
        Assertions.assertEquals(i0.add(i3), i3);
        Assertions.assertEquals(i0.add(f1), f1);
        Assertions.assertEquals(i0.add(f2), f2);

        Assertions.assertEquals(i3.add(i_10), AlkInt.get(-7));
        Assertions.assertEquals(i3.add(i0), i3);
        Assertions.assertEquals(i3.add(i3), AlkInt.get(6));
        Assertions.assertEquals(i3.add(f1), AlkInt.get(4).toFloat());
        Assertions.assertEquals(i3.add(f2), AlkFloat.get(BigInteger.ONE));

        Assertions.assertThrows(InvalidOperationException.class, () -> i_10.add(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i0.add(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.add(new AlkArray()));
    }

    @Test
    void subtract()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);
        AlkFloat f1 = AlkFloat.get(BigInteger.ONE);
        AlkFloat f2 = AlkInt.get(-2).toFloat();

        Assertions.assertEquals(i_10.subtract(i_10), AlkInt.ZERO);
        Assertions.assertEquals(i_10.subtract(i0), i_10);
        Assertions.assertEquals(i_10.subtract(i3), AlkInt.get(-13));
        Assertions.assertEquals(i_10.subtract(f1), AlkInt.get(-11).toFloat());
        Assertions.assertEquals(i_10.subtract(f2), AlkInt.get(-8).toFloat());

        Assertions.assertEquals(i0.subtract(i_10), i_10.negative());
        Assertions.assertEquals(i0.subtract(i0), i0);
        Assertions.assertEquals(i0.subtract(i3), i3.negative());
        Assertions.assertEquals(i0.subtract(f1), f1.negative());
        Assertions.assertEquals(i0.subtract(f2), f2.negative());

        Assertions.assertEquals(i3.subtract(i_10), AlkInt.get(13));
        Assertions.assertEquals(i3.subtract(i0), i3);
        Assertions.assertEquals(i3.subtract(i3), AlkInt.ZERO);
        Assertions.assertEquals(i3.subtract(f1), AlkInt.get(2).toFloat());
        Assertions.assertEquals(i3.subtract(f2), AlkInt.get(5).toFloat());

        Assertions.assertThrows(InvalidOperationException.class, () -> i_10.subtract(AlkString.get("abc")));
        Assertions.assertThrows(InvalidOperationException.class, () -> i0.subtract(AlkBool.TRUE));
        Assertions.assertThrows(InvalidOperationException.class, () -> i3.subtract(new AlkArray()));
    }

    @Test
    void positive()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertEquals(i_10.positive(), i_10);
        Assertions.assertEquals(i0.positive(), i0);
        Assertions.assertEquals(i3.positive(), i3);
    }

    @Test
    void negative()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);

        Assertions.assertEquals(i_10.negative(), AlkInt.get(10));
        Assertions.assertEquals(i0.negative(), AlkInt.ZERO);
        Assertions.assertEquals(i3.negative(), AlkInt.get(-3));
    }

    @Test
    void intValue()
    {
        AlkInt i_10 = AlkInt.get(-10);
        AlkInt i0 = AlkInt.ZERO;
        AlkInt i3 = AlkInt.get(3);
        AlkInt huge1 = AlkInt.get(new BigInteger("123456789123456789"));
        AlkInt huge2 = AlkInt.get(new BigInteger("-123456789123456789"));
        AlkInt small1 = AlkInt.get(new BigInteger("123456789"));
        AlkInt small2 = AlkInt.get(new BigInteger("-123456789"));

        i_10.intValue((e) -> Assertions.fail());
        i0.intValue((e) -> Assertions.fail());
        i3.intValue((e) -> Assertions.fail());

        Assertions.assertThrows(RuntimeException.class, () -> huge1.intValue(e -> {
            throw new RuntimeException();
        }));
        Assertions.assertThrows(RuntimeException.class, () -> huge2.intValue(e -> {
            throw new RuntimeException();
        }));
        Assertions.assertDoesNotThrow(() -> small1.intValue(e -> {
            throw new RuntimeException();
        }));
        Assertions.assertDoesNotThrow(() -> small2.intValue(e -> {
            throw new RuntimeException();
        }));
    }
}