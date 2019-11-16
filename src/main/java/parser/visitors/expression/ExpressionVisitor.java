package parser.visitors.expression;
import execution.state.expression.IntValueState;
import execution.state.ExecutionState;
import execution.state.expression.*;
import parser.env.Environment;
import grammar.*;
import parser.types.AlkValue;
import parser.visitors.ReferenceVisitor;
import parser.visitors.function.FunctionCallVisitor;
import parser.visitors.structure.ArrayVisitor;
import parser.visitors.structure.ListVisitor;
import parser.visitors.structure.SetVisitor;
import parser.visitors.structure.StructureVisitor;

public class ExpressionVisitor extends alkBaseVisitor {

    private Environment env;

    public ExpressionVisitor(Environment env) {
        this.env = env;
    }

    @Override
    public ExecutionState visitConditionalExpression(alkParser.ConditionalExpressionContext ctx)
    {
        return new ConditionalExpressionState(ctx,this);
    }

    @Override
    public ExecutionState visitLogicalOrExpression(alkParser.LogicalOrExpressionContext ctx)
    {
        return new LogicalOrExpressionState(ctx,this);
    }

    @Override
    public ExecutionState visitLogicalAndExpression(alkParser.LogicalAndExpressionContext ctx)
    {
        return new LogicalAndExpressionState(ctx, this);
    }

    @Override
    public ExecutionState visitInExpression(alkParser.InExpressionContext ctx)
    {
        return new InExpressionState(ctx, this);
    }

    @Override public ExecutionState visitEqualityExpression(alkParser.EqualityExpressionContext ctx)
    {
        return new EqualityExpressionState(ctx, this);
    }

    @Override public ExecutionState visitRelationalExpression(alkParser.RelationalExpressionContext ctx) {
        return new RelationalExpressionState(ctx, this);
    }

    @Override public ExecutionState visitSetExpression(alkParser.SetExpressionContext ctx) {
        return new SetExpressionState(ctx, this);
    }

    @Override public ExecutionState visitBitwiseOrExpression(alkParser.BitwiseOrExpressionContext ctx) {
        return new BitwiseOrExpressionState(ctx, this);
    }


    @Override public ExecutionState visitBitwiseAndExpression(alkParser.BitwiseAndExpressionContext ctx) {
        return new BitwiseAndExpressionState(ctx, this);
    }


    @Override public ExecutionState visitShiftExpression(alkParser.ShiftExpressionContext ctx) {
        return new ShiftExpressionState(ctx, this);
    }


    @Override public ExecutionState visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx) {
        return new AdditiveExpressionState(ctx, this);
    }


    @Override public ExecutionState visitMultiplicativeExpression(alkParser.MultiplicativeExpressionContext ctx) {
        return new MultiplicativeExpressionState(ctx, this);
    }

    @Override public ExecutionState visitPrefixExpression(alkParser.PrefixExpressionContext ctx) {
        return new PrefixExpressionState(ctx, this);
    }

    @Override public ExecutionState visitUnaryExpression(alkParser.UnaryExpressionContext ctx) {
        return new UnaryExpressionState(ctx, this);
    }


    //Factor

    @Override
    public ExecutionState visitFunctionCallFactor(alkParser.FunctionCallFactorContext ctx)
    {
        return (ExecutionState) new FunctionCallVisitor(env).visit(ctx.function_call());
    }

    @Override public Object visitParanthesesFactor(alkParser.ParanthesesFactorContext ctx) {
        return visit(ctx.expression());
    }

    @Override public Object visitRefNameFactor(alkParser.RefNameFactorContext ctx) {
        ReferenceVisitor refVisitor = new ReferenceVisitor(env);
        return refVisitor.visit(ctx.ref_name());
    }


    /// Scalar values

    @Override public ExecutionState visitIntValue(alkParser.IntValueContext ctx)
    {
        return new IntValueState(ctx, this);
    }

    @Override public ExecutionState visitDoubleValue(alkParser.DoubleValueContext ctx) {
        return new FloatValueState(ctx, this);
    }

    @Override public ExecutionState visitBoolValue(alkParser.BoolValueContext ctx) {
        return new BoolValueState(ctx, this);
    }

    @Override public ExecutionState visitStringValue(alkParser.StringValueContext ctx) {
        return new StringValueState(ctx, this);
    }


    //Data Structures

    @Override public ExecutionState visitArrayValue(alkParser.ArrayValueContext ctx)
    {
        return (ExecutionState) new ArrayVisitor(env).visit(ctx.array());
    }


    @Override public AlkValue visitListValue(alkParser.ListValueContext ctx) {
        ListVisitor structVisitator = new ListVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.list());
    }


    @Override public AlkValue visitSetValue(alkParser.SetValueContext ctx) {
        SetVisitor structVisitator = new SetVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.set());
    }


    @Override
    public AlkValue visitStructureValue(alkParser.StructureValueContext ctx)
    {
        StructureVisitor structVisitator = new StructureVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.structure());
    }

}
