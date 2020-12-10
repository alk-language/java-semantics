package control.parser.visitors;

import ast.StateFactory;
import ast.state.IndependentSingleState;
import control.parser.CFGPayload;
import control.parser.CFGProxyState;
import control.parser.CFGState;
import control.parser.states.*;
import grammar.alkBaseVisitor;
import grammar.alkParser;

public class StmtVisitor extends alkBaseVisitor<CFGState>
{
    CFGPayload payload;

    public StmtVisitor(CFGPayload payload)
    {
        this.payload = payload;
    }

    @Override
    public CFGState visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        return new StatementSeqState(ctx, StmtVisitor.class, ctx.statement(), payload);
    }

    @Override
    public CFGState visitToAssignmentStmt(alkParser.ToAssignmentStmtContext ctx)
    {
        return new CFGProxyState(new IndependentSingleState<>(ctx, StmtVisitor.class, ctx.assignment(), payload));
    }

    @Override
    public CFGState visitAssignmentStmt(alkParser.AssignmentStmtContext ctx)
    {
        return StateFactory.create(TerminalState.class, ctx, payload);
    }

    @Override
    public CFGState visitIfStructure(alkParser.IfStructureContext ctx)
    {
        return StateFactory.create(IfStmtState.class, ctx, payload);
    }

    @Override
    public CFGState visitWhileStructure(alkParser.WhileStructureContext ctx)
    {
        return StateFactory.create(WhileState.class, ctx, payload);
    }

    @Override
    public CFGState visitBlock(alkParser.BlockContext ctx)
    {
        return new CFGProxyState(new IndependentSingleState<>(ctx, StmtVisitor.class, ctx.statement_sequence(), payload));
    }

    @Override
    public CFGState visitMethodCall(alkParser.MethodCallContext ctx)
    {
        return StateFactory.create(TerminalState.class, ctx, payload);
    }

    @Override
    public CFGState visitFunctionCall(alkParser.FunctionCallContext ctx)
    {
        return StateFactory.create(TerminalState.class, ctx, payload);
    }

    @Override
    public CFGState visitToChooseStmt(alkParser.ToChooseStmtContext ctx)
    {
        return StateFactory.create(TerminalState.class, ctx, payload);
    }

    @Override
    public CFGState visitForStructure(alkParser.ForStructureContext ctx)
    {
        return StateFactory.create(ForState.class, ctx, payload);
    }

    @Override
    public CFGState visitDoWhileStructure(alkParser.DoWhileStructureContext ctx)
    {
        return StateFactory.create(DoWhileState.class, ctx, payload);
    }

    @Override
    public CFGState visitToDoWhile(alkParser.ToDoWhileContext ctx)
    {
        return new CFGProxyState(new IndependentSingleState<>(ctx, StmtVisitor.class, ctx.do_while_struct(), payload));
    }
}
