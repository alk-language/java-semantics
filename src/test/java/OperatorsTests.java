import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorsTests extends Testing {

    String chapter = "operators";

    @Test
    void unary() throws IOException {
        String test = "unary";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void incdec() throws IOException {
        String test = "incdec";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void arithmetic() throws IOException {
        String test = "arithmetic";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void bitwise() throws IOException {
        String test = "bitwise";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void setwise() throws IOException {
        String test = "setwise";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void relational() throws IOException {
        String test = "relational";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void inclusive() throws IOException {
        String test = "inclusive";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void logical() throws IOException {
        String test = "logical";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void conditional() throws IOException {
        String test = "conditional";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }
}
