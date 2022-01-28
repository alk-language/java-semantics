package smt;

import ast.attr.*;
import ast.enums.BuiltInMethod;
import ast.enums.CompoundValueRepresentation;
import ast.enums.Operator;
import ast.expr.*;
import ast.expr.fol.EquivAST;
import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import ast.expr.fol.ImpliesAST;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import ast.symbolic.ValidSelectAST;
import ast.symbolic.ValidStoreAST;
import ast.type.ArrayDataTypeAST;
import ast.type.DataTypeAST;
import ast.type.SetDataTypeAST;
import com.microsoft.z3.*;
import execution.parser.exceptions.AlkException;
import util.exception.InternalException;
import util.exception.SMTUnexpectedException;
import util.exception.SMTUnimplementedException;
import util.types.ASTRepresentable;
import visitor.ifaces.ExpressionVisitorIface;
import visitor.ifaces.symbolic.SelectVisitorIface;
import visitor.ifaces.symbolic.StoreVisitorIface;
import visitor.ifaces.symbolic.ValidSelectVisitorIface;
import visitor.ifaces.symbolic.ValidStoreVisitorIface;

public class SMTVisitor
implements ExpressionVisitorIface<Expr>,
           StoreVisitorIface<Expr>,
           SelectVisitorIface<Expr>,
           ValidStoreVisitorIface<Expr>,
           ValidSelectVisitorIface<Expr>
{
    private final AlkSMTContext alkCtx;

    public SMTVisitor(AlkSMTContext alkCtx)
    {
        this.alkCtx = alkCtx;
    }

    @Override
    public Expr<?> visit(AdditiveAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        Expr expr = tree.getChild(0).accept(this);
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            Expr nxt = tree.getChild(i).accept(this);
            switch (attr.getOp(i - 1))
            {
                case ADD: expr = alkCtx.ctx.mkAdd(expr, nxt); break;
                case SUBTRACT: expr = alkCtx.ctx.mkSub(expr, nxt); break;
                default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(i - 1));
            }
        }
        return expr;
    }

    @Override
    public Expr<?> visit(ArrayAST tree)
    {
        RepresentationASTAttr attr = tree.getAttribute(RepresentationASTAttr.class);

        if (attr.getRepresentation() != CompoundValueRepresentation.EXPRESSIONS)
        {
            throw new SMTUnexpectedException("Can't process array with non-expression compound representation!");
        }

        ArrayDataTypeAST dataType = tree.getDataType(alkCtx);

        Expr array = alkCtx.getEmptyArray(dataType);
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            if (tree.getChild(i) instanceof UnknownAST) continue;
            Expr sub = tree.getChild(i).accept(this);
            array = alkCtx.ctx.mkStore(array, alkCtx.ctx.mkInt(i), sub);
        }

        AlkSMTSizeMethod solver = (AlkSMTSizeMethod) alkCtx.getBuiltInMethodSolver(BuiltInMethod.SIZE);
        solver.assumeEquality(array, tree.getChildCount());

        return array;
    }

    @Override
    public Expr<?> visit(BitwiseAndAST tree)
    {
        throw new SMTUnimplementedException(BitwiseAndAST.class);
    }

    @Override
    public Expr<?> visit(BitwiseOrAST ctx)
    {
        throw new SMTUnimplementedException(BitwiseOrAST.class);
    }

    @Override
    public Expr<?> visit(BoolAST tree)
    {
        return alkCtx.ctx.mkBool(tree.toString().equals("true"));
    }

    @Override
    public Expr<?> visit(BracketAST ctx)
    {
        throw new SMTUnimplementedException(BracketAST.class);
    }

    @Override
    public Expr<?> visit(BuiltinFunctionAST tree)
    {
        BuiltInFunctionASTAttr attr = tree.getAttribute(BuiltInFunctionASTAttr.class);
        SMTFunctionSolver solver = alkCtx.getBuiltInFunctionSolver(attr.getFunction());
        Expr[] params = new Expr[tree.getChildCount()];
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            params[i] = tree.getChild(i).accept(this);
        }
        return solver.apply(params);
    }

    @Override
    public Expr<?> visit(ConditionalExprAST ctx)
    {
        throw new SMTUnimplementedException(ConditionalExprAST.class);
    }

    @Override
    public Expr<?> visit(EqualityAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        if (attr.getOpCount() != 1)
        {
            throw new AlkException("Can't process relation expressions with more than one operator: " + alkCtx.ctx.toString());
        }
        switch (attr.getOp(0))
        {
            case EQUAL:
                Expr leftOp = tree.getChild(0).accept(this);
                Expr rightOp = tree.getChild(1).accept(this);
                return alkCtx.getOperatorSolver(Operator.EQUAL).apply(tree.isForArray(alkCtx), leftOp, rightOp);
            case NOTEQUAL:
                return alkCtx.ctx.mkNot(alkCtx.ctx.mkEq(tree.getChild(0).accept(this), tree.getChild(1).accept(this)));
            default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr<?> visit(FactorPointIdAST ctx)
    {
        throw new SMTUnimplementedException(FactorPointIdAST.class);
    }

    @Override
    public Expr<?> visit(FactorPointMethodAST tree)
    {
        BuiltInMethodASTAttr attr = tree.getAttribute(BuiltInMethodASTAttr.class);
        Expr root = tree.getChild(0).accept(this);
        SMTMethodSolver solver = alkCtx.getBuiltInMethodSolver(attr.getMethod());
        Expr[] params = new Expr[tree.getChildCount() - 1];
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            params[i - 1] = tree.getChild(i).accept(this);
        }
        return solver.apply(root, params, ((ExpressionAST) tree.getChild(0)).getDataType(alkCtx));
    }

    @Override
    public Expr<?> visit(FloatAST tree)
    {
        return alkCtx.ctx.mkRealConst(tree.getText());
    }

    @Override
    public Expr<?> visit(FunctionCallAST ctx)
    {
        throw new SMTUnimplementedException(FunctionCallAST.class);
    }

    @Override
    public Expr<?> visit(InExprAST ctx)
    {
        Expr lft = ctx.getChild(0).accept(this);
        ArrayExpr<?, ?> rgh = (ArrayExpr<?, ?>) ctx.getChild(1).accept(this);

        Expr[] bound = new Expr[] { alkCtx.ctx.mkConst(alkCtx.getFresh(), alkCtx.ctx.getIntSort()) };
        ArraySMTSupport support = alkCtx.getArraySupport(rgh.getSort());
        Expr body = alkCtx.ctx.mkLe(support.getLeft().apply(rgh), bound[0]);
        Expr body2 = alkCtx.ctx.mkLt(bound[0], support.getRight().apply(rgh));
        Expr body3 = alkCtx.ctx.mkEq(alkCtx.ctx.mkSelect(rgh, bound[0]), lft);
        return alkCtx.ctx.mkExists(bound, alkCtx.ctx.mkAnd(body, body2, body3), 1, null, null, null, null);
    }

    @Override
    public Expr<?> visit(IntAST tree)
    {
        return alkCtx.ctx.mkInt(tree.getText());
    }

    @Override
    public Expr<?> visit(ListAST ctx)
    {
        throw new SMTUnimplementedException(ListAST.class);
    }

    @Override
    public Expr<?> visit(LogicalAndAST tree)
    {
        Expr[] exprs = new Expr[tree.getChildCount()];
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            exprs[i] = tree.getChild(i).accept(this);
        }
        return alkCtx.ctx.mkAnd(exprs);
    }

    @Override
    public Expr<?> visit(LogicalOrAST tree)
    {
        Expr[] exprs = new Expr[tree.getChildCount()];
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            exprs[i] = tree.getChild(i).accept(this);
        }
        return alkCtx.ctx.mkOr(exprs);
    }

    @Override
    public Expr<?> visit(MultiplicativeAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        Expr expr = tree.getChild(0).accept(this);
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            Expr nxt = tree.getChild(i).accept(this);
            switch (attr.getOp(i - 1))
            {
                case MULTIPLY: expr = alkCtx.ctx.mkMul(expr, nxt); break;
                case DIVIDE: expr = alkCtx.ctx.mkDiv(expr, nxt); break;
                case MOD: expr = alkCtx.ctx.mkMod(expr, nxt); break;
                default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(i - 1));
            }
        }
        return expr;
    }

    @Override
    public Expr<?> visit(PostfixAST ctx)
    {
        throw new SMTUnimplementedException(PostfixAST.class);
    }

    @Override
    public Expr<?> visit(PrefixAST ctx)
    {
        throw new SMTUnimplementedException(PrefixAST.class);
    }

    @Override
    public Expr<?> visit(RefIDAST tree)
    {
        throw new SMTUnimplementedException(RefIDAST.class);
    }

    @Override
    public Expr<?> visit(RelationalAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        if (attr.getOpCount() != 1)
        {
            throw new AlkException("Can't process relation expressions with more than one operator: " + alkCtx.ctx.toString());
        }
        switch (attr.getOp(0))
        {
            case GREATER: return alkCtx.ctx.mkGt(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case LOWER: return alkCtx.ctx.mkLt(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case LOWEREQ: return alkCtx.ctx.mkLe(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case GREATEREQ: return alkCtx.ctx.mkGe(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr<?> visit(SetExprAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        Expr expr = tree.getChild(0).accept(this);
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            Expr nxt = tree.getChild(i).accept(this);
            switch (attr.getOp(i - 1))
            {
                case UNION: expr = alkCtx.ctx.mkSetUnion(expr, nxt); break;
                case INTERSECT: expr = alkCtx.ctx.mkSetIntersection(expr, nxt); break;
                case SETSUBTRACT: expr = alkCtx.ctx.mkSetSubset(expr, nxt); break;
                default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(i - 1));
            }
        }
        return expr;
    }

    @Override
    public Expr<?> visit(SetAST tree)
    {
        RepresentationASTAttr attr = tree.getAttribute(RepresentationASTAttr.class);

        if (attr.getRepresentation() != CompoundValueRepresentation.EXPRESSIONS)
        {
            throw new SMTUnexpectedException("Can't process array with non-expression compound representation!");
        }

        SetDataTypeAST dataType = tree.getDataType(alkCtx);

        Expr set = alkCtx.getEmptySet(dataType);
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            if (tree.getChild(i) instanceof UnknownAST) continue;
            Expr sub = tree.getChild(i).accept(this);
            set = alkCtx.ctx.mkStore(set, sub, alkCtx.ctx.mkBool(true));
        }

        // AlkSMTSizeMethod solver = (AlkSMTSizeMethod) alkCtx.getBuiltInMethodSolver(BuiltInMethod.SIZE);
        // solver.assumeEquality(set, tree.getChildCount());

        return set;
    }

    @Override
    public Expr<?> visit(ShiftAST ctx)
    {
        throw new SMTUnimplementedException(ShiftAST.class);
    }

    @Override
    public Expr<?> visit(StringAST tree)
    {
        return alkCtx.ctx.mkString(tree.toString());
    }

    @Override
    public Expr<?> visit(StructAST ctx)
    {
        throw new SMTUnimplementedException(StructAST.class);
    }

    @Override
    public Expr<?> visit(SymIDAST tree)
    {
        String id = "$" + tree.getId();
        if (!alkCtx.ids.containsKey(id))
        {
            throw new AlkException("Can't detect data type of symbolic value: " + id);
        }
        return alkCtx.ids.get(id);
    }

    @Override
    public Expr<?> visit(UnaryAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        switch (attr.getOp(0))
        {
            case NOT: return alkCtx.ctx.mkNot(tree.getChild(0).accept(this));
            default: throw new InternalException("Can't process unidentified unary operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr visit(SelectAST tree)
    {
        Expr target = tree.getChild(0).accept(this);
        Expr lft = alkCtx.getArraySupport((ArraySort) target.getSort()).getLeft().apply(target);
        return alkCtx.ctx.mkSelect(target, alkCtx.ctx.mkAdd(lft, tree.getChild(1).accept(this)));
    }

    @Override
    public Expr visit(StoreAST tree)
    {
        Expr target = tree.getChild(0).accept(this);
        Expr lft = alkCtx.getArraySupport((ArraySort) target.getSort()).getLeft().apply(target);
        return alkCtx.ctx.mkStore(tree.getChild(0).accept(this),
                                  alkCtx.ctx.mkAdd(tree.getChild(1).accept(this), lft),
                                  tree.getChild(2).accept(this));
    }

    @Override
    public Expr visit(AssignmentAST tree)
    {
        throw new SMTUnimplementedException(AssignmentAST.class);
    }

    @Override
    public Expr visit(UnknownAST ctx)
    {
        throw new AlkException("Can't check path condition if unknown value is used.");
    }

    @Override
    public Expr visit(ValidStoreAST tree)
    {
        Expr oldValue = tree.getChild(0).accept(this);
        Expr position = tree.getChild(1).accept(this);
        Expr value    = tree.getChild(2).accept(this);

        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) oldValue.getSort());
        return support.validateStore(oldValue, position, value);
    }

    @Override
    public Expr visit(ValidSelectAST tree)
    {
        Expr oldValue = tree.getChild(0).accept(this);
        Expr position = tree.getChild(1).accept(this);

        ArraySMTSupport support = alkCtx.getArraySupport((ArraySort) oldValue.getSort());
        return support.validateSelect(oldValue, position);
    }

    @Override
    public Expr visit(EquivAST ctx)
    {
        return alkCtx.ctx.mkEq(ctx.getChild(0).accept(this), ctx.getChild(1).accept(this));
    }

    @Override
    public Expr visit(ExistsExprAST tree)
    {
        Expr[] bound = new Expr[tree.getChildCount() - 1];
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            String id = tree.getChild(i).getAttribute(IdASTAttr.class).getId();
            bound[i - 1] = alkCtx.getExprById(id);
        }
        Expr body = tree.getExpr().accept(this);
        return alkCtx.ctx.mkExists(bound, body, 1, null, null, null, null);
    }

    @Override
    public Expr visit(ForAllExprAST tree)
    {
        Expr[] bound = new Expr[tree.getChildCount() - 1];
        for (int i = 1; i < tree.getChildCount(); i++)
        {
            String id = tree.getChild(i).getAttribute(IdASTAttr.class).getId();
            bound[i - 1] = alkCtx.getExprById(id);
        }
        Expr body = tree.getExpr().accept(this);
        return alkCtx.ctx.mkForall(bound, body, 1, null, null, null, null);
    }

    @Override
    public Expr visit(ImpliesAST ctx)
    {
        return alkCtx.ctx.mkImplies(ctx.getChild(0).accept(this), ctx.getChild(1).accept(this));
    }

    @Override
    public Expr visit(ResultAST ctx)
    {
        throw new SMTUnimplementedException(ResultAST.class);
    }
}
