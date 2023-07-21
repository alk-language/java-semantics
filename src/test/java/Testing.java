import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulStmtInterpreter;
import org.antlr.v4.runtime.CharStreams;
import util.TestingConfiguration;

import java.io.IOException;
import java.nio.file.Paths;

public class Testing {
    String run(String chapter, String input)
    {
        return run(chapter, input, 10);
    }

    String getCorrect(String chapter, String test) throws IOException {
        return CharStreams.fromPath(Paths.get("tests/output/"+chapter+"/"+test+".out")).toString().replaceAll("\\r\\n", "\n");
    }

    String run(String chapter, String input, int precision)
    {
        TestingConfiguration config = new TestingConfiguration("tests/input/" + chapter + "/" + input + ".alk", precision);
        AlkExecution exec = new AlkExecution(config, new BaseStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        exec.start();
        try {
            exec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return config.getOutput();
    }
}
