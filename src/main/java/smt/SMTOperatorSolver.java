package smt;

import ast.AST;
import com.microsoft.z3.Expr;

public interface SMTOperatorSolver
{
    Expr<?> apply(boolean forArray, Expr<?> leftOp, Expr<?> rightOp);
}
