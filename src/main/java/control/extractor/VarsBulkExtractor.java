package control.extractor;

import ast.AST;
import ast.expr.RefIDAST;
import dataflow.CFG;

import java.util.*;

public class VarsBulkExtractor
{

    public Set<String> extract(AST ast)
    {
        Set<String> now = new HashSet<>();
        if (ast instanceof RefIDAST)
        {
            now.add(((RefIDAST) ast).getId());
            return now;
        }
        for (int i = 0; i < ast.getChildCount(); i++)
        {
            now.addAll(extract(ast.getChild(i)));
        }
        return now;
    }

    public Set<String> extract(CFG cfg)
    {
        Set<String> allVars = new HashSet<>();
        CFGVisitor visitor = new CFGVisitor();
        visitor.register(null, (ast) -> {
            allVars.addAll(extract(ast));
        });
        visitor.extract(cfg);
        return allVars;
    }

}
