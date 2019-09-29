import grammar.alkLexer;
import grammar.alkParser;
import parser.env.AlkFunction;
import parser.env.Environment;
import parser.visitors.MainVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

public class Testing {
    String run(String chapter, String input) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(out);
        System.setOut(stream);
        CharStream alkFile = CharStreams.fromPath(Paths.get("tests/input/"+chapter+"/"+input+".alk"));
        alkLexer lexerAlk = new alkLexer(alkFile);
        CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
        alkParser parserAlk = new alkParser(tokensAlk);
        ParseTree tree = parserAlk.main();
        Environment e = new Environment();
        AlkFunction.reset();
        MainVisitor alkVisitor = new MainVisitor(e);
        alkVisitor.visit(tree);
        return out.toString();
    }
    public CharStream getCorrect(String chapter, String test) throws IOException {
        return  CharStreams.fromPath(Paths.get("tests/output/"+chapter+"/"+test+".out"));
    }
}
