package smt;

import ast.type.DataTypeAST;
import com.microsoft.z3.Expr;

public interface SMTMethodSolver
{
    boolean USE_GLOBAL_DEF = true;
    Expr apply(Expr<?> target, Expr<?>[] params);
    default Expr apply(Expr<?> target, Expr<?>[] params, DataTypeAST datatype) { return apply(target, params); }
}
