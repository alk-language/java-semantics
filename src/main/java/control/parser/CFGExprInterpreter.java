package control.parser;

import ast.AST;
import ast.enums.Primitive;
import visitor.stateful.StatefulExpressionInterpreter;

public class CFGExprInterpreter
implements StatefulExpressionInterpreter<CFGPayload, CFGState>
{

    @Override
    public CFGState evaluateUnary(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState evaluateBinary(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState evaluateTernary(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState evaluateMethod(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState evaluateFunction(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretAssignment(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretRefId(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretPrimitive(Primitive primitive, AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretComposite(Primitive primitive, AST ast, CFGPayload payload)
    {
        return null;
    }
}
