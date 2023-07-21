package ro.uaic.info.alk.visitor.stateful;

import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.state.ExecutionState;

public interface ExecutionExprInterpreter
extends StatefulExpressionInterpreter<ExecutionPayload, ExecutionState>
{
}
