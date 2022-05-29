package main;

import ast.AST;
import ast.ASTHelper;
import ast.ASTVisitor;
import ast.attr.IdASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.expr.RefIDAST;
import ast.stmt.FunctionDeclAST;
import execution.Optimizer;
import execution.parser.AlkParser;
import execution.parser.env.AlkFunction;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.ParseTreeGlobals;
import util.functions.Parameter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FunctionInfo
{
    AlkFunction func;
    FunctionDeclAST ast;

    public FunctionInfo(AlkFunction f, FunctionDeclAST ast)
    {
        this.func = f;
        this.ast = ast;
    }
}

public class LanguageServer
{
    static AST root;
    static Map<String, FunctionInfo> functions = new HashMap<>();

    private static void addFunction(FunctionDeclAST tree)
    {
        String id = tree.getAttribute(IdASTAttr.class).getId();
        ParamASTAttr attr = tree.getAttribute(ParamASTAttr.class);
        List<Parameter> params = new ArrayList<>();
        List<String> modifies = new ArrayList<>();

        for (int i = 0; i < attr.getParamCount(); i++)
        {
            Parameter param = attr.getParameter(i);
            if (param.getType() == ParamType.GLOBAL)
                modifies.add(param.getName());
            else
                params.add(param);
        }

        AlkFunction f = new AlkFunction(id,
                params,
                modifies,
                tree.getBody(),
                tree.getRequires(),
                tree.getEnsures(),
                tree.getDataType());
        functions.put(id, new FunctionInfo(f, tree));
    }

    public static int searchVariableInFunction(FunctionDeclAST ast, String variable)
    {
        final Integer[] where = {-1};

        ASTVisitor<Integer> visitor = new ASTVisitor<>(where[0]);
        visitor.registerPre((tree) -> tree instanceof RefIDAST, (tree, payload) -> {
            if (tree.getText().equals(variable))
            {
                if (where[0] == -1)
                    where[0] = tree.getLine();
                else
                    where[0] = Math.min(where[0], tree.getLine());
            }
        });
        visitor.visit(ast);

        return where[0];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String line = reader.readLine();
            String[] tokens = line.split(" ");
            String command = tokens[0];
            switch (command)
            {
                case "load":
                {
                    ParseTree tree = AlkParser.execute(new File(tokens[1]), false, true);
                    root = ParseTreeGlobals.PARSE_TREE_VISITOR.visit(tree);
                    root = Optimizer.gatherMain(root, false);
                    List<FunctionDeclAST> functionList = ASTHelper.getFunctions(root, false);
                    functions.clear();
                    for (FunctionDeclAST f : functionList)
                    {
                        addFunction(f);
                    }
                    break;
                }
                case "function":
                {
                    FunctionInfo f = functions.get(tokens[1]);
                    if (f == null)
                    {
                        System.out.println("No function with that name");
                    }
                    else
                    {
                        System.out.println(f.func);
                    }
                    break;
                }
                case "where-f":
                {
                    FunctionInfo f = functions.get(tokens[1]);
                    if (f == null)
                    {
                        System.out.println("No function with that name");
                    }
                    else
                    {
                        System.out.println(f.ast.getLine());
                    }
                    break;
                }
                case "where-v":
                {
                    FunctionInfo f = functions.get(tokens[1]);
                    if (f == null)
                    {
                        System.out.println("No function with that name");
                        break;
                    }

                    int where = -1;

                    // Search in global variables
                    for (int i = 0; i < f.func.countModifies(); i++)
                    {
                        if (f.func.getModify(i).equals(tokens[2]))
                        {
                            where = searchVariableInFunction(functions.get("\\main").ast, tokens[2]);
                            break;
                        }
                    }

                    // Search in parameters
                    if (where == -1)
                    {
                        for (Parameter param : f.func.getParams())
                        {
                            if (param.getName().equals(tokens[2]))
                            {
                                where = f.ast.getLine();
                                break;
                            }
                        }
                    }

                    // Search in local variables
                    if (where == -1)
                    {
                        where = searchVariableInFunction(f.ast, tokens[2]);
                    }

                    if (where == -1)
                    {
                        System.out.println("No variable with that name");
                    }
                    else
                    {
                        System.out.println(where);
                    }
                }
            }
        }
    }
}
