package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.execution.interpreter.BaseStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.BaseStatefulStmtInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulExpressionInterpreter;
import ro.uaic.info.alk.execution.interpreter.SymbolicStatefulStmtInterpreter;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.visitor.stateful.ExecutionExprInterpreter;
import ro.uaic.info.alk.visitor.stateful.ExecutionStmtInterpreter;

public class ExecutionInterpreter
extends BaseStatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState>
{
    public ExecutionInterpreter(boolean symbolic)
    {
        this(symbolic ? new SymbolicStatefulExpressionInterpreter() : new BaseStatefulExpressionInterpreter(),
             symbolic ? new SymbolicStatefulStmtInterpreter() : new BaseStatefulStmtInterpreter());
    }

    public ExecutionInterpreter(ExecutionExprInterpreter exprInterpreter,
                                ExecutionStmtInterpreter stmtInterpreter)
    {
        super(exprInterpreter, stmtInterpreter);
    }
}
