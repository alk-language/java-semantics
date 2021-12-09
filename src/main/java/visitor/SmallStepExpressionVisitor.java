package visitor;

import ast.*;
import ast.attr.BuiltInMethodASTAttr;
import ast.attr.IdASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.RepresentationASTAttr;
import ast.expr.*;
import ast.expr.AssignmentAST;
import ast.expr.fol.EquivAST;
import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import ast.expr.fol.ImpliesAST;
import util.Pair;
import util.exception.InternalException;
import ast.enums.CompoundValueRepresentation;
import ast.enums.Operator;
import ast.enums.Primitive;
import visitor.ifaces.ExpressionVisitorIface;
import visitor.interpreter.SmallStepExpressionInterpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallStepExpressionVisitor<T>
implements ExpressionVisitorIface<T>
{
    private final SmallStepExpressionInterpreter<T> expressionInterpreter;

    public SmallStepExpressionVisitor(SmallStepExpressionInterpreter<T> expressionInterpreter)
    {
        this.expressionInterpreter = expressionInterpreter;
    }

    public T visit(ConditionalExprAST ctx)
    {
        List<T> list = new ArrayList<>();
        T condition = ctx.getCondition().accept(this);
        list.add(condition);
        T thenExpr = ctx.getThenExpression().accept(this);
        list.add(thenExpr);
        T elseExpr = ctx.getElseExpression().accept(this);
        list.add(elseExpr);
        return expressionInterpreter.evaluate(Operator.IFELSE, list);
    }

    public T visit(LogicalOrAST ctx)
    {
        return process(Operator.LOGICALOR, ctx);
    }

    public T visit(LogicalAndAST ctx)
    {
        return process(Operator.LOGICALAND, ctx);
    }

    public T visit(InExprAST ctx)
    {
        return process(Operator.IN, ctx);
    }

    public T visit(EqualityAST ctx)
    {
        return process(ctx);
    }

    public T visit(RelationalAST ctx)
    {
        return process(ctx);
    }

    public T visit(SetExprAST ctx)
    {
        return process(ctx);
    }

    public T visit(BitwiseOrAST ctx)
    {
        return process(ctx);
    }

    public T visit(BitwiseAndAST ctx)
    {
        return process(ctx);
    }

    public T visit(ShiftAST ctx)
    {
        return process(ctx);
    }

    public T visit(AdditiveAST ctx)
    {
        return process(ctx);
    }

    public T visit(MultiplicativeAST ctx)
    {
        return process(ctx);
    }

    public T visit(PrefixAST ctx)
    {
        OpsASTAttr attr = ctx.getAttribute(OpsASTAttr.class);
        return expressionInterpreter.evaluate(attr.getOp(0),
                                              Collections.singletonList(ctx.getChild(0).accept(this)));
    }

    public T visit(PostfixAST ctx)
    {
        T result = ctx.getChild(0).accept(this);
        OpsASTAttr attr = ctx.getAttribute(OpsASTAttr.class);
        for (int i = 1; i < ctx.getChildCount(); i++)
        {
            result = expressionInterpreter.evaluate(attr.getOp(i - 1), Collections.singletonList(result));
        }
        return result;
    }

    public T visit(UnaryAST ctx)
    {
        OpsASTAttr attr = ctx.getAttribute(OpsASTAttr.class);
        return expressionInterpreter.evaluate(attr.getOp(0),
                                              Collections.singletonList(ctx.getChild(0).accept(this)));
    }

    public T visit(RefIDAST ctx)
    {
        return expressionInterpreter.interpretVariable(ctx.getId());
    }

    @Override
    public T visit(SymIDAST ctx)
    {
        return expressionInterpreter.interpretSymId(ctx.getId());
    }

    public T visit(BracketAST ctx)
    {
        List<T> list = new ArrayList<>();
        list.add(ctx.getChild(0).accept(this));
        list.add(ctx.getChild(1).accept(this));
        return expressionInterpreter.evaluate(Operator.BRACKET, list);
    }

    @Override
    public T visit(FactorPointIdAST ctx)
    {
        List<T> list = new ArrayList<>();
        list.add(ctx.getChild(0).accept(this));
        return expressionInterpreter.evaluate(Operator.DOT, list);
    }

    public T visit(IntAST ctx)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.INT, ctx.getText());
    }

    public T visit(BoolAST ctx)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.BOOL, ctx.getText());
    }

    @Override
    public T visit(UnknownAST ctx)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.UNKNOWN, ctx.getText());
    }

    public T visit(StringAST ctx)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.STRING, ctx.getText());
    }

    public T visit(FloatAST ctx)
    {
        return expressionInterpreter.interpretPrimitive(Primitive.FLOAT, ctx.getText());
    }

    public T visit(ArrayAST ctx)
    {
        return visitCompoundData(Primitive.ARRAY, ctx);
    }

    public T visit(ListAST ctx)
    {
        return visitCompoundData(Primitive.LIST, ctx);
    }

    public T visit(SetAST ctx)
    {
        return visitCompoundData(Primitive.SET, ctx);
    }

    public T visit(StructAST ctx)
    {
        List<Pair<String, T>> comps = new ArrayList<>();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            ComponentAST comp = (ComponentAST) ctx.getChild(i);
            IdASTAttr attr = comp.getAttribute(IdASTAttr.class);
            comps.add(new Pair<>(attr.getId(), comp.getChild(0).accept(this)));
        }
        return expressionInterpreter.interpretCompositeComponents(Primitive.STRUCTURE, comps);
    }

    private T visitCompoundData(Primitive primitive, AST ctx)
    {
        DataStructureVisitor<T> dataStructureVisitor = new DataStructureVisitor<>(primitive, this, expressionInterpreter);
        RepresentationASTAttr attr = ctx.getAttribute(RepresentationASTAttr.class);
        CompoundValueRepresentation repr = attr.getRepresentation();
        switch (repr)
        {
            case EMPTY:
                return dataStructureVisitor.visitEmptyDefinition();
            case EXPRESSIONS:
                return dataStructureVisitor.visitExpressionDefinition(ctx);
            case INTERVAL:
                return dataStructureVisitor.visitIntervalDefinition(ctx);
            case FILTER_SPEC:
                return dataStructureVisitor.visitFilterSpecDefinition(ctx);
            case MAP_SPEC:
                return dataStructureVisitor.visitSelectSpecDefinition(ctx);
            default:
                throw new InternalException("Unindentified compound value representation.");
        }
    }

    private T process(Operator op, AST ctx)
    {
        List<T> list = new ArrayList<>();
        T result = ctx.getChild(0).accept(this);
        for (int i = 1; i < ctx.getChildCount(); i++)
        {
            list.clear();
            list.add(result);
            list.add(ctx.getChild(i).accept(this));
            result = expressionInterpreter.evaluate(op, list);
        }
        return result;
    }

    private T process(AST ctx)
    {
        List<T> list = new ArrayList<>();
        T result = ctx.getChild(0).accept(this);
        OpsASTAttr attr = ctx.getAttribute(OpsASTAttr.class);
        for (int i = 1; i < ctx.getChildCount(); i++)
        {
            list.clear();
            list.add(result);
            list.add(ctx.getChild(i).accept(this));
            result = expressionInterpreter.evaluate(attr.getOp(i - 1), list);
        }
        return result;
    }

    @Override
    public T visit(FactorPointMethodAST ctx)
    {
        List<T> params = new ArrayList<>();
        T factor = ctx.getChild(0).accept(this);
        for (int i = 1; i < ctx.getChildCount(); i++)
        {
            params.add(ctx.getChild(i).accept(this));
        }

        return expressionInterpreter.evaluateBuiltIn(ctx.getAttribute(BuiltInMethodASTAttr.class).getMethod(), factor, params);
    }

    @Override
    public T visit(BuiltinFunctionAST ctx)
    {
        return null;
    }

    @Override
    public T visit(FunctionCallAST tree)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public T visit(AssignmentAST ctx)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public T visit(EquivAST ctx)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public T visit(ExistsExprAST ctx)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public T visit(ForAllExprAST ctx)
    {
        throw new InternalException("To be implemented!");
    }

    @Override
    public T visit(ImpliesAST ctx)
    {
        throw new InternalException("To be implemented!");
    }

    static class DataStructureVisitor<T>
    {
        SmallStepExpressionVisitor<T> exprVisitor;
        SmallStepExpressionInterpreter<T> expressionInterpreter;
        Primitive primitive;

        DataStructureVisitor (Primitive primitive,
                              SmallStepExpressionVisitor<T> exprVisitor,
                              SmallStepExpressionInterpreter<T> expressionInterpreter)
        {
            this.primitive = primitive;
            this.exprVisitor = exprVisitor;
            this.expressionInterpreter = expressionInterpreter;
        }

        public T visitEmptyDefinition()
        {
            return expressionInterpreter.interpretPrimitive(primitive, null);
        }

        public T visitExpressionDefinition(AST ctx)
        {
            List<T> values = new ArrayList<>();
            for (int i=0; i<ctx.getChildCount(); i++)
            {
                values.add(ctx.getChild(i).accept(exprVisitor));
            }

            return expressionInterpreter.interpretComposite(primitive, values);
        }

        public T visitIntervalDefinition(AST ctx)
        {
            T left = ctx.getChild(0).accept(exprVisitor);
            T right = ctx.getChild(1).accept(exprVisitor);
            return expressionInterpreter.interpretCompositeInterval(primitive, left, right);
        }

        public T visitFilterSpecDefinition(AST ctx)
        {
            T fromExpr = ctx.getChild(0).accept(exprVisitor);
            IdASTAttr attr = ctx.getAttribute(IdASTAttr.class);
            return expressionInterpreter.interpretCompositeFilterSpec(primitive, attr.getId(), fromExpr, (msg) ->
                ctx.getChild(1).accept(exprVisitor)
            );
        }

        public T visitSelectSpecDefinition(AST ctx)
        {
            T fromExpr = ctx.getChild(1).accept(exprVisitor);
            IdASTAttr attr = ctx.getAttribute(IdASTAttr.class);
            return expressionInterpreter.interpretCompositeSelectSpec(primitive, attr.getId(), fromExpr, (msg) ->
                ctx.getChild(0).accept(exprVisitor)
            );
        }
    }
}
