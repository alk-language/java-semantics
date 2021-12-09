package symbolic;

import ast.AST;
import ast.expr.BoolAST;
import ast.expr.IntAST;
import ast.symbolic.*;
import execution.parser.env.Location;
import execution.parser.env.LocationMapperIface;
import util.exception.IncompleteASTException;
import util.lambda.LocationGenerator;

public class ASTSimplifier
extends ASTCloner
{
    private final boolean fixedLocations;

    public ASTSimplifier(LocationMapperIface lm)
    {
        this(lm, false);
    }

    public ASTSimplifier(LocationMapperIface lm, boolean fixedLocations)
    {
        super(lm);
        this.fixedLocations = fixedLocations;
    }

    public ASTSimplifier(LocationGenerator locationGenerator)
    {
        this(locationGenerator, false);
    }

    public ASTSimplifier(LocationGenerator locationGenerator, boolean fixedLocations)
    {
        super(locationGenerator);
        this.fixedLocations = fixedLocations;
    }

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
    public AST visit(PointerAST tree)
    {
        if (fixedLocations)
        {
            Location loc = tree.getLocation();
            if (loc.isUnknown())
            {
                throw new IncompleteASTException();
            }
            return SymbolicValue.toSymbolic(loc.toRValue()).toAST().accept(this);
        }
        return super.visit(tree);
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

    @Override
    public AST visit(StoreAST tree)
    {
        // TODO: (store (store a 0 1) 0 2) ~> (store a 0 2)
        if (fixedLocations)
            return simplifyStore(tree, new StoreAST(null), null);
        return super.visit(tree);
    }

    @Override
    public AST visit(ValidStoreAST tree)
    {
        if (fixedLocations)
            return simplifyStore(tree, new ValidStoreAST(null), new BoolAST("true"));
        return super.visit(tree);
    }

    private AST simplifyStore(AST tree, AST finalAST, AST retValue)
    {
        if (tree.getChild(2) instanceof PointerAST && ((PointerAST) tree.getChild(2)).getLocation().isUnknown())
        {
            throw new IncompleteASTException();
        }

        AST target = tree.getChild(0).accept(this);
        AST position = tree.getChild(1).accept(this);
        AST value = tree.getChild(2).accept(this);

        if (value instanceof SelectAST)
        {
            SelectAST selAST = (SelectAST) value;
            AST selTarget = selAST.getChild(0);
            AST selPosition = selAST.getChild(1);

            if (selPosition.equals(position) && target.equals(selTarget))
            {
                return retValue == null ? target : retValue;
            }
        }

        finalAST.addChild(target);
        finalAST.addChild(position);
        finalAST.addChild(value);
        return finalAST;
    }
}
