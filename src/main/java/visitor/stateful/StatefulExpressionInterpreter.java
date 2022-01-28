package visitor.stateful;

import ast.AST;
import ast.enums.ContextVar;
import ast.enums.FOL;
import ast.expr.fol.EquivAST;
import state.Payload;
import state.State;
import ast.enums.Primitive;

public interface StatefulExpressionInterpreter<T extends Payload, S extends State<?, ?>>
{
    S evaluateUnary(AST ast, T payload);
    S evaluateBinary(AST ast, T payload);
    S evaluateTernary(AST ast, T payload);
    S evaluateMethod(AST ast, T payload);
    S evaluateFunction(AST ast, T payload);
    S interpretAssignment(AST ast, T payload);
    S interpretRefId(AST ast, T payload);
    S interpretSymId(AST ast, T payload);
    S interpretPrimitive(Primitive primitive, AST ast, T payload);
    S interpretComposite(Primitive primitive, AST ast, T payload);
    S interpretFol(FOL equiv, AST ast, T payload);
    S interpretContextVar(ContextVar var, AST ast, T payload);
    void interpretAnno(AST ast, T payload);
}
