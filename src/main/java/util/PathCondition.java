package util;

import ast.AST;
import execution.ExecutionPayload;
import execution.ExecutionResult;
import execution.parser.AlkParser;
import execution.parser.exceptions.AlkException;
import execution.state.ExecutionState;
import grammar.alkParser;
import parser.ParseTreeGlobals;
import symbolic.SymbolicValue;
import visitor.stateful.StatefulInterpreterManager;

import java.util.ArrayList;
import java.util.List;

public class PathCondition
{
    List<SymbolicValue> conditions = new ArrayList<>();

    public static PathCondition parse(String conditionPath,
                                      StatefulInterpreterManager<ExecutionPayload, ExecutionResult, ExecutionState> manager)
    {
        alkParser.ExpressionContext tree = (alkParser.ExpressionContext) AlkParser.executeConditionPath(conditionPath);
        if (tree == null)
        {
            throw new AlkException("Syntax error in condition path!");
        }

        AST ast = ParseTreeGlobals.getParseExprVisitor().visit(tree);
        PathCondition cp = new PathCondition();
        cp.add(new SymbolicValue(ast));
        return cp;
    }

    public void add(SymbolicValue symbolicValue)
    {
        conditions.add(symbolicValue);
    }

    @Override
    public String toString()
    {
        if (conditions.isEmpty())
        {
            return "true";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<conditions.size() - 1; i++)
        {
            sb.append(conditions.get(i).toString()).append(" && ");
        }
        sb.append(conditions.get(conditions.size()-1));
        return sb.toString();
    }

    public PathCondition makeClone()
    {
        PathCondition clone = new PathCondition();
        for (SymbolicValue value : conditions)
        {
            clone.add(value);
        }
        return clone;
    }
}
