import execution.Execution;
import grammar.alkLexer;
import grammar.alkParser;
import parser.env.AlkFunction;
import parser.env.Environment;
import parser.env.Store;
import parser.visitors.MainVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Configuration;
import util.TestingConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Paths;

class Testing {
    String run(String chapter, String input)
    {
        TestingConfiguration config = new TestingConfiguration("tests/input/" + chapter + "/" + input + ".alk");
        Execution exec = new Execution(config);
        exec.start();
        try {
            exec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return config.getOutput();
    }

    CharStream getCorrect(String chapter, String test) throws IOException {
        return CharStreams.fromPath(Paths.get("tests/output/"+chapter+"/"+test+".out"));
    }
}
