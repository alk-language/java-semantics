package execution.state.symbolic;

import ast.AST;
import ast.expr.ConditionalExprAST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.exhaustive.SplitMapper;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import execution.types.alkBool.AlkBool;
import symbolic.SymbolicValue;
import util.exception.InternalException;
import util.types.Storable;

import static execution.parser.exceptions.AlkException.ERR_CONDITIONAL_NO_BOOL;

public class SymbolicConditionalState
extends ExecutionState
{
    protected Storable queryExpression;
    protected SymbolicValue firstChild;
    protected SymbolicValue secondChild;
    protected boolean checkedQuery = false;
    boolean visitedFirst = false;
    boolean visitedSecond = false;
    boolean symbolicQuery = false;

    public SymbolicConditionalState(AST tree, ExecutionPayload executionPayload)
    {
        super(tree, executionPayload);
    }

    @Override
    public ExecutionState makeStep()
    {
        if (getResult() != null)
        {
            return null;
        }

        if (queryExpression == null)
        {
            if (!checkedQuery)
            {
                return request(tree.getChild(0));
            }
            else
            {
                throw new InternalException("Null value caught at ternary operator!");
            }
        }

        queryExpression = queryExpression.toRValue();

        if (queryExpression instanceof SymbolicValue)
        {
            symbolicQuery = true;
            if (!visitedFirst)
            {
                return request(tree.getChild(1));
            }

            if (!visitedSecond)
            {
                return request(tree.getChild(2));
            }

            AST valueAST = new ConditionalExprAST(null);
            valueAST.addChild(((SymbolicValue) queryExpression).toAST());
            valueAST.addChild(firstChild.toAST());
            valueAST.addChild(secondChild.toAST());
            setResult(new ExecutionResult(new SymbolicValue(valueAST)));
            return null;
        }

        if (!(queryExpression instanceof AlkBool))
        {
            super.handle(new AlkException(ERR_CONDITIONAL_NO_BOOL));
        }

        if (((AlkBool) queryExpression).isTrue())
        {
            return request(tree.getChild(1));
        }
        else
        {
            return request(tree.getChild(2));
        }
    }

    @Override
    public void assign(ExecutionResult result)
    {
        if (queryExpression == null)
        {
            checkedQuery = true;
            queryExpression = result.getValue();
        }
        else
        {
            if (symbolicQuery)
            {
                if (!visitedFirst)
                {
                    firstChild = SymbolicValue.toSymbolic(result.getValue().toRValue());
                    visitedFirst = true;
                }
                else if (!visitedSecond)
                {
                    secondChild = SymbolicValue.toSymbolic(result.getValue().toRValue());
                    visitedSecond = true;
                }
            }
            else
            {
                setResult(new ExecutionResult(result.getValue().toRValue()));
            }
        }
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        SymbolicConditionalState copy = new SymbolicConditionalState(tree, payload.clone(sm));
        if (queryExpression != null)
        {
            copy.queryExpression = queryExpression.weakClone(sm.getLocationMapper());
        }
        if (firstChild != null)
        {
            copy.firstChild = (SymbolicValue) firstChild.weakClone(sm.getLocationMapper());
        }
        if (secondChild != null)
        {
            copy.secondChild = (SymbolicValue) secondChild.weakClone(sm.getLocationMapper());
        }
        copy.checkedQuery = checkedQuery;
        copy.visitedFirst = visitedFirst;
        copy.visitedSecond = visitedSecond;
        copy.symbolicQuery = symbolicQuery;
        return super.decorate(copy, sm);
    }
}