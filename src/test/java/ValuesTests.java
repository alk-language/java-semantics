import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuesTests extends Testing {

    String chapter = "values";

    @Test
    void integer() throws IOException {
        String test = "integer";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void _float() throws IOException {
        String test = "float";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void bool() throws IOException {
        String test = "bool";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void string() throws IOException {
        String test = "string";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void array() throws IOException {
        String test = "array";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void list() throws IOException {
        String test = "list";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void set() throws IOException {
        String test = "set";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

    @Test
    void structure() throws IOException {
        String test = "structure";
        CharStream correct = getCorrect(chapter, test);
        assertEquals(correct.toString(), run(chapter, test));
    }

}
