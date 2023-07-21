package ro.uaic.info.alk.main;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulStmtInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulStmtInterpreter;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.exeptions.AlkParseException;

import static ro.uaic.info.alk.main.DriverHelper.initManagers;

/**
 * An entry point for a basic execution of one single alk file.
 * The configuration is provided by the command line.
 * The IO will also be handled by the console.
 */
public class ExecutionDriver
{
    /**
     * Main entry point into the ExecutionDriver
     *
     * @param args
     * The command line arguments
     */
    public static void main(String[] args)
    {
        AlkConfiguration config;
        try
        {
            config = DriverHelper.initManagers(args, true);
        }
        catch (AlkParseException e)
        {
            System.out.println(e.getMessage());
            return;
        }


        AlkExecution exec;

        if (config.hasStaticVerif())
            exec = new AlkExecution(config, new SymbolicStatefulExpressionInterpreter(), new SymbolicStatefulStmtInterpreter());
        else if (config.isDebugger())
        {
            exec = new AlkExecution(config, new BaseStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        }
        else
        {
            exec = new AlkExecution(config, new BaseStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        }
        exec.start();
    }

}
