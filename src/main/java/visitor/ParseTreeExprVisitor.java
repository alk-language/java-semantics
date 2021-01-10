package visitor;

import ast.*;
import ast.attr.OpsASTAttr;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class ParseTreeExprVisitor
extends alkBaseVisitor<AST>
{
    @Override
    public AST visitConditionalExpression(alkParser.ConditionalExpressionContext ctx)
    {
        AST condition = visit(ctx.logical_or_expression());
        if (ctx.expression().size() != 0)
        {
            AST thenExpr = visit(ctx.expression(0));
            AST elseExpr = visit(ctx.expression(1));

            AST condExpr = new ConditionalExprAST(ctx);
            condExpr.addChild(condition);
            condExpr.addChild(thenExpr);
            condExpr.addChild(elseExpr);

            return condExpr;
        }
        else
        {
            return condition;
        }
    }

    @Override
    public AST visitLogicalOrExpression(alkParser.LogicalOrExpressionContext ctx)
    {
        if (ctx.logical_and_expression().size() == 1)
            return visit(ctx.logical_and_expression(0));
        return process(ctx, new LogicalOrAST(ctx));
    }

    @Override
    public AST visitLogicalAndExpression(alkParser.LogicalAndExpressionContext ctx)
    {
        if (ctx.in_expression().size() == 1)
            return visit(ctx.in_expression(0));
        return process(ctx, new LogicalAndAST(ctx));
    }

    @Override
    public AST visitInExpression(alkParser.InExpressionContext ctx)
    {
        if (ctx.equality_expression().size() == 1)
            return visit(ctx.equality_expression(0));
        return process(ctx, new InExprAST(ctx));
    }

    @Override
    public AST visitEqualityExpression(alkParser.EqualityExpressionContext ctx)
    {
        if (ctx.relational_expression().size() == 1)
            return visit(ctx.relational_expression(0));
        return process(ctx, new EqualityAST(ctx));
    }

    @Override
    public AST visitRelationalExpression(alkParser.RelationalExpressionContext ctx)
    {
        if (ctx.set_expression().size() == 1)
            return visit(ctx.set_expression(0));
        return process(ctx, new RelationalAST(ctx));
    }

    @Override
    public AST visitSetExpression(alkParser.SetExpressionContext ctx)
    {
        if (ctx.bitwise_or().size() == 1)
            return visit(ctx.bitwise_or(0));
        return process(ctx, new SetExprAST(ctx));
    }

    @Override
    public AST visitBitwiseOrExpression(alkParser.BitwiseOrExpressionContext ctx)
    {
        if (ctx.bitwise_and().size() == 1)
            return visit(ctx.bitwise_and(0));
        return process(ctx, new BitwiseOrAST(ctx));
    }

    @Override
    public AST visitBitwiseAndExpression(alkParser.BitwiseAndExpressionContext ctx)
    {
        if (ctx.shift_expression().size() == 1)
            return visit(ctx.shift_expression(0));
        return process(ctx, new BitwiseAndAST(ctx));
    }

    @Override
    public AST visitShiftExpression(alkParser.ShiftExpressionContext ctx)
    {
        if (ctx.additive_expression().size() == 1)
            return visit(ctx.additive_expression(0));
        return process(ctx, new ShiftAST(ctx));
    }

    @Override
    public AST visitAdditiveExpression(alkParser.AdditiveExpressionContext ctx)
    {
        if (ctx.multiplicative_expression().size() == 1)
            return visit(ctx.multiplicative_expression(0));
        return process(ctx, new AdditiveAST(ctx));
    }

    @Override
    public AST visitMultiplicativeExpression(alkParser.MultiplicativeExpressionContext ctx)
    {
        if (ctx.unary_expression().size() == 1)
            return visit(ctx.unary_expression(0));
        return process(ctx, new MultiplicativeAST(ctx));
    }

    @Override
    public AST visitPrefixExpression(alkParser.PrefixExpressionContext ctx)
    {
        AST ast;
        OpsASTAttr ops;
        AST factor = visit(ctx.unary_expression());
        switch (ctx.getChild(0).getText())
        {
            case "++":
                ast = new PrefixAST(ctx);
                ast.addChild(factor);
                ops = new OpsASTAttr();
                ops.add(Operator.PLUSPLUSLEFT);
                ast.addAttribute(OpsASTAttr.class, ops);
                return ast;
            case "--":
                ast = new PrefixAST(ctx);
                ast.addChild(factor);
                ops = new OpsASTAttr();
                ops.add(Operator.MINUSMINUSLEFT);
                ast.addAttribute(OpsASTAttr.class, ops);
                return ast;
            default:
                return factor;
        }
    }

    @Override
    public AST visitPostfixExpression(alkParser.PostfixExpressionContext ctx)
    {
        AST factor = visit(ctx.factor());
        for (int i = 1; i < ctx.getChildCount(); i++)
        {
            AST ast = new PostfixAST(ctx);
            ast.addChild(factor);
            OpsASTAttr ops;

            switch (ctx.getChild(i).getText())
            {
                case "++":
                    ops = new OpsASTAttr();
                    ops.add(Operator.PLUSPLUSRIGHT);
                    ast.addAttribute(OpsASTAttr.class, ops);
                    break;
                case "--":
                    ops = new OpsASTAttr();
                    ops.add(Operator.MINUSMINUSRIGHT);
                    ast.addAttribute(OpsASTAttr.class, ops);
                    break;
            }

            factor = ast;
        }
        return factor;
    }

    @Override
    public AST visitUnaryExpression(alkParser.UnaryExpressionContext ctx)
    {
        AST ast = new UnaryAST(ctx);
        OpsASTAttr ops = new OpsASTAttr();
        AST factor = visit(ctx.unary_expression());
        switch (ctx.getChild(0).getText())
        {
            case "+":
                ops.add(Operator.POSITIVE);
                ast.addAttribute(OpsASTAttr.class, ops);
                return ast;
            case "-":
                ops.add(Operator.NEGATIVE);
                ast.addAttribute(OpsASTAttr.class, ops);
                return ast;
            case "!":
                ops.add(Operator.NOT);
                ast.addAttribute(OpsASTAttr.class, ops);
                return ast;
            default:
                return factor;
        }
    }

    @Override
    public AST visitToPostfixExpression(alkParser.ToPostfixExpressionContext ctx)
    {
        return visit(ctx.postfix_expression());
    }

    @Override
    public AST visitParanthesesFactor(alkParser.ParanthesesFactorContext ctx)
    {
        return visit(ctx.expression());
    }

    @Override
    public AST visitRefNameFactor(alkParser.RefNameFactorContext ctx)
    {
        return visit(ctx.ref_name());
    }

    @Override
    public AST visitRefID(alkParser.RefIDContext ctx)
    {
        RefIDAST ast = new RefIDAST(ctx);
        ast.setId(ctx.getText());
        return ast;
    }

    @Override
    public AST visitFactorArray(alkParser.FactorArrayContext ctx)
    {
        AST factor = visit(ctx.factor());
        AST expr = visit(ctx.expression());
        AST ast = new BracketAST(ctx);
        ast.addChild(factor);
        ast.addChild(expr);
        return ast;
    }

    @Override
    public AST visitToBaseFactor(alkParser.ToBaseFactorContext ctx)
    {
        return visit(ctx.base_factor());
    }

    @Override
    public AST visitBoolValue(alkParser.BoolValueContext ctx)
    {
        return new BoolAST(ctx);
    }

    @Override
    public AST visitIntValue(alkParser.IntValueContext ctx)
    {
        return new IntAST(ctx);
    }

    @Override
    public AST visitStringValue(alkParser.StringValueContext ctx)
    {
        return new StringAST(ctx);
    }

    @Override
    public AST visitDoubleValue(alkParser.DoubleValueContext ctx)
    {
        return new FloatAST(ctx);
    }

    @Override
    public AST visitArrayValue(alkParser.ArrayValueContext ctx)
    {
        return new ArrayVisitor(this).visit(ctx.array());
    }

    @Override
    public AST visitListValue(alkParser.ListValueContext ctx)
    {
        return new ListVisitor(this).visit(ctx.list());
    }

    @Override
    public AST visitSetValue(alkParser.SetValueContext ctx)
    {
        return new SetVisitor(this).visit(ctx.set());
    }

    @Override
    public AST visitStructureValue(alkParser.StructureValueContext ctx)
    {
        return new StructureVisitor(this).visit(ctx.structure());
    }

    private AST process(ParserRuleContext ctx, AST target)
    {
        boolean hasOps = false;
        OpsASTAttr ops = new OpsASTAttr();
        for (int i = 0; i < ctx.getChildCount(); i++)
        {
            Operator op = OperatorHelper.parseBinary(ctx.getChild(i).getText());
            if (op != null)
            {
                hasOps = true;
                ops.add(op);
            }
            else
            {
                target.addChild(visit(ctx.getChild(i)));
            }
        }

        if (hasOps)
            target.addAttribute(OpsASTAttr.class, ops);

        return target;
    }

    static class ArrayVisitor extends alkBaseVisitor<AST>
    {
        private final ParseTreeExprVisitor parseTreeExprVisitor;

        public ArrayVisitor(ParseTreeExprVisitor parseTreeExprVisitor)
        {
            this.parseTreeExprVisitor = parseTreeExprVisitor;
        }

        @Override
        public AST visitArrayWithExpressions(alkParser.ArrayWithExpressionsContext ctx)
        {
            AST ast = new ArrayAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            for (int i = 0; i < ctx.expression().size(); i++)
            {
                ast.addChild(parseTreeExprVisitor.visit(ctx.expression(i)));
            }
            return ast;
        }

        @Override
        public AST visitArrayWithInterval(alkParser.ArrayWithIntervalContext ctx)
        {
            AST ast = new ArrayAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.interval());
        }

        @Override
        public AST visitArrayWithSpec(alkParser.ArrayWithSpecContext ctx)
        {
            AST ast = new ArrayAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.spec());
        }
    }

    static class ListVisitor extends alkBaseVisitor<AST>
    {
        private final ParseTreeExprVisitor parseTreeExprVisitor;

        public ListVisitor(ParseTreeExprVisitor parseTreeExprVisitor)
        {
            this.parseTreeExprVisitor = parseTreeExprVisitor;
        }

        @Override
        public AST visitEmptyList(alkParser.EmptyListContext ctx)
        {
            AST ast = new ListAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            return ast;
        }

        @Override
        public AST visitListWithExpressions(alkParser.ListWithExpressionsContext ctx)
        {
            AST ast = new ListAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            for (int i = 0; i < ctx.expression().size(); i++)
            {
                ast.addChild(parseTreeExprVisitor.visit(ctx.expression(i)));
            }
            return ast;
        }

        @Override
        public AST visitListWithInterval(alkParser.ListWithIntervalContext ctx)
        {
            AST ast = new ListAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.interval());
        }

        @Override
        public AST visitListWithSpec(alkParser.ListWithSpecContext ctx)
        {
            AST ast = new ListAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.spec());
        }
    }

    static class SetVisitor extends alkBaseVisitor<AST>
    {
        private final ParseTreeExprVisitor parseTreeExprVisitor;

        public SetVisitor(ParseTreeExprVisitor parseTreeExprVisitor)
        {
            this.parseTreeExprVisitor = parseTreeExprVisitor;
        }

        @Override
        public AST visitSetWithExpressions(alkParser.SetWithExpressionsContext ctx)
        {
            AST ast = new SetAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            for (int i = 0; i < ctx.expression().size(); i++)
            {
                ast.addChild(parseTreeExprVisitor.visit(ctx.expression(i)));
            }
            return ast;
        }

        @Override
        public AST visitEmptySet(alkParser.EmptySetContext ctx)
        {
            AST ast = new SetAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            return ast;
        }

        @Override
        public AST visitSetWithInterval(alkParser.SetWithIntervalContext ctx)
        {
            AST ast = new SetAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.interval());
        }

        @Override
        public AST visitSetWithSpec(alkParser.SetWithSpecContext ctx)
        {
            AST ast = new SetAST(ctx);
            return new DataStructureVisitor(parseTreeExprVisitor, ast).visit(ctx.spec());
        }
    }
    static class StructureVisitor extends alkBaseVisitor<AST>
    {
        private final ParseTreeExprVisitor parseTreeExprVisitor;

        public StructureVisitor(ParseTreeExprVisitor parseTreeExprVisitor)
        {
            this.parseTreeExprVisitor = parseTreeExprVisitor;
        }

        @Override
        public AST visitStructureWithComponents(alkParser.StructureWithComponentsContext ctx)
        {
            AST strAST = new StructAST(ctx);
            for (int i = 0; i < ctx.component().size(); i++)
                strAST.addChild(visit(ctx.component(i)));
            return strAST;
        }

        @Override
        public AST visitComponentDefinition(alkParser.ComponentDefinitionContext ctx)
        {
            AST comp = new ComponentAST(ctx);
            IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
            comp.addAttribute(IdASTAttr.class, attr);
            comp.addChild(parseTreeExprVisitor.visit(ctx.expression()));
            return comp;
        }
    }

    static class DataStructureVisitor extends alkBaseVisitor<AST>
    {
        private final AST target;
        private final ParseTreeExprVisitor parseTreeExprVisitor;

        public DataStructureVisitor(ParseTreeExprVisitor parseTreeExprVisitor, AST ast)
        {
            target = ast;
            this.parseTreeExprVisitor = parseTreeExprVisitor;
        }

        public AST visitIntervalDefinition(alkParser.IntervalDefinitionContext ctx)
        {
            AST left = parseTreeExprVisitor.visit(ctx.expression(0));
            AST right = parseTreeExprVisitor.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.INTERVAL);
            target.addAttribute(RepresentationASTAttr.class, attr);

            target.addChild(left);
            target.addChild(right);

            return target;
        }

        public AST visitFilterSpecDefinition(alkParser.FilterSpecDefinitionContext ctx)
        {
            AST fromExpr = parseTreeExprVisitor.visit(ctx.expression(0));
            AST stExpr = parseTreeExprVisitor.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.FILTER_SPEC);
            target.addAttribute(RepresentationASTAttr.class, attr);
            IdASTAttr spec = new IdASTAttr(ctx.ID().getText());
            target.addAttribute(IdASTAttr.class, spec);

            target.addChild(fromExpr);
            target.addChild(stExpr);

            return target;
        }

        public AST visitSelectSpecDefinition(alkParser.SelectSpecDefinitionContext ctx)
        {
            AST changeExpr = parseTreeExprVisitor.visit(ctx.expression(0));
            AST fromExpr = parseTreeExprVisitor.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.SELECT_SPEC);
            target.addAttribute(RepresentationASTAttr.class, attr);
            IdASTAttr spec = new IdASTAttr(ctx.ID().getText());
            target.addAttribute(IdASTAttr.class, spec);

            target.addChild(changeExpr);
            target.addChild(fromExpr);

            return target;
        }
    }
}
