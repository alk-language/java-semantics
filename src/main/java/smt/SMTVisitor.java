package smt;

import ast.attr.OpsASTAttr;
import ast.expr.*;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Goal;
import execution.parser.exceptions.AlkException;
import util.exception.InternalException;
import util.exception.SMTUnimplementedException;
import visitor.ifaces.ExpressionVisitorIface;
import visitor.ifaces.symbolic.SelectVisitorIface;
import visitor.ifaces.symbolic.StoreVisitorIface;

import java.util.Map;

public class SMTVisitor
implements ExpressionVisitorIface<Expr>,
           StoreVisitorIface<Expr>,
           SelectVisitorIface<Expr>
{
    private final Context ctx;
    private final Goal g;
    private final Map<String, Expr<?>> ids;

    public SMTVisitor(Context ctx, Goal g, Map<String, Expr<?>> ids)
    {
        this.ctx = ctx;
        this.ids = ids;
        this.g = g;
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
                case ADD: expr = ctx.mkAdd(expr, nxt); break;
                case SUBTRACT: expr = ctx.mkSub(expr, nxt); break;
                default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(i - 1));
            }
        }
        return expr;
    }

    @Override
    public Expr<?> visit(ArrayAST ctx)
    {
        throw new SMTUnimplementedException(ArrayAST.class);
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
        return ctx.mkBool(tree.toString().equals("true"));
    }

    @Override
    public Expr<?> visit(BracketAST ctx)
    {
        throw new SMTUnimplementedException(BracketAST.class);
    }

    @Override
    public Expr<?> visit(BuiltinFunctionAST ctx)
    {
        throw new SMTUnimplementedException(BuiltinFunctionAST.class);
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
            throw new AlkException("Can't process relation expressions with more than one operator: " + ctx.toString());
        }
        switch (attr.getOp(0))
        {
            case EQUAL:
                return ctx.mkEq(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case NOTEQUAL:
                return ctx.mkNot(ctx.mkEq(tree.getChild(0).accept(this), tree.getChild(1).accept(this)));
            default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr<?> visit(FactorPointIdAST ctx)
    {
        throw new SMTUnimplementedException(FactorPointIdAST.class);
    }

    @Override
    public Expr<?> visit(FactorPointMethodAST ctx)
    {
        throw new SMTUnimplementedException(FactorPointMethodAST.class);
    }

    @Override
    public Expr<?> visit(FloatAST tree)
    {
        return ctx.mkRealConst(tree.getText());
    }

    @Override
    public Expr<?> visit(FunctionCallAST ctx)
    {
        throw new SMTUnimplementedException(FunctionCallAST.class);
    }

    @Override
    public Expr<?> visit(InExprAST ctx)
    {
        throw new SMTUnimplementedException(InExprAST.class);
    }

    @Override
    public Expr<?> visit(IntAST tree)
    {
        return ctx.mkInt(tree.getText());
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
        return ctx.mkAnd(exprs);
    }

    @Override
    public Expr<?> visit(LogicalOrAST tree)
    {
        Expr[] exprs = new Expr[tree.getChildCount()];
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            exprs[i] = tree.getChild(i).accept(this);
        }
        return ctx.mkOr(exprs);
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
                case MULTIPLY: expr = ctx.mkMul(expr, nxt); break;
                case DIVIDE: expr = ctx.mkDiv(expr, nxt); break;
                case MOD: expr = ctx.mkMod(expr, nxt); break;
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
            throw new AlkException("Can't process relation expressions with more than one operator: " + ctx.toString());
        }
        switch (attr.getOp(0))
        {
            case GREATER: return ctx.mkGt(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case LOWER: return ctx.mkLt(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case LOWEREQ: return ctx.mkLe(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            case GREATEREQ: return ctx.mkGe(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
            default: throw new InternalException("Can't process unidentified relational operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr<?> visit(SetExprAST ctx)
    {
        throw new SMTUnimplementedException(SetExprAST.class);
    }

    @Override
    public Expr<?> visit(SetAST ctx)
    {
        throw new SMTUnimplementedException(SetAST.class);
    }

    @Override
    public Expr<?> visit(ShiftAST ctx)
    {
        throw new SMTUnimplementedException(ShiftAST.class);
    }

    @Override
    public Expr<?> visit(StringAST tree)
    {
        return ctx.mkString(tree.toString());
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
        if (!ids.containsKey(id))
        {
            throw new AlkException("Can't detect data type of symbolic value: " + id);
        }
        return ids.get(id);
    }

    @Override
    public Expr<?> visit(UnaryAST tree)
    {
        OpsASTAttr attr = tree.getAttribute(OpsASTAttr.class);
        switch (attr.getOp(0))
        {
            case NOT: return ctx.mkNot(tree.getChild(0).accept(this));
            default: throw new InternalException("Can't process unidentified unary operator: " + attr.getOp(0));
        }
    }

    @Override
    public Expr visit(SelectAST tree)
    {
        return ctx.mkSelect(tree.getChild(0).accept(this), tree.getChild(1).accept(this));
    }

    @Override
    public Expr visit(StoreAST tree)
    {
        return ctx.mkStore(tree.getChild(0).accept(this), tree.getChild(1).accept(this), tree.getChild(2).accept(this));
    }

    @Override
    public Expr visit(AssignmentAST tree)
    {
        throw new SMTUnimplementedException(AssignmentAST.class);
    }
}
