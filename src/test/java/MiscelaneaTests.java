import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiscelaneaTests extends Testing {

    String chapter = "miscelanea";

    @Test
    void dfsTest() throws IOException {
        String test = "dfs";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void dfsrecTest() throws IOException {
        String test = "dfsrec";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void gcdTest() throws IOException {
        String test = "gcd";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void gcdrecTest() throws IOException {
        String test = "gcdrec";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void logTest() throws IOException {
        String test = "log";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void platouTest() throws IOException {
        String test = "platou";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void primeTest() throws IOException {
        String test = "prime";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void qsortTest() throws IOException {
        String test = "qsort";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void sumTest() throws IOException {
        String test = "sum";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }
}
