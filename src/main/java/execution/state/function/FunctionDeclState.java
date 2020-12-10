package execution.state.function;

import execution.ExecutionResult;
import execution.state.ExecutionState;
import grammar.alkParser;
import execution.parser.env.AlkFunction;
import execution.parser.visitors.StmtVisitor;
import ast.CtxState;
import execution.ExecutionPayload;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.functions.Parameter;
import util.types.Value;

import java.util.ArrayList;
import java.util.List;

@CtxState(ctxClass = alkParser.FunctionDeclContext.class)
public class FunctionDeclState extends ExecutionState<Value, Value> {

    alkParser.FunctionDeclContext ctx;
    int step = 0;
    List<Parameter> params = new ArrayList<>();
    List<String> modifies = new ArrayList<>();

    public FunctionDeclState(alkParser.FunctionDeclContext ctx, ExecutionPayload executionPayload) {
        super(ctx, executionPayload);
        this.ctx = ctx;
    }

    @Override
    public ExecutionState makeStep() {
        if (step < ctx.param().size())
        {
            return request(StmtVisitor.class, ctx.param(step++));
        }
        for (int i=1; i<ctx.ID().size(); i++)
        {
            modifies.add(ctx.ID().get(i).getText());
        }

        getFuncManager().define(new AlkFunction(ctx.ID().get(0).getText(), params, modifies, ctx.statement_block()));
        return null;
    }

    @Override
    public void assign(ExecutionResult executionResult) {
        Value value = executionResult.getValue().toRValue();
        if (!(value instanceof Parameter))
            throw new InternalException("While evaluating parameters, a non-parameter type was returned");

        Parameter param = (Parameter) value;
        params.add(param);
    }

    @Override
    public ExecutionState clone(SplitMapper sm)
    {
        FunctionDeclState copy = new FunctionDeclState(ctx, sm.getExecutionPayload());
        copy.step = step;
        for (Parameter param : params)
            copy.params.add((Parameter) param.weakClone(sm.getLocationMapper()));
        copy.modifies.addAll(modifies);
        return super.decorate(copy, sm);
    }
}