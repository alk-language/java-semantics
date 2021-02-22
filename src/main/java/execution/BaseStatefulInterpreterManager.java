package execution;

import ast.AST;
import ast.expr.ExpressionAST;
import state.Payload;
import state.Result;
import state.State;
import util.Listener;
import visitor.stateful.*;

import java.util.ArrayList;
import java.util.List;

public class BaseStatefulInterpreterManager<T extends Payload, S extends Result<?>, U extends State<T, S>>
implements StatefulInterpreterManager<T, S, U>
{
    private final StatefulExpressionVisitor<T, U> expressionVisior;
    private final StatefulStmtVisitor<T, U> stmtVisior;
    private final List<Listener<U>> listeners = new ArrayList<>();

    public BaseStatefulInterpreterManager(StatefulExpressionInterpreter<T, U> exprInterpreter,
                                          StatefulStmtInterpreter<T, U> stmtInterpreter)
    {
        this.expressionVisior = new StatefulExpressionVisitor<>();
        expressionVisior.setInterpreter(exprInterpreter);
        this.stmtVisior = new StatefulStmtVisitor<>();
        stmtVisior.setInterpreter(stmtInterpreter);
    }

    @Override
    public U interpret(AST tree, T payload)
    {
        U state;
        if (tree instanceof ExpressionAST)
        {
            expressionVisior.setPayload(payload);
            state = tree.accept(expressionVisior);
        }
        else
        {
            stmtVisior.setPayload(payload);
            state = tree.accept(stmtVisior);
        }
        if (state == null)
        {
            // automatic child aggregate
            return interpret(tree.getChild(tree.getChildCount() - 1), payload);
        }
        notify(state);
        return state;
    }

    public void registerListener(Listener<U> listener)
    {
        this.listeners.add(listener);
    }

    public void notify(U state)
    {
        for (Listener<U> listener : listeners)
        {
            listener.notify(state);
        }
    }
}
