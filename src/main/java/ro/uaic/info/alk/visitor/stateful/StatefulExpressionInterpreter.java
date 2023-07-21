package ro.uaic.info.alk.visitor.stateful;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.ContextVar;
import ro.uaic.info.alk.enums.FOL;
import ro.uaic.info.alk.state.Payload;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.enums.Primitive;

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
