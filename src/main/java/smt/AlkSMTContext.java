package smt;

import ast.AST;
import ast.enums.BuiltInFunction;
import ast.enums.BuiltInMethod;
import ast.enums.Operator;
import ast.expr.BoolAST;
import ast.expr.BuiltinFunctionAST;
import ast.expr.FactorPointMethodAST;
import ast.expr.UnaryAST;
import ast.type.*;
import com.microsoft.z3.*;
import execution.parser.env.LocationMapperIface;
import execution.parser.exceptions.AlkException;
import symbolic.ASTSimplifier;
import symbolic.SymbolicValue;
import util.exception.IncompleteASTException;
import util.exception.InternalException;
import util.exception.SMTUnimplementedException;

import java.util.*;

public class AlkSMTContext
implements DataTypeProvider
{
    private static int fresh = 0;

    private final Map<BuiltInMethod, SMTMethodSolver> bMethods = new HashMap<>();
    private final Map<BuiltInFunction, SMTFunctionSolver> bFunctions = new HashMap<>();
    private final Map<Operator, SMTOperatorSolver> operators = new HashMap<>();
    private final Map<Sort, ArraySMTSupport> supportedArray = new HashMap<>();
    private final Map<Sort, SetSMTSupport> supportedSet = new HashMap<>();
    private AlkSMTSetSizeMethod setSizeSolver;

    private final List<SymbolicValue> delayValues = new ArrayList<>();

    public final Map<String, DataTypeAST> idsDataTypes = new HashMap<>();
    public final Map<String, Expr> ids = new HashMap<>();
    public final Context ctx;
    public final Solver s;

    public AlkSMTContext()
    {
        this(new Context());
    }
    public AlkSMTContext(Context ctx)
    {
        this(ctx, ctx.mkSolver());
    }

    public AlkSMTContext(Context ctx, Solver s)
    {
        this.ctx = ctx;
        this.s = s;
    }

    public void process(String name, DataTypeAST dataType)
    {
        Expr expr = dataType.makeExpr(ctx, name);
        ids.put(name, expr);
        idsDataTypes.put(name, dataType);
    }

    public void add(Expr expr)
    {
        s.add(expr);
    }

    public SMTMethodSolver getBuiltInMethodSolver(BuiltInMethod method)
    {
        if (!bMethods.containsKey(method))
        {
            SMTMethodSolver solver;
            switch (method)
            {
                case SIZE: solver = new AlkSMTArraySizeMethod(this); break;
                case INSERT: solver = new AlkSMTInsertMethod(this); break;
                case POPBACK: solver = new AlkSMTPopBackMethod(this); break;
                case POPFRONT: solver = new AlkSMTPopFrontMethod(this); break;
                case PUSHBACK: solver = new AlkSMTPushBackMethod(this); break;
                case PUSHFRONT: solver = new AlkSMTPushFrontMethod(this); break;
                case REMOVEAT: solver = new AlkSMTRemoveAtMethod(this); break;
                case TOPBACK: solver = new AlkSMTTopBackMethod(this); break;
                case TOPFRONT: solver = new AlkSMTTopFrontMethod(this); break;
                default: throw new SMTUnimplementedException(FactorPointMethodAST.class);
            }
            bMethods.put(method, solver);
        }
        return bMethods.get(method);
    }

    public AlkSMTSetSizeMethod getSetSizeSolver()
    {
        if (setSizeSolver == null)
        {
            setSizeSolver = new AlkSMTSetSizeMethod(this);
        }
        return setSizeSolver;
    }


    public SMTFunctionSolver getBuiltInFunctionSolver(BuiltInFunction fnc)
    {
        if (!bFunctions.containsKey(fnc))
        {
            SMTFunctionSolver solver;
            switch (fnc)
            {
                case SIN: solver = new AlkSMTSinFunction(this); break;
                case COS: solver = new AlkSMTCosFunction(this); break;
                case TAN: solver = new AlkSMTTanFunction(this); break;
                case ASIN: solver = new AlkSMTAsinFunction(this); break;
                case ACOS: solver = new AlkSMTAcosFunction(this); break;
                case ATAN: solver = new AlkSMTAtanFunction(this); break;
                case LOG: solver = new AlkSMTLogFunction(this); break;
                case POW: solver = new AlkSMTPowFunction(this); break;
                case SQRT: solver = new AlkSMTSqrtFunction(this); break;
                case ABS: solver = new AlkSMTAbsFunction(this); break;
                default: throw new SMTUnimplementedException(BuiltinFunctionAST.class);
            }
            bFunctions.put(fnc, solver);
        }
        return bFunctions.get(fnc);
    }

    public SMTOperatorSolver getOperatorSolver(Operator op)
    {
        if (!operators.containsKey(op))
        {
            SMTOperatorSolver solver;
            switch (op)
            {
                case EQUAL: solver = new EqualOperatorSolver(this); break;
                default: throw new SMTUnimplementedException(FactorPointMethodAST.class);
            }
            operators.put(op, solver);
        }
        return operators.get(op);
    }

    public ArrayExpr getEmptyArray(ArrayDataTypeAST dataType)
    {
        ArraySMTSupport support = getArraySupport((ArraySort) dataType.getSort(ctx));
        return support.getEmptyArray();
    }

    public ArrayExpr getEmptyList(ListDataTypeAST dataType)
    {
        ArraySMTSupport support = getArraySupport((ArraySort) dataType.getSort(ctx));
        return support.getEmptyArray();
    }

    public Expr getEmptySet(SetDataTypeAST dataType)
    {
        SetSMTSupport support = getSetSupport((ArraySort) dataType.getSort(ctx));
        return support.getEmptySet();
    }

    public boolean process(SymbolicValue symbolicValue)
    {
        try
        {
            LocationMapperIface lm = loc -> loc;
            AST root = symbolicValue.toAST().accept(new ASTSimplifier(lm, true));
            if (root instanceof BoolAST && root.getText().equals("true"))
            {
                return true;
            }
            SMTVisitor visitor = new SMTVisitor(this);
            Expr expr = root.accept(visitor);
            this.add(expr);
        }
        catch (IncompleteASTException e)
        {
            delayValues.add(symbolicValue);
            return false;
        }
        return true;
    }

    public boolean isSatisfiable()
    {
        flush();
        Status status = s.check();
        if (status == Status.SATISFIABLE)
        {
            return true;
        }
        else if (status == Status.UNSATISFIABLE)
        {
            return false;
        }
        else
        {
            throw new AlkException("Unknown Z3 check!");
        }
    }

    public boolean asserts(SymbolicValue symbolicValue)
    {
        flush();
        AST root = UnaryAST.createUnary(Operator.NOT, symbolicValue.toAST());
        try
        {
            LocationMapperIface lm = loc -> loc;
            ASTSimplifier simply = new ASTSimplifier(lm, true);
            root = root.accept(simply);
        }
        catch (IncompleteASTException ignore)
        {
        }
        SMTVisitor visitor = new SMTVisitor(this);
        Expr expr = root.accept(visitor);
        this.s.push();
        try
        {
            add(expr);
            Status sts = s.check();
            if (sts == Status.UNKNOWN)
            {
                throw new AlkException("Unknown check on Z3!");
            }
            return sts == Status.UNSATISFIABLE;
        }
        finally
        {
            this.s.pop();
        }
    }

    private void flush()
    {
        for (SymbolicValue delay : delayValues)
        {
            if (!process(delay))
            {
                throw new InternalException("Can't check if SMT context is satisfiable for: " + delay.toString());
            }
        }
        delayValues.clear();
    }

    @Override
    public DataTypeAST getDataType(String s)
    {
        if (!s.startsWith("$")) s = "$" + s;
        return idsDataTypes.get(s);
    }

    public String getFresh()
    {
        this.fresh++;
        return "#" + fresh;
    }

    public String getFresh(String name)
    {
        this.fresh++;
        return "$" + name + "_" + fresh;
    }

    public ArraySMTSupport getArraySupport(ArraySort arrayType)
    {
        if (!supportedArray.containsKey(arrayType))
            supportedArray.put(arrayType, new ArraySMTSupport(this, arrayType));
        return supportedArray.get(arrayType);
    }

    public SetSMTSupport getSetSupport(ArraySort setType)
    {
        if (!supportedSet.containsKey(setType))
            supportedSet.put(setType, new SetSMTSupport(this, setType));
        return supportedSet.get(setType);
    }

    public Expr getExprById(String id)
    {
        return ids.get(id);
    }
}
