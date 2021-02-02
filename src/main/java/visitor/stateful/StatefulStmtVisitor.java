package visitor.stateful;

import state.Payload;
import state.State;
import ast.stmt.*;
import visitor.ifaces.StmtVisitorIface;

public class StatefulStmtVisitor<T extends Payload, S extends State<?, ?>>
implements StmtVisitorIface<S>
{
    private T payload;
    private StatefulStmtInterpreter<T, S> stmtInterpreter;

    public void setInterpreter(StatefulStmtInterpreter<T, S> stmtInterpreter)
    {
        this.stmtInterpreter = stmtInterpreter;
    }

    public void setPayload(T payload)
    {
        this.payload = payload;
    }

    @Override
    public S visit(BlockAST tree)
    {
        return stmtInterpreter.interpretBlock(tree, payload);
    }

    @Override
    public S visit(BreakAST tree)
    {
        return stmtInterpreter.interpretBreak(tree, payload);
    }

    @Override
    public S visit(ChooseAST tree)
    {
        return stmtInterpreter.interpretChoose(tree, payload);
    }

    @Override
    public S visit(ContinueAST tree)
    {
        return stmtInterpreter.interpretContinue(tree, payload);
    }

    @Override
    public S visit(DoWhileAST tree)
    {
        return stmtInterpreter.interpretDoWhile(tree, payload);
    }

    @Override
    public S visit(ExprStmtAST tree)
    {
        return stmtInterpreter.interpretExprStmt(tree, payload);
    }

    @Override
    public S visit(FailureAST tree)
    {
        return stmtInterpreter.interpretFailure(tree, payload);
    }

    @Override
    public S visit(ForAST tree)
    {
        return stmtInterpreter.interpretFor(tree, payload);
    }

    @Override
    public S visit(ForEachAST tree)
    {
        return stmtInterpreter.interpretForEach(tree, payload);
    }

    @Override
    public S visit(FunctionDeclAST tree)
    {
        return stmtInterpreter.interpretFunctionDecl(tree, payload);
    }

    @Override
    public S visit(IfThenAST tree)
    {
        return stmtInterpreter.interpretIfThen(tree, payload);
    }

    @Override
    public S visit(RepeatUntilAST tree)
    {
        return stmtInterpreter.interpretRepeatUntil(tree, payload);
    }

    @Override
    public S visit(StmtSeqAST tree)
    {
        return stmtInterpreter.interpretStmtSeq(tree, payload);
    }

    @Override
    public S visit(SuccessAST tree)
    {
        return stmtInterpreter.interpretSuccess(tree, payload);
    }

    @Override
    public S visit(UniformAST tree)
    {
        return stmtInterpreter.interpretUniform(tree, payload);
    }

    @Override
    public S visit(WhileAST tree)
    {
        return stmtInterpreter.interpretWhile(tree, payload);
    }

    @Override
    public S visit(ReturnAST tree)
    {
        return stmtInterpreter.interpretReturn(tree, payload);
    }
}
