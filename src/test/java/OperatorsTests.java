import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorsTests extends Testing {

    String chapter = "operators";

    @Test
    void unary() throws IOException {
        String test = "unary";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void incdec() throws IOException {
        String test = "incdec";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void arithmetic() throws IOException {
        String test = "arithmetic";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void bitwise() throws IOException {
        String test = "bitwise";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void setwise() throws IOException {
        String test = "setwise";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void relational() throws IOException {
        String test = "relational";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void inclusive() throws IOException {
        String test = "inclusive";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void logical() throws IOException {
        String test = "logical";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void conditional() throws IOException {
        String test = "conditional";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }
}
