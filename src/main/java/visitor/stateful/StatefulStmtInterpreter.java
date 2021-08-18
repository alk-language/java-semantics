package visitor.stateful;

import ast.AST;
import ast.stmt.AssertAST;
import state.Payload;
import state.State;

public interface StatefulStmtInterpreter<T extends Payload, S extends State<?, ?>>
{
    S interpretAssume(AST ast, T payload);
    S interpretAssert(AST tree, T payload);
    S interpretBlock(AST ast, T payload);
    S interpretBreak(AST ast, T payload);
    S interpretChoose(AST ast, T payload);
    S interpretContinue(AST ast, T payload);
    S interpretDoWhile(AST ast, T payload);
    S interpretExprStmt(AST ast, T payload);
    S interpretFailure(AST ast, T payload);
    S interpretFor(AST ast, T payload);
    S interpretForEach(AST ast, T payload);
    S interpretFunctionDecl(AST ast, T payload);
    S interpretIfThen(AST ast, T payload);
    S interpretRepeatUntil(AST ast, T payload);
    S interpretReturn(AST ast, T payload);
    S interpretStmtSeq(AST ast, T payload);
    S interpretSuccess(AST ast, T payload);
    S interpretSymbolicDecls(AST ast, T payload);
    S interpretSymbolicIdDecl(AST ast, T payload);
    S interpretUniform(AST ast, T payload);
    S interpretWhile(AST ast, T payload);
}