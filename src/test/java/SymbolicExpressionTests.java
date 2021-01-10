import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolicExpressionTests extends SymbolicTesting
{
    String chapter = "symbolic-expressions";

    @Test
    void integerExprTest() throws IOException {
        String test = "integer_expr";
        String correct = getCorrect(chapter, test);
        assertEquals(correct, run(chapter, test));
    }

}
