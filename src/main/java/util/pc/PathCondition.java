package util.pc;

import ast.AST;
import ast.expr.BoolAST;
import ast.type.DataTypeAST;
import ast.type.DataTypeProvider;
import com.microsoft.z3.Z3Exception;
import execution.parser.AlkParser;
import execution.parser.env.LocationMapper;
import execution.parser.env.LocationMapperIface;
import execution.parser.exceptions.AlkException;
import grammar.alkParser;
import parser.ParseTreeGlobals;
import smt.AlkSMTContext;
import symbolic.ASTSimplifier;
import symbolic.SymbolicValue;
import util.exception.IncompleteASTException;
import util.exception.InternalException;

import java.util.*;

public class PathCondition
implements DataTypeProvider
{
    public PathConditionListenerHelper pclh;

    List<SymbolicValue> conditions = new ArrayList<>();
    Map<String, DataTypeAST> idTypes = new HashMap<>();
    private final AlkSMTContext alkCtx = new AlkSMTContext();

    public static PathCondition parse(String conditionPath)
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

    public PathCondition()
    {
        pclh = new PathConditionListenerHelper(this);
    }

    public PathCondition(PathCondition copy, LocationMapper mapper)
    {
        this();
        for (Map.Entry<String, DataTypeAST> entry : copy.idTypes.entrySet())
        {
            this.copyId(entry.getKey(), entry.getValue(), false);
        }
        for (SymbolicValue value : copy.conditions)
        {
            this.add((SymbolicValue) value.weakClone(mapper));
        }
    }


    public boolean add(SymbolicValue symbolicValue)
    {
        conditions.add(symbolicValue);
        return alkCtx.process(symbolicValue);
    }

    public void copyId(String symId, DataTypeAST type, boolean prefix)
    {
        idTypes.put(prefix ? "$" + symId : symId, type);
        alkCtx.process(prefix ? "$" + symId : symId, type);
    }

    public void setType(String symId, DataTypeAST type, boolean prefix)
    {
        idTypes.put(prefix ? "$" + symId : symId, type);
        alkCtx.process(prefix ? "$" + symId : symId, type);
    }

    @Override
    public boolean equals(Object obj)
    {
        // TODO: doesn't cover all scenarios
        if (!(obj instanceof PathCondition)) return false;
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString()
    {
        return this.toString(0);
    }

    public String toString(int padding)
    {
        simplify();
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

    private void simplify()
    {
        LocationMapperIface lm = loc -> loc;
        ASTSimplifier simply = new ASTSimplifier(lm, true);
        List<SymbolicValue> newConditions = new ArrayList<>();
        for (SymbolicValue condition : conditions)
        {
            if (condition.toAST() instanceof BoolAST && condition.toAST().getText().equals("true"))
            {
                continue;
            }

            try
            {
                SymbolicValue val = new SymbolicValue(condition.toAST().accept(simply));
                newConditions.add(val);
            }
            catch (IncompleteASTException e)
            {
                newConditions.add(condition);
            }
        }
        conditions.clear();
        conditions.addAll(newConditions);
    }

    public boolean isSatisfiable()
    {
        simplify();
        return alkCtx.isSatisfiable();
    }

    public boolean asserts(SymbolicValue symbolicValue)
    {
        simplify();
        try
        {
            return alkCtx.asserts(symbolicValue);
        }
        catch (Z3Exception e)
        {
            throw new InternalException(e);
        }
    }

    @Override
    public DataTypeAST getDataType(String s)
    {
        if (!s.startsWith("$")) s = "$" + s;
        return idTypes.get(s);
    }
}