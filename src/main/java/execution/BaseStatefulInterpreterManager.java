package execution;

import ast.AST;
import ast.expr.ExpressionAST;
import execution.interpreter.BaseStatefulExpressionInterpreter;
import execution.interpreter.BaseStatefulStmtInterpreter;
import execution.state.ExecutionState;
import util.Listener;
import visitor.stateful.StatefulInterpreterManager;
import visitor.stateful.StatefulExpressionVisitor;
import visitor.stateful.StatefulStmtVisitor;

import java.util.ArrayList;
import java.util.List;

public class BaseStatefulInterpreterManager
implements StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState>
{
    private final StatefulExpressionVisitor<ExecutionPayload, ExecutionState> expressionVisior;
    private final StatefulStmtVisitor<ExecutionPayload, ExecutionState> stmtVisior;

    private final List<Listener<ExecutionState>> listeners = new ArrayList<>();

    public BaseStatefulInterpreterManager() {
        this.expressionVisior = new StatefulExpressionVisitor<>();
        this.stmtVisior = new StatefulStmtVisitor<>();
    }

    @Override
    public ExecutionState interpret(AST tree, ExecutionPayload payload)
    {
        ExecutionState state;
        if (tree instanceof ExpressionAST)
        {
            expressionVisior.setInterpreter(new BaseStatefulExpressionInterpreter());
            expressionVisior.setPayload(payload);
            state = tree.accept(expressionVisior);

        }
        else
        {
            stmtVisior.setInterpreter(new BaseStatefulStmtInterpreter());
            stmtVisior.setPayload(payload);
            state = tree.accept(stmtVisior);
        }
        notify(state);
        return state;
    }

    public void registerListener(Listener<ExecutionState> listener)
    {
        this.listeners.add(listener);
    }

    public void notify(ExecutionState state)
    {
        for (Listener<ExecutionState> listener : listeners)
        {
            listener.notify(state);
        }
    }
}
