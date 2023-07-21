package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.control.parser.states.*;
import ro.uaic.info.alk.visitor.stateful.StatefulStmtInterpreter;

public class CFGStmtInterpreter
implements StatefulStmtInterpreter<CFGPayload, CFGState>
{
    @Override
    public CFGState interpretAssume(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretAssert(AST tree, CFGPayload payload)
    {
        return new TerminalState(tree, payload);
    }

    @Override
    public CFGState interpretBlock(AST ast, CFGPayload payload)
    {
        return null;
    }

    @Override
    public CFGState interpretBreak(AST ast, CFGPayload payload)
    {
        throw new AlkException("Can't generate CFG for algorithms containing break statement!");
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
    public CFGState interpretHavoc(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
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
    public CFGState interpretSkip(AST ast, CFGPayload payload)
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
    public CFGState interpretSymbolicDecls(AST ast, CFGPayload payload)
    {
        return new TerminalState(ast, payload);
    }

    @Override
    public CFGState interpretSymbolicIdDecl(AST ast, CFGPayload payload)
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
