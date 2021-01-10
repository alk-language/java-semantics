import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuesTests extends Testing {

    String chapter = "values";

    @Test
    void integer() throws IOException {
        String test = "integer";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void _float() throws IOException {
        String test = "float";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void bool() throws IOException {
        String test = "bool";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void string() throws IOException {
        String test = "string";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void array() throws IOException {
        String test = "array";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void list() throws IOException {
        String test = "list";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void set() throws IOException {
        String test = "set";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

    @Test
    void structure() throws IOException {
        String test = "structure";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

}
