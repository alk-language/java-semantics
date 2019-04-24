import grammar.alkLexer;
import grammar.alkParser;
import impl.env.Environment;
import impl.visitors.MainVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataStrcuturesTests {

    String run(String input) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        CharStream alkFile = CharStreams.fromPath(Paths.get("tests/input/data-structures/"+input+".alk"));
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);
        ParseTree tree = parserAlk.main();
        Environment e = new Environment();
        MainVisitor alkVisitor = new MainVisitor(e);
        alkVisitor.visit(tree);
        return out.toString();
    }

    @Test
    void arraysTest() throws IOException {
        String test = "arrays";
        CharStream correct = CharStreams.fromPath(Paths.get("tests/output/data-structures/"+test+".out"));
        assertEquals(correct.toString(), run(test));
    }
}
