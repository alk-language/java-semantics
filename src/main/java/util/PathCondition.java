package util;

import ast.AST;
import ast.type.DataTypeAST;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathCondition
{
    List<SymbolicValue> conditions = new ArrayList<>();
    Map<String, DataTypeAST> idTypes = new HashMap<>();

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
        return this.toString(0);
    }

    public String toString(int padding)
    {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < padding; i++)
        {
            sb.append(" ");
        }
        if (conditions.isEmpty())
        {
            return sb.toString() + "true";
        }
        for (int i=0; i<conditions.size() - 1; i++)
        {
            sb.append(conditions.get(i).toString()).append(" && ");
        }
        sb.append(conditions.get(conditions.size()-1));
        sb.append(" (");
        List<String> types = new ArrayList<>();
        for (Map.Entry<String, DataTypeAST> entry : idTypes.entrySet())
        {
            types.add(entry.getKey() + " : " + entry.getValue());
        }
        sb.append(String.join(", ", types)).append(")");
        return sb.toString();
    }

    public void setType(String symId, DataTypeAST type)
    {
        idTypes.put("$" + symId, type);
    }

    public PathCondition makeClone()
    {
        PathCondition clone = new PathCondition();
        for (SymbolicValue value : conditions)
        {
            clone.add((SymbolicValue) value.clone(null));
        }
        clone.idTypes.putAll(this.idTypes);
        return clone;
    }

    @Override
    public boolean equals(Object obj)
    {
        // TODO: doesn't cover all scenarios
        if (!(obj instanceof PathCondition)) return false;
        return this.toString().equals(obj.toString());
    }

    public Map<String, DataTypeAST> getIdTypes()
    {
        return idTypes;
    }

    public List<SymbolicValue> getConditions()
    {
        return conditions;
    }
}
