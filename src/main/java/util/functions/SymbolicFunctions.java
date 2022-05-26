package util.functions;

import ast.AST;
import ast.attr.BuiltInFunctionASTAttr;
import ast.enums.BuiltInFunction;
import ast.expr.BuiltinFunctionAST;
import execution.parser.env.Location;
import execution.types.AlkValue;
import execution.types.alkNotAValue.AlkNotAValue;
import execution.types.alkSet.AlkSet;
import io.IOManager;
import symbolic.SymbolicValue;
import util.Configuration;
import util.lambda.LocationGenerator;
import util.types.Storable;

import java.util.List;

public class SymbolicFunctions
implements Funcs
{
    private static Storable apply(List<Storable> params, BuiltInFunction fnc)
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
        return apply(params, BuiltInFunction.SIN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable cos(List<Storable> params)
    {
        return apply(params, BuiltInFunction.COS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable tan(List<Storable> params)
    {
        return apply(params, BuiltInFunction.TAN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable asin(List<Storable> params)
    {
        return apply(params, BuiltInFunction.ASIN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable acos(List<Storable> params)
    {
        return apply(params, BuiltInFunction.ACOS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable atan(List<Storable> params)
    {
        return apply(params, BuiltInFunction.ATAN);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable log(List<Storable> params)
    {
        return apply(params, BuiltInFunction.LOG);
    }

    @BuiltInFunctionImpl(paramNumber = 2)
    public static Storable pow(List<Storable> params)
    {
        return apply(params, BuiltInFunction.POW);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable sqrt(List<Storable> params)
    {
        return apply(params, BuiltInFunction.SQRT);
    }

    @BuiltInFunctionImpl(paramNumber = 0)
    public static Storable pi(List<Storable> params)
    {
        return apply(params, BuiltInFunction.PI);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public static Storable abs(List<Storable> params)
    {
        return apply(params, BuiltInFunction.ABS);
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public AlkValue singletonset(List<Storable> params)
    {
        Location loc = generator.generate(params.get(0));
        return new AlkSet().insert(loc);
    }

    Configuration config;
    LocationGenerator generator;

    public SymbolicFunctions(Configuration config, LocationGenerator generator)
    {
        this.config = config;
        this.generator = generator;
    }

    @BuiltInFunctionImpl(paramNumber = 1)
    public Storable print(List<Storable> params)
    {
        IOManager io = config.getIOManager();
        io.write(params.get(0).toString());
        return new AlkNotAValue();
    }
}
