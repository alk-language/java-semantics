package ro.uaic.info.alk.util.functions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInFunctionASTAttr;
import ro.uaic.info.alk.enums.AlkBuiltInFunction;
import ro.uaic.info.alk.ast.expr.BuiltinFunctionAST;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.types.AlkNotAValue;
import ro.uaic.info.alk.types.AlkSet;
import ro.uaic.info.alk.io.IOManager;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class SymbolicFunctions
implements FunctionsIface
{
    private static Storable apply(List<Storable> params, AlkBuiltInFunction fnc)
    {
        AST tree = new BuiltinFunctionAST(null);
        BuiltInFunctionASTAttr attr = new BuiltInFunctionASTAttr(fnc);
        tree.addAttribute(BuiltInFunctionASTAttr.class, attr);
        for (Storable param : params)
        {
            SymbolicValue ans = SymbolicValue.toSymbolic(param);
            tree.addChild(ans.toAST());
        }
        return new SymbolicValue(tree);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable sin(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.SIN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable cos(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.COS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable tan(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.TAN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable asin(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.ASIN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable acos(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.ACOS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable atan(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.ATAN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable log(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.LOG);
    }

    @BuiltInFunctionImpl(paramNumber = 2)
    public static Storable pow(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.POW);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable sqrt(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.SQRT);
    }

    @BuiltInFunctionImpl(paramNumber = 0)
    public static Storable pi(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.PI);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable abs(List<Storable> params)
    {
        return apply(params, AlkBuiltInFunction.ABS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue singletonset(List<Storable> params)
    {
        return new AlkSet().insert((AlkValue) params.get(0).clone(generator));
    }

    AlkConfiguration config;
    LocationGenerator generator;

    public SymbolicFunctions(AlkConfiguration config, LocationGenerator generator)
    {
        this.config = config;
        this.generator = generator;
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public Storable print(List<Storable> params)
    {
        IOManager io = config.getIOManager();
        io.write(params.get(0).toString());
        return AlkNotAValue.INSTANCE;
    }
}
