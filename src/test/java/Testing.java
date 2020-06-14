import execution.Execution;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import util.TestingConfiguration;

import java.io.IOException;
import java.nio.file.Paths;

class Testing {
    String run(String chapter, String input)
    {
        return run(chapter, input, 10);
    }

    CharStream getCorrect(String chapter, String test) throws IOException {
        return CharStreams.fromPath(Paths.get("tests/output/"+chapter+"/"+test+".out"));
    }

    String run(String chapter, String input, int precision)
    {
        TestingConfiguration config = new TestingConfiguration("tests/input/" + chapter + "/" + input + ".alk", precision);
        Execution exec = new Execution(config);
        exec.start();
        try {
            exec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return config.getOutput();
    }
}
