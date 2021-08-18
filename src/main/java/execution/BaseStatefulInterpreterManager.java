package execution;

import ast.AST;
import ast.attr.AnnoAttr;
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
            if (tree.hasAttribute(AnnoAttr.class))
            {
                expressionVisior.anno(tree);
            }
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

        return state;
    }

    @Override
    public StatefulInterpreterManager<T, S, U> makeClone()
    {
        return new BaseStatefulInterpreterManager<>(this.expressionVisior.getInterpreter(), this.stmtVisior.getInterpreter());
    }
}
