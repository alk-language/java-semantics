import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageFeaturesTests extends Testing {

    String chapter = "language-features";

    @Test
    void arrofcharsTest() throws IOException {
        String test = "arrofchars";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void assgnsTest() throws IOException {
        String test = "assgns";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void boolopsTest() throws IOException {
        String test = "boolops";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void breakTest() throws IOException {
        String test = "break";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void continueTest() throws IOException {
        String test = "continue";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void convTest() throws IOException {
        String test = "conv";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void eqTest() throws IOException {
        String test = "eq";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void evensetTest() throws IOException {
        String test = "evenset";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void fctcallsTest() throws IOException {
        String test = "fctcalls";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void floatopsTest() throws IOException {
        String test = "floatops";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void globalsTest() throws IOException {
        String test = "globals";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void outparamTest() throws IOException {
        String test = "outparam";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }
}
