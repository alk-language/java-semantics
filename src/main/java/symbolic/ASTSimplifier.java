package symbolic;

import ast.AST;
import ast.expr.IntAST;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;

public class ASTSimplifier
extends ASTCloner
{
    private AST find(AST tree, int position, boolean optimized)
    {
        if (tree instanceof StoreAST)
        {
            AST nxtData = tree.getChild(0);
            AST storePos = tree.getChild(1);
            AST storeValue = tree.getChild(2);

            if (storePos instanceof IntAST)
            {
                int nxtPos = Integer.parseInt((storePos).getText());
                if (nxtPos == position)
                {
                    return storeValue;
                }
                return find(nxtData, position, true);
            }
        }
        if (!optimized)
        {
            return null;
        }
        SelectAST ast = new SelectAST(null);
        ast.addChild(tree);
        ast.addChild(new IntAST(String.valueOf(position)));
        return ast;
    }

    @Override
    public AST visit(SelectAST tree)
    {
        AST posAST = tree.getChild(1);
        if (posAST instanceof IntAST)
        {
            int position = Integer.parseInt((posAST).getText());
            AST target = find(tree.getChild(0), position, false);

            if (target == null)
                return super.visit(tree);

            return target.accept(this);
        }
        else
        {
            return super.visit(tree);
        }
    }

    /*@Override
    public AST visit(StoreAST tree)
    {
        return process(new StoreAST(tree.getCtx()), tree);
    }*/
}
