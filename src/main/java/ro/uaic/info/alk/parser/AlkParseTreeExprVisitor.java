package ro.uaic.info.alk.parser;

import ro.uaic.info.alk.ast.attr.*;
import ro.uaic.info.alk.ast.expr.AssignmentAST;
import ro.uaic.info.alk.ast.expr.EquivAST;
import ro.uaic.info.alk.ast.expr.ExistsExprAST;
import ro.uaic.info.alk.ast.expr.ForAllExprAST;
import ro.uaic.info.alk.ast.expr.ImpliesAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.CompoundValueRepresentation;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.*;
import ro.uaic.info.alk.ast.type.*;
import ro.uaic.info.alk.visitor.AnnoHelper;
import ro.uaic.info.alk.visitor.BuiltInFunctionHelper;
import ro.uaic.info.alk.visitor.OperatorHelper;

public class AlkParseTreeExprVisitor
extends AlkBaseVisitor<AST>
{
    @Override
    public AST visitImpliesExpr(AlkParser.ImpliesExprContext ctx)
    {
        AST ast = new ImpliesAST(ctx);
        ast.addChild(this.visit(ctx.assign_expression()));
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitEquivExpr(AlkParser.EquivExprContext ctx)
    {
        AST ast = new EquivAST(ctx);
        ast.addChild(this.visit(ctx.assign_expression()));
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitForallExpr(AlkParser.ForallExprContext ctx)
    {
        AST ast = new ForAllExprAST(ctx);
        for (int i = 0; i < ctx.declarator().size(); i++)
        {
            ast.addChild(this.visit(ctx.declarator(i)));
        }
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitExistsExpr(AlkParser.ExistsExprContext ctx)
    {
        AST ast = new ExistsExprAST(ctx);
        for (int i = 0; i < ctx.declarator().size(); i++)
        {
            ast.addChild(this.visit(ctx.declarator(i)));
        }
        ast.addChild(this.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitAssignExpression(AlkParser.AssignExpressionContext ctx)
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
    public AST visitConditionalExpression(AlkParser.ConditionalExpressionContext ctx)
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
    public AST visitLogicalOrExpression(AlkParser.LogicalOrExpressionContext ctx)
    {
        if (ctx.logical_and_expression().size() == 1)
            return visit(ctx.logical_and_expression(0));
        return process(ctx, new LogicalOrAST(ctx));
    }

    @Override
    public AST visitLogicalAndExpression(AlkParser.LogicalAndExpressionContext ctx)
    {
        if (ctx.in_expression().size() == 1)
            return visit(ctx.in_expression(0));
        return process(ctx, new LogicalAndAST(ctx));
    }

    @Override
    public AST visitInExpression(AlkParser.InExpressionContext ctx)
    {
        if (ctx.equality_expression().size() == 1)
            return visit(ctx.equality_expression(0));
        return process(ctx, new InExprAST(ctx));
    }

    @Override
    public AST visitEqualityExpression(AlkParser.EqualityExpressionContext ctx)
    {
        if (ctx.relational_expression().size() == 1)
            return visit(ctx.relational_expression(0));
        return process(ctx, new EqualityAST(ctx));
    }

    @Override
    public AST visitRelationalExpression(AlkParser.RelationalExpressionContext ctx)
    {
        if (ctx.set_expression().size() == 1)
            return visit(ctx.set_expression(0));
        return process(ctx, new RelationalAST(ctx));
    }

    @Override
    public AST visitSetExpression(AlkParser.SetExpressionContext ctx)
    {
        if (ctx.bitwise_or().size() == 1)
            return visit(ctx.bitwise_or(0));
        return process(ctx, new SetExprAST(ctx));
    }

    @Override
    public AST visitBitwiseOrExpression(AlkParser.BitwiseOrExpressionContext ctx)
    {
        if (ctx.bitwise_and().size() == 1)
            return visit(ctx.bitwise_and(0));
        return process(ctx, new BitwiseOrAST(ctx));
    }

    @Override
    public AST visitBitwiseAndExpression(AlkParser.BitwiseAndExpressionContext ctx)
    {
        if (ctx.shift_expression().size() == 1)
            return visit(ctx.shift_expression(0));
        return process(ctx, new BitwiseAndAST(ctx));
    }

    @Override
    public AST visitShiftExpression(AlkParser.ShiftExpressionContext ctx)
    {
        if (ctx.additive_expression().size() == 1)
            return visit(ctx.additive_expression(0));
        return process(ctx, new ShiftAST(ctx));
    }

    @Override
    public AST visitAdditiveExpression(AlkParser.AdditiveExpressionContext ctx)
    {
        if (ctx.multiplicative_expression().size() == 1)
            return visit(ctx.multiplicative_expression(0));
        return process(ctx, new AdditiveAST(ctx));
    }

    @Override
    public AST visitMultiplicativeExpression(AlkParser.MultiplicativeExpressionContext ctx)
    {
        if (ctx.unary_expression().size() == 1)
            return visit(ctx.unary_expression(0));
        return process(ctx, new MultiplicativeAST(ctx));
    }

    @Override
    public AST visitPrefixExpression(AlkParser.PrefixExpressionContext ctx)
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
    public AST visitPostfixExpression(AlkParser.PostfixExpressionContext ctx)
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
    public AST visitUnaryExpression(AlkParser.UnaryExpressionContext ctx)
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
    public AST visitAnnoFactor(AlkParser.AnnoFactorContext ctx)
    {
        AST expr = visit(ctx.expression());
        String annoText = ctx.anno().getText();
        AnnoAttr attr = new AnnoAttr();
        attr.add(AnnoHelper.textToEnum(annoText));
        expr.addAttribute(AnnoAttr.class, attr);
        return expr;
    }

    @Override
    public AST visitParanthesesFactor(AlkParser.ParanthesesFactorContext ctx)
    {
        return visit(ctx.expression());
    }

    @Override
    public AST visitRefNameFactor(AlkParser.RefNameFactorContext ctx)
    {
        return visit(ctx.ref_name());
    }

    @Override
    public AST visitRefID(AlkParser.RefIDContext ctx)
    {
        RefIDAST ast = new RefIDAST(ctx);
        ast.setId(ctx.ID().getText());
        return ast;
    }

    @Override
    public AST visitSymID(AlkParser.SymIDContext ctx)
    {
        SymIDAST ast = new SymIDAST(ctx);
        ast.setId(ctx.ID().getText());
        return ast;
    }

    @Override
    public AST visitDefinedFunctionCall(AlkParser.DefinedFunctionCallContext ctx)
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
    public AST visitFactorPointID(AlkParser.FactorPointIDContext ctx)
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
    public AST visitFactorPointMethod(AlkParser.FactorPointMethodContext ctx)
    {
        FactorPointMethodAST ast = new FactorPointMethodAST(ctx);
        AST factor = visit(ctx.factor());
        ast.addChild(factor);

        BuiltInMethodVisitor visitor = new BuiltInMethodVisitor(ast);
        return visitor.visit(ctx.builtin_method());
    }

    @Override
    public AST visitBuiltinFunction(AlkParser.BuiltinFunctionContext ctx)
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
    public AST visitFactorArray(AlkParser.FactorArrayContext ctx)
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
    public AST visitResultFactor(AlkParser.ResultFactorContext ctx)
    {
        return new ResultAST(ctx);
    }

    @Override
    public AST visitOldFactor(AlkParser.OldFactorContext ctx)
    {
        AST tree = new OldAST(ctx);
        IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
        tree.addAttribute(IdASTAttr.class, attr);
        return tree;
    }

    @Override
    public AST visitBoolValue(AlkParser.BoolValueContext ctx)
    {
        return new BoolAST(ctx);
    }

    @Override
    public AST visitIntValue(AlkParser.IntValueContext ctx)
    {
        return new IntAST(ctx);
    }

    @Override
    public AST visitStringValue(AlkParser.StringValueContext ctx)
    {
        return new StringAST(ctx);
    }

    @Override
    public AST visitFloatValue(AlkParser.FloatValueContext ctx)
    {
        return new FloatAST(ctx);
    }

    @Override
    public AST visitArrayValue(AlkParser.ArrayValueContext ctx)
    {
        return new ArrayVisitor().visit(ctx.array());
    }

    @Override
    public AST visitListValue(AlkParser.ListValueContext ctx)
    {
        return new ListVisitor().visit(ctx.list());
    }

    @Override
    public AST visitSetValue(AlkParser.SetValueContext ctx)
    {
        return new SetVisitor().visit(ctx.set());
    }

    @Override
    public AST visitStructureValue(AlkParser.StructureValueContext ctx)
    {
        return new StructureVisitor().visit(ctx.structure());
    }

    @Override
    public AST visitMappingValue(AlkParser.MappingValueContext ctx)
    {
        return new MapVisitor().visit(ctx.mapping());
    }

    @Override
    public AST visitIntType(AlkParser.IntTypeContext ctx)
    {
        return new IntDataTypeAST(ctx);
    }

    @Override
    public AST visitBoolType(AlkParser.BoolTypeContext ctx)
    {
        return new BoolDataTypeAST(ctx);
    }

    @Override
    public AST visitFloatType(AlkParser.FloatTypeContext ctx)
    {
        return new FloatDataTypeAST(ctx);
    }

    @Override
    public AST visitArrayType(AlkParser.ArrayTypeContext ctx)
    {
        AST tree = new ArrayDataTypeAST(ctx);
        tree.addChild(visit(ctx.dataType()));
        return tree;
    }

    @Override
    public AST visitListType(AlkParser.ListTypeContext ctx)
    {
        AST tree = new ListDataTypeAST(ctx);
        tree.addChild(visit(ctx.dataType()));
        return tree;
    }

    @Override
    public AST visitSetType(AlkParser.SetTypeContext ctx)
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

    private class BuiltInMethodVisitor
    extends AlkBaseVisitor<AST>
    {
        private final AST parent;

        public BuiltInMethodVisitor(AST parent)
        {
            this.parent = parent;
        }

        @Override
        public AST visitBuiltinMethod(AlkParser.BuiltinMethodContext ctx)
        {
            String methodName = ctx.method_name().getText();
            BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.of(methodName));
            parent.addAttribute(BuiltInMethodASTAttr.class, attr);
            ctx.expression().forEach((expr) -> parent.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return parent;
        }
    }

    private class ArrayVisitor
    extends AlkBaseVisitor<AST>
    {
        @Override
        public AST visitArrayWithExpressions(AlkParser.ArrayWithExpressionsContext ctx)
        {
            AST ast = new ArrayAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            ctx.expression().forEach((expr) -> ast.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return ast;
        }

        @Override
        public AST visitArrayWithInterval(AlkParser.ArrayWithIntervalContext ctx)
        {
            return new DataStructureVisitor(new ArrayAST(ctx)).visit(ctx.interval());
        }

        @Override
        public AST visitArrayWithSpec(AlkParser.ArrayWithSpecContext ctx)
        {
            return new DataStructureVisitor(new ArrayAST(ctx)).visit(ctx.spec());
        }
    }

    private class ListVisitor
    extends AlkBaseVisitor<AST>
    {
        @Override
        public AST visitEmptyList(AlkParser.EmptyListContext ctx)
        {
            AST ast = new ListAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            return ast;
        }

        @Override
        public AST visitListWithExpressions(AlkParser.ListWithExpressionsContext ctx)
        {
            AST ast = new ListAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            ctx.expression().forEach((expr) -> ast.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return ast;
        }

        @Override
        public AST visitListWithInterval(AlkParser.ListWithIntervalContext ctx)
        {
            return new DataStructureVisitor(new ListAST(ctx)).visit(ctx.interval());
        }

        @Override
        public AST visitListWithSpec(AlkParser.ListWithSpecContext ctx)
        {
            return new DataStructureVisitor(new ListAST(ctx)).visit(ctx.spec());
        }
    }

    private class SetVisitor
    extends AlkBaseVisitor<AST>
    {
        @Override
        public AST visitSetWithExpressions(AlkParser.SetWithExpressionsContext ctx)
        {
            AST ast = new SetAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EXPRESSIONS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            ctx.expression().forEach((expr) -> ast.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return ast;
        }

        @Override
        public AST visitEmptySet(AlkParser.EmptySetContext ctx)
        {
            AST ast = new SetAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            if (ctx.dataType() != null)
            {
                ast.addChild(AlkParseTreeExprVisitor.this.visit(ctx.dataType()));
            }
            return ast;
        }

        @Override
        public AST visitSetWithInterval(AlkParser.SetWithIntervalContext ctx)
        {
            return new DataStructureVisitor(new SetAST(ctx)).visit(ctx.interval());
        }

        @Override
        public AST visitSetWithSpec(AlkParser.SetWithSpecContext ctx)
        {
            return new DataStructureVisitor(new SetAST(ctx)).visit(ctx.spec());
        }
    }

    private class StructureVisitor
    extends AlkBaseVisitor<AST>
    {
        @Override
        public AST visitStructureWithComponents(AlkParser.StructureWithComponentsContext ctx)
        {
            AST ast = new StructAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.COMPONENTS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            ctx.component().forEach((expr) -> ast.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return ast;
        }

        @Override
        public AST visitComponentDefinition(AlkParser.ComponentDefinitionContext ctx)
        {
            AST comp = new ComponentAST(ctx);
            IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
            comp.addAttribute(IdASTAttr.class, attr);
            comp.addChild(AlkParseTreeExprVisitor.this.visit(ctx.expression()));
            return comp;
        }

        @Override
        public AST visitEmptyStructure(AlkParser.EmptyStructureContext ctx)
        {
            AST ast = new StructAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            return ast;
        }
    }

    private class MapVisitor
    extends AlkBaseVisitor<AST>
    {
        @Override
        public AST visitMappingWithComponents(AlkParser.MappingWithComponentsContext ctx)
        {
            AST ast = new MapAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.COMPONENTS);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            ctx.mapping_component().forEach((expr) -> ast.addChild(AlkParseTreeExprVisitor.this.visit(expr)));
            return ast;
        }

        @Override
        public AST visitMappingComponentDefinition(AlkParser.MappingComponentDefinitionContext ctx)
        {
            AST comp = new ComponentAST(ctx);
            comp.addChild(AlkParseTreeExprVisitor.this.visit(ctx.expression(0)));
            comp.addChild(AlkParseTreeExprVisitor.this.visit(ctx.expression(1)));
            return comp;
        }

        @Override
        public AST visitEmptyMapping(AlkParser.EmptyMappingContext ctx)
        {
            AST ast = new MapAST(ctx);
            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.EMPTY);
            ast.addAttribute(RepresentationASTAttr.class, attr);
            return ast;
        }
    }

    private class DataStructureVisitor
    extends AlkBaseVisitor<AST>
    {
        private final AST target;

        public DataStructureVisitor(AST ast)
        {
            target = ast;
        }

        @Override
        public AST visitIntervalDefinition(AlkParser.IntervalDefinitionContext ctx)
        {
            AST left = AlkParseTreeExprVisitor.this.visit(ctx.expression(0));
            AST right = AlkParseTreeExprVisitor.this.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.INTERVAL);
            target.addAttribute(RepresentationASTAttr.class, attr);

            target.addChild(left);
            target.addChild(right);

            return target;
        }

        @Override
        public AST visitFilterSpecDefinition(AlkParser.FilterSpecDefinitionContext ctx)
        {
            AST fromExpr = AlkParseTreeExprVisitor.this.visit(ctx.expression(0));
            AST stExpr = AlkParseTreeExprVisitor.this.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.FILTER_SPEC);
            target.addAttribute(RepresentationASTAttr.class, attr);
            IdASTAttr spec = new IdASTAttr(ctx.ID().getText());
            target.addAttribute(IdASTAttr.class, spec);

            target.addChild(fromExpr);
            target.addChild(stExpr);

            return target;
        }

        @Override
        public AST visitSelectSpecDefinition(AlkParser.SelectSpecDefinitionContext ctx)
        {
            AST mapExpr = AlkParseTreeExprVisitor.this.visit(ctx.expression(0));
            AST fromExpr = AlkParseTreeExprVisitor.this.visit(ctx.expression(1));

            RepresentationASTAttr attr = new RepresentationASTAttr(CompoundValueRepresentation.MAP_SPEC);
            target.addAttribute(RepresentationASTAttr.class, attr);
            target.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.ID().getText()));

            target.addChild(mapExpr);
            target.addChild(fromExpr);

            return target;
        }
    }
}
