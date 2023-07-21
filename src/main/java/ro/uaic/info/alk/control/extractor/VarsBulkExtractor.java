package ro.uaic.info.alk.control.extractor;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.expr.RefIDAST;
import ro.uaic.info.alk.ast.stmt.FunctionDeclAST;
import ro.uaic.info.alk.dataflow.CFG;

import java.util.*;

public class VarsBulkExtractor
{
    private final boolean includeParams;

    public VarsBulkExtractor()
    {
        this(false);
    }

    public VarsBulkExtractor(boolean includeParams)
    {
        this.includeParams = includeParams;
    }

    public Set<String> extract(AST ast)
    {
        Set<String> now = new HashSet<>();
        if (ast instanceof RefIDAST)
        {
            now.add(((RefIDAST) ast).getId());
            return now;
        }
        if (includeParams)
        {
            if (ast instanceof FunctionDeclAST)
            {
                ParamASTAttr attr = ast.getAttribute(ParamASTAttr.class);
                for (int i = 0; i < attr.getParamCount(); i++)
                {
                    String pName = attr.getParameter(i).getName();
                    now.add(pName);
                }
            }
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
