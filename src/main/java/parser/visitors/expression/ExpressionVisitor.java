package parser.visitors.expression;
import execution.ExecutionResult;
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
import util.types.Value;

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

    // TODO: not compatible with the latest stack fashion execution
    @Override
    public ExecutionState visitFunctionCallFactor(alkParser.FunctionCallFactorContext ctx)
    {
        return (ExecutionState) new FunctionCallVisitor(env).visit(ctx.function_call());
    }

    @Override public ExecutionState visitParanthesesFactor(alkParser.ParanthesesFactorContext ctx) {
        return (ExecutionState) visit(ctx.expression());
    }

    @Override public ExecutionState visitRefNameFactor(alkParser.RefNameFactorContext ctx) {
        // TODO: port the reference visitor to the state stack
        return new ExecutionState(ctx, this) {
            @Override
            public ExecutionState makeStep() {
                result = new ExecutionResult<>((Value) new ReferenceVisitor(env).visit(ctx.ref_name()));
                return null;
            }

            @Override
            public void assign(ExecutionResult result) {
                // no-op
            }
        };
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


    @Override public ExecutionState visitListValue(alkParser.ListValueContext ctx) {
        return (ExecutionState) new ListVisitor(env).visit(ctx.list());
    }


    @Override public ExecutionState visitSetValue(alkParser.SetValueContext ctx) {
        return (ExecutionState) new SetVisitor(env).visit(ctx.set());
    }


    @Override
    public AlkValue visitStructureValue(alkParser.StructureValueContext ctx)
    {
        StructureVisitor structVisitator = new StructureVisitor(env);
        return (AlkValue) structVisitator.visit(ctx.structure());
    }

}
