package ast;

import ast.stmt.FunctionDeclAST;
import execution.parser.exceptions.AlkException;

import java.util.ArrayList;
import java.util.List;

public class ASTHelper
{
    public static List<FunctionDeclAST> getFunctions(AST root)
    {
        List<FunctionDeclAST> lst = new ArrayList<>();
        ASTVisitor<List<FunctionDeclAST>> visitor = new ASTVisitor<>(lst);
        boolean[] inside = new boolean[1];
        visitor.registerPre((tree) -> tree instanceof FunctionDeclAST, (tree, payload) -> {
            if (!((FunctionDeclAST) tree).getEnsures().isEmpty())
                payload.add((FunctionDeclAST) tree);
            if (inside[0])
            {
                throw new AlkException("Can't define a function inside another function!");
            }
            inside[0] = true;
        });
        visitor.registerPost((tree) -> tree instanceof FunctionDeclAST, (tree, payload) -> {
            if (!((FunctionDeclAST) tree).getEnsures().isEmpty())
                payload.add((FunctionDeclAST) tree);
            inside[0] = false;
        });
        visitor.visit(root);
        return lst;
    }
}
