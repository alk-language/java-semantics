import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageFeaturesTests extends Testing {

    String chapter = "language-features";

    @Test
    void arrofcharsTest() throws IOException {
        String test = "arrofchars";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void assgnsTest() throws IOException {
        String test = "assgns";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void boolopsTest() throws IOException {
        String test = "boolops";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void convTest() throws IOException {
        String test = "conv";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void eqTest() throws IOException {
        String test = "eq";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void evensetTest() throws IOException {
        String test = "evenset";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void fctcallsTest() throws IOException {
        String test = "fctcalls";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void floatopsTest() throws IOException {
        String test = "floatops";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void globalsTest() throws IOException {
        String test = "globals";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void outparamTest() throws IOException {
        String test = "outparam";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }
}
