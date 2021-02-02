package visitor.stateful;

import state.Payload;
import state.State;
import ast.enums.Primitive;
import ast.expr.*;
import ast.expr.AssignmentAST;
import visitor.ifaces.ExpressionVisitorIface;

public class StatefulExpressionVisitor<T extends Payload, S extends State<?, ?>>
implements ExpressionVisitorIface<S>
{
    private T payload;
    private StatefulExpressionInterpreter<T, S> expressionInterpreter;

    public void setInterpreter(StatefulExpressionInterpreter<T, S> expressionInterpreter)
    {
        this.expressionInterpreter = expressionInterpreter;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }

    @Override
    public S visit(AdditiveAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(ArrayAST tree)
    {
        return expressionInterpreter.interpretComposite(Primitive.ARRAY, tree, payload);
    }

    @Override
    public S visit(AssignmentAST tree)
    {
        return expressionInterpreter.interpretAssignment(tree, payload);
    }

    @Override
    public S visit(BitwiseAndAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(BitwiseOrAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(BoolAST tree)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.BOOL, tree, payload);
    }

    @Override
    public S visit(BracketAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(BuiltinFunctionAST tree)
    {
        return expressionInterpreter.evaluateFunction(tree, payload);
    }

    @Override
    public S visit(ConditionalExprAST tree)
    {
        return expressionInterpreter.evaluateTernary(tree, payload);
    }

    @Override
    public S visit(EqualityAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(FactorPointIdAST tree)
    {
        return expressionInterpreter.evaluateUnary(tree, payload);
    }

    @Override
    public S visit(FactorPointMethodAST tree)
    {
        return expressionInterpreter.evaluateMethod(tree, payload);
    }

    @Override
    public S visit(FloatAST tree)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.FLOAT, tree, payload);
    }

    @Override
    public S visit(FunctionCallAST tree)
    {
        return expressionInterpreter.evaluateFunction(tree, payload);
    }

    @Override
    public S visit(InExprAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(IntAST tree)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.INT, tree, payload);
    }

    @Override
    public S visit(ListAST tree)
    {
        return expressionInterpreter.interpretComposite(Primitive.LIST, tree, payload);
    }

    @Override
    public S visit(LogicalAndAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(LogicalOrAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(MultiplicativeAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(PostfixAST tree)
    {
        return expressionInterpreter.evaluateUnary(tree, payload);
    }

    @Override
    public S visit(PrefixAST tree)
    {
        return expressionInterpreter.evaluateUnary(tree, payload);
    }

    @Override
    public S visit(RefIDAST tree)
    {
        return expressionInterpreter.interpretRefId(tree, payload);
    }

    @Override
    public S visit(RelationalAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(SetExprAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(SetAST tree)
    {
        return expressionInterpreter.interpretComposite(Primitive.SET, tree, payload);
    }

    @Override
    public S visit(ShiftAST tree)
    {
        return expressionInterpreter.evaluateBinary(tree, payload);
    }

    @Override
    public S visit(StringAST tree)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.STRING, tree, payload);
    }

    @Override
    public S visit(StructAST tree)
    {
        return expressionInterpreter.interpretComposite(Primitive.STRUCTURE, tree, payload);
    }

    @Override
    public S visit(UnaryAST tree)
    {
        return expressionInterpreter.evaluateUnary(tree, payload);
    }
}
