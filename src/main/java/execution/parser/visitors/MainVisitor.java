package execution.parser.visitors;

import execution.state.ExecutionState;
import ast.StateFactory;
import execution.state.main.MainState;
import execution.state.main.StatementSeqState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import execution.parser.env.Environment;
import execution.ExecutionPayload;


/**
 * This is the class responsible for parsing an Alk program, starting from the root.
 */
public class MainVisitor extends alkBaseVisitor<ExecutionState>
{
    public static Environment global;

    private ExecutionPayload executionPayload;
    
    public MainVisitor(Environment global, ExecutionPayload executionPayload)
    {
        MainVisitor.global = global;
        this.executionPayload = executionPayload;
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStartPoint(alkParser.StartPointContext ctx)
    {
        return StateFactory.create(MainState.class, ctx, executionPayload, global);
    }

    /**
     * Starts the execution of the specified Alk program.
     * @param ctx The root of the Alk program which needs to be executed.
     */
    @Override
    public ExecutionState visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        return StateFactory.create(StatementSeqState.class, ctx, executionPayload, global);
    }
}
