package parser;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.attr.OpsASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.expr.FunctionCallAST;
import ast.stmt.*;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import visitor.OperatorHelper;

public class ParseTreeVisitor
extends alkBaseVisitor<AST>
{
    private final alkBaseVisitor<AST> exprVisitor;

    ParseTreeVisitor()
    {
        exprVisitor = ParseTreeGlobals.getParseExprVisitor();
    }

    @Override
    public AST visitFunctionDecl(alkParser.FunctionDeclContext ctx)
    {
        return new FunctionVisitor().visit(ctx);
    }

    @Override
    public AST visitStartPoint(alkParser.StartPointContext ctx)
    {
        if (ctx.statement_sequence() != null)
            return visit(ctx.statement_sequence());
        return null;
    }

    @Override
    public AST visitBlock(alkParser.BlockContext ctx)
    {
        AST blockAST = new BlockAST(ctx);
        blockAST.addChild(visit(ctx.statement_sequence()));
        return blockAST;
    }

    @Override
    public AST visitStatementSeq(alkParser.StatementSeqContext ctx)
    {
        AST stmtSeqAst = new StmtSeqAST(ctx);
        for (int i = 0; i < ctx.statement().size(); i++)
        {
            stmtSeqAst.addChild(visit(ctx.statement(i)));
        }
        return stmtSeqAst;
    }

    @Override
    public AST visitToChooseStmt(alkParser.ToChooseStmtContext ctx)
    {
        return visit(ctx.choose());
    }

    @Override
    public AST visitToRepeat(alkParser.ToRepeatContext ctx)
    {
        return this.visit(ctx.repeat_struct());
    }

    @Override
    public AST visitToDoWhile(alkParser.ToDoWhileContext ctx)
    {
        return this.visit(ctx.do_while_struct());
    }

    @Override
    public AST visitRepeatStructure(alkParser.RepeatStructureContext ctx)
    {
        AST repeatAST = new RepeatUntilAST(ctx);
        repeatAST.addChild(visit(ctx.statement()));
        repeatAST.addChild(exprVisitor.visit(ctx.expression()));
        return repeatAST;
    }

    @Override
    public AST visitDoWhileStructure(alkParser.DoWhileStructureContext ctx)
    {
        AST ast = new DoWhileAST(ctx);
        ast.addChild(visit(ctx.statement()));
        ast.addChild(exprVisitor.visit(ctx.expression()));
        return ast;
    }

    @Override
    public AST visitWhileStructure(alkParser.WhileStructureContext ctx)
    {
        AST ast = new WhileAST(ctx);
        ast.addChild(exprVisitor.visit(ctx.expression()));
        ast.addChild(visit(ctx.statement()));
        return ast;
    }

    @Override
    public AST visitIfStructure(alkParser.IfStructureContext ctx)
    {
        AST ast = new IfThenAST(ctx);
        ast.addChild(exprVisitor.visit(ctx.expression()));
        ast.addChild(visit(ctx.statement(0)));
        if (ctx.statement().size() > 1)
        {
            ast.addChild(visit(ctx.statement(1)));
        }
        return ast;
    }

    @Override
    public AST visitForStructure(alkParser.ForStructureContext ctx)
    {
        AST ast = new ForAST(ctx);
        ast.addChild(exprVisitor.visit(ctx.expression(0)));
        ast.addChild(exprVisitor.visit(ctx.expression(1)));
        ast.addChild(exprVisitor.visit(ctx.expression(2)));
        ast.addChild(visit(ctx.statement()));
        return ast;
    }

    @Override
    public AST visitForEachStructure(alkParser.ForEachStructureContext ctx)
    {
        AST ast = new ForEachAST(ctx);
        IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
        ast.addAttribute(IdASTAttr.class, attr);

        ast.addChild(exprVisitor.visit(ctx.expression()));
        ast.addChild(visit(ctx.statement()));
        return ast;
    }

    @Override
    public AST visitChooseStmt(alkParser.ChooseStmtContext ctx)
    {
        AST ast = new ChooseAST(ctx);

        ast.addChild(exprVisitor.visit(ctx.expression(0)));
        ast.addChild(exprVisitor.visit(ctx.expression(1)));
        if (ctx.expression().size() > 2)
        {
            ast.addChild(exprVisitor.visit(ctx.expression(2)));
        }
        return ast;
    }

    @Override
    public AST visitUniformStmt(alkParser.UniformStmtContext ctx)
    {
        AST ast = new UniformAST(ctx);
        ast.addChild(exprVisitor.visit(ctx.expression(0)));
        ast.addChild(exprVisitor.visit(ctx.expression(1)));
        return ast;
    }

    @Override
    public AST visitExpressionStmt(alkParser.ExpressionStmtContext ctx)
    {
        AST ast = new ExprStmtAST(ctx);
        AST expr = exprVisitor.visit(ctx.expression());
        ast.addChild(expr);
        return ast;
    }

    @Override
    public AST visitContinueStmt(alkParser.ContinueStmtContext ctx)
    {
        return new ContinueAST(ctx);
    }

    @Override
    public AST visitBreakStmt(alkParser.BreakStmtContext ctx)
    {
        return new BreakAST(ctx);
    }

    @Override
    public AST visitSuccess(alkParser.SuccessContext ctx)
    {
        return new SuccessAST(ctx);
    }

    @Override
    public AST visitFailure(alkParser.FailureContext ctx)
    {
        return new FailureAST(ctx);
    }

    @Override
    public AST visitReturnStmt(alkParser.ReturnStmtContext ctx)
    {
        AST ast = new ReturnAST(ctx);
        if (ctx.expression() != null)
        {
            ast.addChild(exprVisitor.visit(ctx.expression()));
        }
        return ast;
    }

    class FunctionVisitor
    extends alkBaseVisitor<AST>
    {
        private AST ast;
        private final ParamASTAttr paramAttr = new ParamASTAttr();

        FunctionVisitor()
        {

        }

        @Override
        public AST visitFunctionDecl(alkParser.FunctionDeclContext ctx)
        {
            ast = new FunctionDeclAST(ctx);
            String id = ctx.ID(0).getText();
            ast.addAttribute(IdASTAttr.class, new IdASTAttr(id));

            for (int i = 0; i < ctx.param().size(); i++)
            {
                this.visit(ctx.param(i));
            }

            for (int i = 1; i < ctx.ID().size(); i++)
            {
                String mid = ctx.ID(i).getText();
                paramAttr.addParameter(ParamType.GLOBAL, mid);
            }

            ast.addAttribute(ParamASTAttr.class, paramAttr);
            ast.addChild(ParseTreeVisitor.this.visit(ctx.statement_block()));
            return ast;
        }

        @Override
        public AST visitParamDefinition(alkParser.ParamDefinitionContext ctx)
        {
            boolean isOut = ctx.OUT() != null;
            String id = ctx.ID().getText();
            paramAttr.addParameter(isOut ? ParamType.OUTPUT : ParamType.INPUT, id);
            return ast;
        }
    }
}
