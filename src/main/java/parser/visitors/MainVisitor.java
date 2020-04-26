package parser.visitors;

import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.main.MainState;
import execution.state.main.StatementSeqState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import util.EnvironmentManager;
import util.Payload;

import java.util.Stack;


/**
 * This is the class responsible for parsing an Alk program, starting from the root.
 */
public class MainVisitor extends alkBaseVisitor<ExecutionState> {


    public static Environment global;

    private Payload payload;
    
    public MainVisitor(Environment global, Payload payload)
    {
        MainVisitor.global = global;
        this.payload = payload;
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStartPoint(alkParser.StartPointContext ctx)
    {
        return StateFactory.create(MainState.class, ctx, payload, global);
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        return StateFactory.create(StatementSeqState.class, ctx, payload, global);
    }
}
