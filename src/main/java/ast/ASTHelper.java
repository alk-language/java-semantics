package ast;

import ast.stmt.FunctionDeclAST;

import java.util.ArrayList;
import java.util.List;

public class ASTHelper
{
    public static List<FunctionDeclAST> getFunctions(AST root)
    {
        List<FunctionDeclAST> lst = new ArrayList<>();
        ASTVisitor<List<FunctionDeclAST>> visitor = new ASTVisitor<>(lst);
        visitor.register((tree) -> tree instanceof FunctionDeclAST, (tree, payload) -> {
            if (!((FunctionDeclAST) tree).getEnsures().isEmpty())
                payload.add((FunctionDeclAST) tree);
        });
        visitor.visit(root);
        return lst;
    }
}
