package parser.visitors.expression;
import execution.ExecutionResult;
import execution.state.StateFactory;
import execution.state.expression.IntValueState;
import execution.state.ExecutionState;
import execution.state.expression.*;
import execution.state.statement.ChooseStmtState;
import parser.env.Environment;
import grammar.*;
import parser.visitors.ReferenceVisitor;
import parser.visitors.function.FunctionCallVisitor;
import parser.visitors.structure.ArrayVisitor;
import parser.visitors.structure.ListVisitor;
import parser.visitors.structure.SetVisitor;
import parser.visitors.structure.StructureVisitor;
import util.Payload;
import util.types.Value;

public class ExpressionVisitor extends alkBaseVisitor {

    private Environment env;

    private Payload payload;

    @Deprecated
    public ExpressionVisitor(Environment env) {
        this.env = env;
    }

    public ExpressionVisitor(Environment env, Payload payload) {
        this.env = env;
        this.payload = payload;
    }

    @Override
    public ExecutionState visitConditionalExpression(alkParser.ConditionalExpressionContext ctx)
    {
        return StateFactory.create(ConditionalExpressionState.class, ctx, payload, env);
    }

    @Override
    public ExecutionState visitLogicalOrExpression(alkParser.LogicalOrExpressionContext ctx)
    {
        return StateFactory.create(LogicalOrExpressionState.class, ctx, payload, env);
    }

    @Override
    public ExecutionState visitLogicalAndExpression(alkParser.LogicalAndExpressionContext ctx)
    {
        return StateFactory.create(LogicalAndExpressionState.class, ctx, payload, env);
    }

    @Override
    public ExecutionState visitInExpression(alkParser.InExpressionContext ctx)
    {
        return StateFactory.create(InExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitEqualityExpression(alkParser.EqualityExpressionContext ctx)
    {
        return StateFactory.create(EqualityExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitRelationalExpression(alkParser.RelationalExpressionContext ctx)
    {
        return StateFactory.create(RelationalExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitSetExpression(alkParser.SetExpressionContext ctx) {
        return StateFactory.create(SetExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitBitwiseOrExpression(alkParser.BitwiseOrExpressionContext ctx) {
        return StateFactory.create(BitwiseOrExpressionState.class, ctx, payload, env);
    }


    @Override public ExecutionState visitBitwiseAndExpression(alkParser.BitwiseAndExpressionContext ctx) {
        return StateFactory.create(BitwiseAndExpressionState.class, ctx, payload, env);
    }


    @Override public ExecutionState visitShiftExpression(alkParser.ShiftExpressionContext ctx) {
        return StateFactory.create(ShiftExpressionState.class, ctx, payload, env);
    }


    @Override public ExecutionState visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx) {
        return StateFactory.create(AdditiveExpressionState.class, ctx, payload, env);
    }


    @Override public ExecutionState visitMultiplicativeExpression(alkParser.MultiplicativeExpressionContext ctx) {
        return StateFactory.create(MultiplicativeExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitPrefixExpression(alkParser.PrefixExpressionContext ctx) {
        return StateFactory.create(PrefixExpressionState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitUnaryExpression(alkParser.UnaryExpressionContext ctx) {
        return StateFactory.create(UnaryExpressionState.class, ctx, payload, env);
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
        return new ExecutionState(ctx, payload) {
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
        return StateFactory.create(IntValueState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitDoubleValue(alkParser.DoubleValueContext ctx) {
        return StateFactory.create(FloatValueState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitBoolValue(alkParser.BoolValueContext ctx) {
        return StateFactory.create(BoolValueState.class, ctx, payload, env);
    }

    @Override public ExecutionState visitStringValue(alkParser.StringValueContext ctx) {
        return StateFactory.create(StringValueState.class, ctx, payload, env);
    }


    //Data Structures

    @Override public ExecutionState visitArrayValue(alkParser.ArrayValueContext ctx)
    {
        return (ExecutionState) new ArrayVisitor(env, payload).visit(ctx.array());
    }


    @Override public ExecutionState visitListValue(alkParser.ListValueContext ctx) {
        return (ExecutionState) new ListVisitor(env, payload).visit(ctx.list());
    }


    @Override public ExecutionState visitSetValue(alkParser.SetValueContext ctx) {
        return (ExecutionState) new SetVisitor(env, payload).visit(ctx.set());
    }


    @Override
    public ExecutionState visitStructureValue(alkParser.StructureValueContext ctx)
    {
        return (ExecutionState) new StructureVisitor(env, payload).visit(ctx.structure());
    }

}
