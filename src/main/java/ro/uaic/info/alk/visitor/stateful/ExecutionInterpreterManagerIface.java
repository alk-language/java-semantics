package ro.uaic.info.alk.visitor.stateful;

import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionResult;
import ro.uaic.info.alk.execution.state.ExecutionState;

public interface ExecutionInterpreterManagerIface
extends StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState>
{
}
