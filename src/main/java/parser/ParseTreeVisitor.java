package parser;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.expr.RefIDAST;
import ast.stmt.*;
import ast.symbolic.SymbolicDeclsAST;
import ast.symbolic.IdDeclAST;
import ast.type.DataTypeAST;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import util.functions.Parameter;

public class ParseTreeVisitor
extends alkBaseVisitor<AST>
{
    public final alkBaseVisitor<AST> exprVisitor;

    ParseTreeVisitor()
    {
        exprVisitor = ParseTreeGlobals.getParseExprVisitor();
    }

    @Override
    public AST visitFunctionDecl(alkParser.FunctionDeclContext ctx)
    {
        return new FunctionVisitor(this, exprVisitor).visit(ctx);
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
    public AST visitToAssumeStmt(alkParser.ToAssumeStmtContext ctx)
    {
        return visit(ctx.assumeStmt());
    }

    @Override
    public AST visitToAssertStmt(alkParser.ToAssertStmtContext ctx)
    {
        return visit(ctx.assertStmt());
    }

    @Override
    public AST visitToHavocStmt(alkParser.ToHavocStmtContext ctx)
    {
        return visit(ctx.havocStmt());
    }

    @Override
    public AST visitAssume(alkParser.AssumeContext ctx)
    {
        AST exprAST = exprVisitor.visit(ctx.expression());
        AssumeAST assumeAST = new AssumeAST(ctx);
        assumeAST.addChild(exprAST);
        return assumeAST;
    }

    @Override
    public AST visitAssert(alkParser.AssertContext ctx)
    {
        AST exprAST = exprVisitor.visit(ctx.expression());
        AssertAST assertAST = new AssertAST(ctx);
        assertAST.addChild(exprAST);
        return assertAST;
    }

    @Override
    public AST visitHavoc(alkParser.HavocContext ctx)
    {
        AST havocAST = new HavocAST(ctx);
        for (TerminalNode nod : ctx.ID())
        {
            havocAST.addChild(new RefIDAST(nod.getText()));
        }
        return havocAST;
    }

    @Override
    public AST visitSymbolicDeclStmt(alkParser.SymbolicDeclStmtContext ctx)
    {
        return visit(ctx.symbolicStmt());
    }

    @Override
    public AST visitSymbolicDecls(alkParser.SymbolicDeclsContext ctx)
    {
        AST symDeclsAST = new SymbolicDeclsAST(ctx);
        for (int i = 0; i < ctx.symbolicDeclarator().size(); i++)
        {
            symDeclsAST.addChild(visit(ctx.symbolicDeclarator(i)));
        }
        return symDeclsAST;
    }

    @Override
    public AST visitSymbolicIdDecl(alkParser.SymbolicIdDeclContext ctx)
    {
        AST symbIdAST = new IdDeclAST(ctx);
        IdASTAttr attr = new IdASTAttr(ctx.ID().getText());
        symbIdAST.addAttribute(IdASTAttr.class, attr);
        AST typeAST = exprVisitor.visit(ctx.dataType());
        symbIdAST.addChild(typeAST);
        return symbIdAST;
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
        return new WhileVisitor(this).visit(ctx);
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
        private FunctionDeclAST ast;
        private final alkBaseVisitor<AST> parent;
        private final alkBaseVisitor<AST> exprVisitor;
        private final ParamASTAttr paramAttr = new ParamASTAttr();

        FunctionVisitor(alkBaseVisitor<AST> parent, alkBaseVisitor<AST> exprVisitor)
        {
            this.parent = parent;
            this.exprVisitor = exprVisitor;
        }

        @Override
        public AST visitFunctionDecl(alkParser.FunctionDeclContext ctx)
        {
            ast = new FunctionDeclAST(ctx);
            String id = ctx.ID(0).getText();
            ast.addAttribute(IdASTAttr.class, new IdASTAttr(id));
            if (ctx.dataType() != null)
            {
                ast.setDataType(exprVisitor.visit(ctx.dataType()));
            }

            for (int i = 0; i < ctx.param().size(); i++)
            {
                this.visit(ctx.param(i));
            }

            for (int i = 1; i < ctx.ID().size(); i++)
            {
                String mid = ctx.ID(i).getText();
                paramAttr.addParameter(new Parameter(mid, ParamType.GLOBAL, null));
            }

            ast.addAttribute(ParamASTAttr.class, paramAttr);

            for (int i = 0; i < ctx.req_expression().size(); i++)
            {
                AST expr = exprVisitor.visit(ctx.req_expression(i));
                ast.addRequires(expr);
            }

            for (int i = 0; i < ctx.ens_expression().size(); i++)
            {
                AST expr = exprVisitor.visit(ctx.ens_expression(i));
                ast.addEnsures(expr);
            }

            ast.addChild(ParseTreeVisitor.this.visit(ctx.statement_block()));
            return ast;
        }

        @Override
        public AST visitParamDefinition(alkParser.ParamDefinitionContext ctx)
        {
            boolean isOut = ctx.OUT() != null;
            String id = ctx.ID().getText();
            paramAttr.addParameter(new Parameter(id, isOut ? ParamType.OUTPUT : ParamType.INPUT,
                    ctx.dataType() != null ? (DataTypeAST) exprVisitor.visit(ctx.dataType()) : null));
            return ast;
        }
    }

    class WhileVisitor
    extends alkBaseVisitor<AST>
    {
        ParamASTAttr paramAttr = new ParamASTAttr();
        AST whileAst;
        alkBaseVisitor<AST> stmtVisitor;

        WhileVisitor(alkBaseVisitor<AST> stmtVisitor)
        {
            this.stmtVisitor = stmtVisitor;
        }

        @Override
        public AST visitWhileStructure(alkParser.WhileStructureContext ctx)
        {
            whileAst = new WhileAST(ctx);
            whileAst.addChild(exprVisitor.visit(ctx.expression()));

            for (int i = 0; i < ctx.while_anno().size(); i++)
            {
                visit(ctx.while_anno(i));
            }

            if (paramAttr.getParamCount() != 0)
            {
                whileAst.addAttribute(ParamASTAttr.class, paramAttr);
            }
            whileAst.addChild(stmtVisitor.visit(ctx.statement()));

            return whileAst;
        }

        @Override
        public AST visitInvariantAnno(alkParser.InvariantAnnoContext ctx)
        {
            whileAst.addChild(exprVisitor.visit(ctx.expression()));
            return null;
        }

        @Override
        public AST visitModifiesAnno(alkParser.ModifiesAnnoContext ctx)
        {
            for (int i = 0; i < ctx.ID().size(); i++)
            {
                String mid = ctx.ID(i).getText();
                paramAttr.addParameter(new Parameter(mid, ParamType.GLOBAL, null));
            }
            return null;
        }
    }
}
