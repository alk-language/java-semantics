package symbolic;

import ast.AST;
import ast.VirtualAST;
import ast.expr.*;
import ast.expr.fol.EquivAST;
import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import ast.expr.fol.ImpliesAST;
import ast.symbolic.*;
import ast.type.DataTypeAST;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import execution.parser.env.LocationMapperIface;
import execution.parser.env.StoreImpl;
import util.exception.InternalException;
import util.lambda.LocationGenerator;
import visitor.ifaces.ExpressionVisitorIface;
import visitor.ifaces.expr.DataTypeVisitorIface;
import visitor.ifaces.expr.VirtualVisitorIface;
import visitor.ifaces.stmt.IdDeclVisitorIface;
import visitor.ifaces.symbolic.*;

public class ASTCloner
implements ExpressionVisitorIface<AST>,
           StoreVisitorIface<AST>,
           SelectVisitorIface<AST>,
           PointerVisitorIface<AST>,
           ValidSelectVisitorIface<AST>,
           ValidStoreVisitorIface<AST>,
           IdDeclVisitorIface<AST>,
           DataTypeVisitorIface<AST>,
           VirtualVisitorIface<AST>
{
    private LocationMapperIface mapper;
    private LocationGenerator generator;

    public ASTCloner(LocationMapperIface locationMapper)
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
        return process(new FactorPointMethodAST(tree.getCtx()), tree);
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
        {
            throw new InternalException("Cloning AST without proper generator or mapper!");
            // return tree;
        }
    }

    @Override
    public AST visit(UnknownAST tree)
    {
        return process(new UnknownAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ValidStoreAST tree)
    {
        return process(new ValidStoreAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ValidSelectAST tree)
    {
        return process(new ValidSelectAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(EquivAST tree)
    {
        return process(new EquivAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ExistsExprAST tree)
    {
        return process(new ExistsExprAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ForAllExprAST tree)
    {
        return process(new ForAllExprAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(ImpliesAST tree)
    {
        return process(new ImpliesAST(tree.getCtx()), tree);
    }

    @Override
    public AST visit(IdDeclAST tree)
    {
        return tree;
    }

    @Override
    public AST visit(DataTypeAST tree)
    {
        return tree;
    }

    @Override
    public AST visit(ResultAST tree)
    {
        return tree;
    }

    @Override
    public AST visit(MapAST tree)
    {
        return tree;
    }

    @Override
    public AST visit(VirtualAST tree)
    {
        return tree;
    }

    @Override
    public AST visit(OldAST tree)
    {
        return process(new OldAST(tree.getCtx()), tree);
    }
}
