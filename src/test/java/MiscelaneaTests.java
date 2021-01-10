import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiscelaneaTests extends Testing {

    String chapter = "miscelanea";

    @Test
    void dfsTest() throws IOException {
        String test = "dfs";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void dfsrecTest() throws IOException {
        String test = "dfsrec";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void gcdTest() throws IOException {
        String test = "gcd";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void gcdrecTest() throws IOException {
        String test = "gcdrec";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void logTest() throws IOException {
        String test = "log";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void platouTest() throws IOException {
        String test = "platou";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void primeTest() throws IOException {
        String test = "prime";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void qsortTest() throws IOException {
        String test = "qsort";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void sumTest() throws IOException {
        String test = "sum";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }
}
