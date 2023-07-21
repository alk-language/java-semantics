package execution.types;

import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.types.AlkString;
import ro.uaic.info.alk.exeptions.InvalidOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlkBoolTest
{
    @Test
    void get()
    {
        Assertions.assertSame(AlkBool.TRUE, AlkBool.get(true));
        Assertions.assertSame(AlkBool.FALSE, AlkBool.get(false));
    }

    @Test
    void isTrue()
    {
        Assertions.assertTrue(AlkBool.TRUE.isTrue());
        Assertions.assertFalse(AlkBool.FALSE.isTrue());
    }

    @Test
    void isFalse()
    {
        Assertions.assertTrue(AlkBool.FALSE.isFalse());
        Assertions.assertFalse(AlkBool.TRUE.isFalse());
    }

    @Test
    void logicalOr()
    {
        Assertions.assertTrue(AlkBool.FALSE.logicalOr(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.FALSE.logicalOr(AlkBool.TRUE).isTrue());
        Assertions.assertTrue(AlkBool.TRUE.logicalOr(AlkBool.FALSE).isTrue());
        Assertions.assertTrue(AlkBool.TRUE.logicalOr(AlkBool.TRUE).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.FALSE.logicalOr(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.TRUE.logicalOr(AlkInt.ZERO));
    }

    @Test
    void logicalAnd()
    {
        Assertions.assertTrue(AlkBool.FALSE.logicalAnd(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.FALSE.logicalAnd(AlkBool.TRUE).isFalse());
        Assertions.assertTrue(AlkBool.TRUE.logicalAnd(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.TRUE.logicalAnd(AlkBool.TRUE).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.FALSE.logicalAnd(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.TRUE.logicalAnd(AlkInt.ZERO));
    }

    @Test
    void not()
    {
        Assertions.assertTrue(AlkBool.FALSE.not().isTrue());
        Assertions.assertTrue(AlkBool.TRUE.not().isFalse());
    }

    @Test
    void equal()
    {
        Assertions.assertTrue(AlkBool.FALSE.equal(AlkBool.FALSE).isTrue());
        Assertions.assertTrue(AlkBool.FALSE.equal(AlkBool.TRUE).isFalse());
        Assertions.assertTrue(AlkBool.TRUE.equal(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.TRUE.equal(AlkBool.TRUE).isTrue());

        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.FALSE.equal(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.TRUE.equal(AlkInt.ZERO));
    }

    @Test
    void lower()
    {
        Assertions.assertTrue(AlkBool.FALSE.lower(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.FALSE.lower(AlkBool.TRUE).isTrue());
        Assertions.assertTrue(AlkBool.TRUE.lower(AlkBool.FALSE).isFalse());
        Assertions.assertTrue(AlkBool.TRUE.lower(AlkBool.TRUE).isFalse());

        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.FALSE.lower(AlkString.EMPTY));
        Assertions.assertThrows(InvalidOperationException.class, () ->
            AlkBool.TRUE.lower(AlkInt.ZERO));
    }
}