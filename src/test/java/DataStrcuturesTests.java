import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataStrcuturesTests extends Testing {

    private String chapter = "data-structures";

    @Test
    void arraysTest() throws IOException {
        String test = "arrays";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void arraysofarraysTest() throws IOException {
        String test = "arraysofarrays";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void arraysofsequencesTest() throws IOException {
        String test = "arraysofsequences";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void intervalsTest() throws IOException {
        String test = "intervals";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void seqTest() throws IOException {
        String test = "seq";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void sequencesofarraysTest() throws IOException {
        String test = "sequencesofarrays";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void setsTest() throws IOException {
        String test = "sets";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void specsTest() throws IOException {
        String test = "specs";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void structuresTest() throws IOException {
        String test = "structures";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }


    @Test
    void structuresofstructuresTest() throws IOException {
        String test = "structuresofstructures";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }
}
