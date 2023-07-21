package ro.uaic.info.alk.util.pc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.BoolAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.ast.type.DataTypeProvider;
import com.microsoft.z3.Z3Exception;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.storage.LocationMapper;
import ro.uaic.info.alk.storage.LocationMapperIface;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.parser.AlkParser;
import ro.uaic.info.alk.parser.ParseTreeGlobals;
import ro.uaic.info.alk.smt.AlkSMTContext;
import ro.uaic.info.alk.symbolic.ASTSimplifier;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.exeptions.IncompleteASTException;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.*;

public class PathCondition
implements DataTypeProvider
{
    private final boolean verify;
    public PathConditionListenerHelper pclh;

    List<SymbolicValue> conditions = new ArrayList<>();
    Map<String, DataTypeAST> idTypes = new HashMap<>();
    private Set<String> implicitTypes = new HashSet<>();
    public AlkSMTContext alkCtx;

    public static PathCondition parse(String conditionPath, boolean verify)
    {
        AlkParser.ExpressionContext tree = (AlkParser.ExpressionContext) SimpleAlkParser.executeConditionPath(conditionPath);
        if (tree == null)
        {
            throw new AlkException("Syntax error in the path condition: " + conditionPath);
        }

        AST ast = ParseTreeGlobals.getParseExprVisitor().visit(tree);
        PathCondition cp = new PathCondition(verify);
        cp.add(new SymbolicValue(ast));
        return cp;
    }

    public PathCondition(boolean verify)
    {
        pclh = new PathConditionListenerHelper(this);
        this.verify = verify;
        if (verify)
        {
            alkCtx = new AlkSMTContext();
        }
    }

    public PathCondition(PathCondition copy, LocationMapper mapper)
    {
        this(copy.verify);
        for (Map.Entry<String, DataTypeAST> entry : copy.idTypes.entrySet())
        {
            this.setType(entry.getKey(), entry.getValue(), false);
        }
        this.implicitTypes = new HashSet<>(copy.implicitTypes);
        for (SymbolicValue value : copy.conditions)
        {
            this.add((SymbolicValue) value.weakClone(mapper));
        }
    }

    public boolean add(SymbolicValue symbolicValue)
    {
        conditions.add(symbolicValue);
        if (!verify)
        {
            return true;
        }
        return alkCtx.process(symbolicValue);
    }

    public void setType(String symId, DataTypeAST type, boolean prefix)
    {
        setType(symId, type, prefix, false);
    }

    public void setType(String symId, DataTypeAST type, boolean prefix, boolean implicit)
    {
        idTypes.put(prefix ? "$" + symId : symId, type);
        if (implicit)
        {
            implicitTypes.add(prefix ? "$" + symId : symId);
        }
        if (verify)
        {
            alkCtx.process(prefix ? "$" + symId : symId, type);
        }
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
        if (conditions.isEmpty())
        {
            for (int j=0; j < padding; j++)
            {
                sb.append(" ");
            }
            return sb.toString() + "true";
        }

        for (int i=0; i<conditions.size() - 1; i++)
        {
            for (int j=0; j < padding; j++)
            {
                sb.append(" ");
            }
            sb.append(conditions.get(i).toString()).append(" &&").append('\n');
        }

        for (int j=0; j < padding; j++)
        {
            sb.append(" ");
        }
        sb.append(conditions.get(conditions.size()-1));
        return sb.toString();
    }

    public Map<String, DataTypeAST> getIdTypes(boolean includeImplicit)
    {
        Map<String, DataTypeAST> types = new HashMap<>(idTypes);
        types.keySet().removeAll(implicitTypes);
        return types;
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
        if (!verify)
        {
            return true;
        }
        return alkCtx.isSatisfiable();
    }

    public boolean asserts(SymbolicValue symbolicValue)
    {
        simplify();
        if (!verify)
        {
            return true;
        }
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

    public boolean verifies()
    {
        return verify;
    }
}