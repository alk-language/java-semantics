package symbolic;

import ast.AST;
import ast.expr.*;
import ast.symbolic.PointerAST;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import util.lambda.LocationGenerator;
import visitor.ifaces.ExpressionVisitorIface;
import visitor.ifaces.symbolic.PointerVisitorIface;
import visitor.ifaces.symbolic.SelectVisitorIface;
import visitor.ifaces.symbolic.StoreVisitorIface;

public class ASTCloner
implements ExpressionVisitorIface<AST>,
           StoreVisitorIface<AST>,
           SelectVisitorIface<AST>,
           PointerVisitorIface<AST>
{
    private LocationMapper mapper;
    private LocationGenerator generator;

    public ASTCloner() {}

    public ASTCloner(LocationMapper locationMapper)
    {
        this.mapper = locationMapper;
    }

    public ASTCloner(LocationGenerator locationGenerator)
    {
        this.generator = locationGenerator;
    }

    private AST process(AST ast, AST tree)
    {
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            ast.addChild(tree.getChild(i).accept(this));
        }
        ast.setAttrs(tree.getAttrs());
        if (tree.hasText())
            ast.setText(tree.getText());
        return ast;
    }

    @Override
    public AST visit(AdditiveAST tree)
    {
        return process(new AdditiveAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ArrayAST tree)
    {
        return process(new ArrayAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(BitwiseAndAST tree)
    {
        return process(new BitwiseAndAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(BitwiseOrAST tree)
    {
        return process(new BitwiseOrAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(BoolAST tree)
    {
        return process(new BoolAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(BracketAST tree)
    {
        return process(new BracketAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(BuiltinFunctionAST tree)
    {
        return process(new BuiltinFunctionAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ConditionalExprAST tree)
    {
        return process(new ConditionalExprAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(EqualityAST tree)
    {
        return process(new EqualityAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(FactorPointIdAST tree)
    {
        return process(new FactorPointIdAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(FactorPointMethodAST tree)
    {
        return process(new FactorPointIdAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(FloatAST tree)
    {
        return process(new FloatAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(FunctionCallAST tree)
    {
        return process(new FunctionCallAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(InExprAST tree)
    {
        return process(new InExprAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(IntAST tree)
    {
        return process(new IntAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ListAST tree)
    {
        return process(new ListAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(LogicalAndAST tree)
    {
        return process(new LogicalAndAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(LogicalOrAST tree)
    {
        return process(new LogicalOrAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(MultiplicativeAST tree)
    {
        return process(new MultiplicativeAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(PostfixAST tree)
    {
        return process(new PostfixAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(PrefixAST tree)
    {
        return process(new PrefixAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(RefIDAST tree)
    {
        return process(new RefIDAST(tree.getId()), tree);
    }

    @Override
    public AST visit(RelationalAST tree)
    {
        return process(new RelationalAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(SetExprAST tree)
    {
        return process(new SetExprAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(SetAST tree)
    {
        return process(new SetAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ShiftAST tree)
    {
        return process(new ShiftAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(StringAST tree)
    {
        return process(new StringAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(StructAST tree)
    {
        return process(new StructAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(SymIDAST tree)
    {
        return process(new SymIDAST(tree.getId()), tree);
    }

    @Override
    public AST visit(UnaryAST tree)
    {
        return process(new UnaryAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(AssignmentAST tree)
    {
        return process(new AssignmentAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(SelectAST tree)
    {
        return process(new SelectAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(StoreAST tree)
    {
        return process(new StoreAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(PointerAST tree)
    {
        Location loc = tree.getLocation();
        if (mapper != null)
            return new PointerAST(null, mapper.get(loc));
        else if (generator != null)
            return new PointerAST(null, generator.generate(loc.toRValue()));
        else
            return tree;
    }
}
