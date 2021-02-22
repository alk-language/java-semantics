package control.parser;

import ast.AST;
import control.parser.states.*;
import execution.parser.exceptions.AlkException;
import visitor.stateful.StatefulStmtInterpreter;

public class CFGStmtInterpreter
implements StatefulStmtInterpreter<CFGPayload, CFGState>
{
    @Override
    public CFGState interpretBlock(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretBreak(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't generate CFG for algorithms containing break statement.");
    }

    @Override
    public CFGState interpretChoose(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretContinue(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't generate CFG for algorithms containing continue statement.");
    }

    @Override
    public CFGState interpretDoWhile(AST ast, CFGPayload payload)
    {
        return new DoWhileState(ast, payload);
    }

    @Override
    public CFGState interpretExprStmt(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretFailure(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretFor(AST ast, CFGPayload payload)
    {
        return new ForState(ast, payload);
    }

    @Override
    public CFGState interpretForEach(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't support for-each on CFG yet.");
    }

    @Override
    public CFGState interpretFunctionDecl(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't generate intra-procedural CFG for algorithms with declared functions.");
    }

    @Override
    public CFGState interpretIfThen(AST ast, CFGPayload payload)
    {
        return new IfStmtState(ast, payload);
    }

    @Override
    public CFGState interpretRepeatUntil(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't support repeat-until on CFG yet.");
    }

    @Override
    public CFGState interpretReturn(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretStmtSeq(AST ast, CFGPayload payload)
    {
        return new StatementSeqState(ast, payload);
    }

    @Override
    public CFGState interpretSuccess(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretUniform(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretWhile(AST ast, CFGPayload payload)
    {
        return new WhileState(ast, payload);
    }
}
