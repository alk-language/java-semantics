package visitor.stateful;

import ast.AST;
import ast.Payload;
import ast.State;
import ast.enums.Primitive;

public interface StatefulExpressionInterpreter<T extends Payload, S extends State<?, ?>>
{
    S evaluateUnary(AST ast, T payload);
    S evaluateBinary(AST ast, T payload);
    S evaluateTernary(AST ast, T payload);
    S evaluateMethod(AST ast, T payload);
    S evaluateFunction(AST ast, T payload);
    S interpretRefId(AST ast, T payload);
    S interpretFunctionCall(AST ast, T payload);
    S interpretPrimitive(Primitive primitive, AST ast, T payload);
    S interpretComposite(Primitive primitive, AST ast, T payload);
}
