package ro.uaic.info.alk.visitor.stateful;

import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.state.ExecutionState;

public interface ExecutionStmtInterpreter
extends StatefulStmtInterpreter<ExecutionPayload, ExecutionState>
{
}
