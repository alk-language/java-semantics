package main;

import execution.Execution;
import execution.interpreter.BaseStatefulExpressionInterpreter;
import execution.interpreter.BaseStatefulStmtInterpreter;
import execution.interpreter.SymbolicStatefulExpressionInterpreter;
import execution.interpreter.SymbolicStatefulStmtInterpreter;
import io.AlkConsole;
import io.BufferedIOWrapper;
import io.IOManager;
import util.Configuration;
import util.ErrorManager;
import util.OptionProvider;
import util.exception.AlkParseException;

import static main.DriverHelper.initManagers;

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
        Configuration config;
        try
        {
            config = initManagers(args, true);
        }
        catch (AlkParseException e)
        {
            System.out.println(e.getMessage());
            return;
        }


        Execution exec;

        if (config.hasStaticVerif())
            exec = new Execution(config, new SymbolicStatefulExpressionInterpreter(), new SymbolicStatefulStmtInterpreter());
        else if (config.isDebugger())
        {
            exec = new Execution(config, new BaseStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        }
        else
        {
            exec = new Execution(config, new BaseStatefulExpressionInterpreter(), new BaseStatefulStmtInterpreter());
        }
        exec.start();
    }

}
