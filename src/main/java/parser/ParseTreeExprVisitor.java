package parser;

import ast.*;
import ast.attr.*;
import ast.expr.*;
import ast.expr.AssignmentAST;
import ast.expr.fol.EquivAST;
import ast.expr.fol.ExistsExprAST;
import ast.expr.fol.ForAllExprAST;
import ast.expr.fol.ImpliesAST;
import ast.symbolic.IdDeclAST;
import ast.type.*;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.ParserRuleContext;
import ast.enums.CompoundValueRepresentation;
import ast.enums.Operator;
import visitor.AnnoHelper;
import visitor.BuiltInFunctionHelper;
import visitor.BuiltInMethodHelper;
import visitor.OperatorHelper;

public class ParseTreeExprVisitor
extends alkBaseVisitor<AST>
{

    @Override
    public AST visitImpliesExpr(alkParser.ImpliesExprContext ctx)
    {
        AST ast = new ImpliesAST(ctx);
        ast.addChild(this.visit(ctx.assign_expression()));
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitEquivExpr(alkParser.EquivExprContext ctx)
    {
        AST ast = new EquivAST(ctx);
        ast.addChild(this.visit(ctx.assign_expression()));
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitForallExpr(alkParser.ForallExprContext ctx)
    {
        AST ast = new ForAllExprAST(ctx);
        ast.addChild(this.visit(ctx.expression()));
        for (int i = 0; i < ctx.ID().size(); i++)
        {
            String id = ctx.ID(i).getText();
            AST dataType = this.visit(ctx.dataType(i));

            IdDeclAST idDecl = new IdDeclAST(ctx);
            IdASTAttr attr = new IdASTAttr(id);
            idDecl.addAttribute(IdASTAttr.class, attr);
            idDecl.addChild(dataType);

            ast.addChild(idDecl);
        }
        return ast;
    }

    @Override
    public AST visitExistsExpr(alkParser.ExistsExprContext ctx)
    {
        AST ast = new ExistsExprAST(ctx);
        ast.addChild(this.visit(ctx.expression()));
        for (int i = 0; i < ctx.ID().size(); i++)
        {
            String id = ctx.ID(i).getText();
            AST dataType = this.visit(ctx.dataType(i));

            IdDeclAST idDecl = new IdDeclAST(ctx);
            IdASTAttr attr = new IdASTAttr(id);
            idDecl.addAttribute(IdASTAttr.class, attr);
            idDecl.addChild(dataType);

            ast.addChild(idDecl);
        }
        return ast;
    }

    @Override
    public AST visitFolToExpr(alkParser.FolToExprContext ctx)
    {
        return this.visit(ctx.assign_expression());
    }

    @Override
    public AST visitAssignExpression(alkParser.AssignExpressionContext ctx)
    {
        AST ast = new AssignmentAST(ctx);
        ast.addChild(this.visit(ctx.factor()));
        ast.addChild(this.visit(ctx.expression()));
        OpsASTAttr attr = new OpsASTAttr();
        attr.add(OperatorHelper.parseAssign(ctx.ASSIGNMENT_OPERATOR().getText()));
        ast.addAttribute(OpsASTAttr.class, attr);
        return ast;
    }

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
        ast.addChild(factor);
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
    public AST visitAnnoFactor(alkParser.AnnoFactorContext ctx)
    {
        AST expr = visit(ctx.expression());
        String annoText = ctx.anno().getText();
        AnnoAttr attr = new AnnoAttr();
        attr.add(AnnoHelper.textToEnum(annoText));
        expr.addAttribute(AnnoAttr.class, attr);
        return expr;
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
        ast.setId(ctx.ID().getText());
        return ast;
    }

    @Override
    public AST visitSymID(alkParser.SymIDContext ctx)
    {
        SymIDAST ast = new SymIDAST(ctx);
        ast.setId(ctx.ID().getText());
        return ast;
    }

    @Override
    public AST visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx)
    {
        AST ast = new FunctionCallAST(ctx);
        String id = ctx.ID().getText();
        ast.addAttribute(IdASTAttr.class, new IdASTAttr(id));
        for (int i = 0; i < ctx.expression().size(); i++)
        {
            ast.addChild(visit(ctx.expression(i)));
        }
        return ast;
    }

    @Override
    public AST visitFactorPointID(alkParser.FactorPointIDContext ctx)
    {
        FactorPointIdAST ast = new FactorPointIdAST(ctx);

        IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
        ast.addAttribute(IdASTAttr.class, attr);

        OpsASTAttr op = new OpsASTAttr();
        op.add(Operator.DOT);
        ast.addAttribute(OpsASTAttr.class, op);

        AST factor = visit(ctx.factor());
        ast.addChild(factor);

        return ast;
    }

    @Override
    public AST visitFactorPointMethod(alkParser.FactorPointMethodContext ctx)
    {
        FactorPointMethodAST ast = new FactorPointMethodAST(ctx);
        AST factor = visit(ctx.factor());
        ast.addChild(factor);

        BuiltInMethodVisitor visitor = new BuiltInMethodVisitor(this, ast);
        return visitor.visit(ctx.builtin_method());
    }

    @Override
    public AST visitBuiltinFunction(alkParser.BuiltinFunctionContext ctx)
    {
        BuiltinFunctionAST ast = new BuiltinFunctionAST(ctx);

        String functionName = ctx.function_name().getText();
        BuiltInFunctionASTAttr attr = new BuiltInFunctionASTAttr(BuiltInFunctionHelper.parse(functionName));
        ast.addAttribute(BuiltInFunctionASTAttr.class, attr);

        for (int i = 0; i < ctx.expression().size(); i++)
        {
            ast.addChild(visit(ctx.expression(i)));
        }

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
        OpsASTAttr ops = new OpsASTAttr();
        ops.add(Operator.BRACKET);
        ast.addAttribute(OpsASTAttr.class, ops);
        return ast;
    }

    @Override
    public AST visitResultFactor(alkParser.ResultFactorContext ctx)
    {
        return new ResultAST(ctx);
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
    public AST visitUnknownValue(alkParser.UnknownValueContext ctx)
    {
        return new UnknownAST(ctx);
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

    @Override
    public AST visitIntType(alkParser.IntTypeContext ctx)
    {
        return new IntDataTypeAST(ctx);
    }

    @Override
    public AST visitBoolType(alkParser.BoolTypeContext ctx)
    {
        return new BoolDataTypeAST(ctx);
    }

    @Override
    public AST visitFloatType(alkParser.FloatTypeContext ctx)
    {
        return new FloatDataTypeAST(ctx);
    }

    @Override
    public AST visitArrayType(alkParser.ArrayTypeContext ctx)
    {
        AST tree = new ArrayDataTypeAST(ctx);
        tree.addChild(visit(ctx.dataType()));
        return tree;
    }

    @Override
    public AST visitSetType(alkParser.SetTypeContext ctx)
    {
        AST tree = new SetDataTypeAST(ctx);
        tree.addChild(visit(ctx.dataType()));
        return tree;
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

    static class BuiltInMethodVisitor extends alkBaseVisitor<AST>
    {
        private final ParseTreeExprVisitor parseTreeExprVisitor;
        private final AST parent;

        public BuiltInMethodVisitor(ParseTreeExprVisitor parseTreeExprVisitor, AST parent)
        {
            this.parseTreeExprVisitor = parseTreeExprVisitor;
            this.parent = parent;
        }

        @Override
        public AST visitBuiltinMethod(alkParser.BuiltinMethodContext ctx)
        {
            String methodName = ctx.method_name().getText();
            BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethodHelper.parse(methodName));
            parent.addAttribute(BuiltInMethodASTAttr.class, attr);

            for (int i = 0; i < ctx.expression().size(); i++)
            {
                parent.addChild(parseTreeExprVisitor.visit(ctx.expression(i)));
            }

            return parent;
        }
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
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.COMPONENTS);
            strAST.addAttribute(RepresentationASTAttr.class, attr);

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

        @Override
        public AST visitEmptyStructure(alkParser.EmptyStructureContext ctx)
        {
            AST strAST = new StructAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            strAST.addAttribute(RepresentationASTAttr.class, attr);
            return strAST;
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

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.MAP_SPEC);
            target.addAttribute(RepresentationASTAttr.class, attr);
            IdASTAttr spec = new IdASTAttr(ctx.ID().getText());
            target.addAttribute(IdASTAttr.class, spec);

            target.addChild(changeExpr);
            target.addChild(fromExpr);

            return target;
        }
    }
}
