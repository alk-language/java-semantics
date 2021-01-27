package parser;

import ast.AST;
import grammar.alkBaseVisitor;

public class ParseTreeGlobals
{
    public static alkBaseVisitor<AST> PARSE_TREE_VISITOR = new ParseTreeVisitor();
    public static alkBaseVisitor<AST> PARSE_TREE_EXPR_VISITOR = new ParseTreeExprVisitor();

    public static alkBaseVisitor<AST> getParseVisitor()
    {
        if (PARSE_TREE_VISITOR == null)
        {
            PARSE_TREE_VISITOR = new ParseTreeVisitor();
        }
        return PARSE_TREE_VISITOR;
    }

    public static alkBaseVisitor<AST> getParseExprVisitor()
    {
        if (PARSE_TREE_EXPR_VISITOR == null)
        {
            PARSE_TREE_EXPR_VISITOR = new ParseTreeExprVisitor();
        }
        return PARSE_TREE_EXPR_VISITOR;
    }
}
