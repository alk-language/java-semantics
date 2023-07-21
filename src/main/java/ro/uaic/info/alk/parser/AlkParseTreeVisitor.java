package ro.uaic.info.alk.parser;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.stmt.*;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.enums.ParamType;
import ro.uaic.info.alk.ast.expr.UnaryAST;
import ro.uaic.info.alk.ast.symbolic.SymbolicDeclsAST;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import ro.uaic.info.alk.util.functions.Parameter;

import java.util.List;

public class AlkParseTreeVisitor
extends AlkBaseVisitor<AST>
{
    private final AlkBaseVisitor<AST> exprVisitor;

    public AlkParseTreeVisitor()
    {
        exprVisitor = new AlkParseTreeExprVisitor();
    }

    @Override
    public AST visitStartPoint(AlkParser.StartPointContext ctx)
    {
        return visit(ctx.statement_sequence());
    }

    @Override
    public AST visitFunctionDecl(AlkParser.FunctionDeclContext ctx)
    {
        return new FunctionVisitor().visit(ctx);
    }

    @Override
    public AST visitBlock(AlkParser.BlockContext ctx)
    {
        return new BlockAST(new ParseRuleContextAdapter(ctx), visit(ctx.statement_sequence()));
    }

    @Override
    public AST visitStatementSeq(AlkParser.StatementSeqContext ctx)
    {
        AST stmtSeqAst = new StmtSeqAST(new ParseRuleContextAdapter(ctx));
        ctx.statement().forEach((stmt) -> stmtSeqAst.addChild(visit(stmt)));
        return stmtSeqAst;
    }

    @Override
    public AST visitVar(AlkParser.VarContext ctx)
    {
        AST varAST = new VarAST(new ParseRuleContextAdapter(ctx));
        ctx.declarator().forEach((decl) -> varAST.addChild(decl.accept(this)));
        return varAST;
    }

    @Override
    public AST visitToSpecification(AlkParser.ToSpecificationContext ctx)
    {
        return visit(ctx.specification());
    }

    @Override
    public AST visitMainReqSpec(AlkParser.MainReqSpecContext ctx)
    {
        return visit(ctx.req_expression());
    }

    @Override
    public AST visitReqExpression(AlkParser.ReqExpressionContext ctx)
    {
        RequireAST tree = new RequireAST(new ParseRuleContextAdapter(ctx));
        tree.addChild(exprVisitor.visit(ctx.expression()));
        return tree;
    }

    @Override
    public AST visitMainEnsSpec(AlkParser.MainEnsSpecContext ctx)
    {
        return visit(ctx.ens_expression());
    }

    @Override
    public AST visitEnsExpression(AlkParser.EnsExpressionContext ctx)
    {
        EnsureAST tree = new EnsureAST(new ParseRuleContextAdapter(ctx));
        tree.addChild(exprVisitor.visit(ctx.expression()));
        return tree;
    }

    @Override
    public AST visitAssume(AlkParser.AssumeContext ctx)
    {
        return new AssumeAST(new ParseRuleContextAdapter(ctx), exprVisitor.visit(ctx.expression()));
    }

    @Override
    public AST visitAssert(AlkParser.AssertContext ctx)
    {
        return new AssertAST(new ParseRuleContextAdapter(ctx), exprVisitor.visit(ctx.expression()));
    }

    @Override
    public AST visitHavoc(AlkParser.HavocContext ctx)
    {
        AST havocAST = new HavocAST(new ParseRuleContextAdapter(ctx));
        ctx.declarator().forEach((decl) -> decl.accept(this));
        return havocAST;
    }

    @Override
    public AST visitDecl(AlkParser.DeclContext ctx)
    {
        AST ast = new DeclAST(new ParseRuleContextAdapter(ctx));
        ast.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.ID().getText()));
        ast.addChild(ctx.dataType().accept(exprVisitor));
        return ast;
    }

    @Override
    public AST visitSymbolicDecls(AlkParser.SymbolicDeclsContext ctx)
    {
        AST symDeclsAST = new SymbolicDeclsAST(new ParseRuleContextAdapter(ctx));
        ctx.symbolicDeclarator().forEach((decl) -> symDeclsAST.addChild(visit(decl)));
        return symDeclsAST;
    }

    @Override
    public AST visitSymbolicIdDecl(AlkParser.SymbolicIdDeclContext ctx)
    {
        AST symbIdAST = new DeclAST(new ParseRuleContextAdapter(ctx));
        symbIdAST.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.SYM().getText() + ctx.ID().getText()));
        symbIdAST.addChild(exprVisitor.visit(ctx.dataType()));
        return symbIdAST;
    }

    @Override
    public AST visitRepeatStructure(AlkParser.RepeatStructureContext ctx)
    {
        return new WhileVisitor().visit(ctx);
    }

    @Override
    public AST visitDoWhileStructure(AlkParser.DoWhileStructureContext ctx)
    {
        return new WhileVisitor().visit(ctx);
    }

    @Override
    public AST visitWhileStructure(AlkParser.WhileStructureContext ctx)
    {
        return new WhileVisitor().visit(ctx);
    }

    @Override
    public AST visitForStructure(AlkParser.ForStructureContext ctx)
    {
        return new WhileVisitor().visit(ctx);
    }

    @Override
    public AST visitIfStructure(AlkParser.IfStructureContext ctx)
    {
        AST ast = new IfThenAST(new ParseRuleContextAdapter(ctx));
        ast.addChild(exprVisitor.visit(ctx.expression()));
        ast.addChild(visit(ctx.statement(0)));
        if (ctx.statement().size() > 1)
        {
            ast.addChild(visit(ctx.statement(1)));
        }
        return ast;
    }

    @Override
    public AST visitForEachStructure(AlkParser.ForEachStructureContext ctx)
    {
        AST ast = new ForEachAST(new ParseRuleContextAdapter(ctx));
        ast.addAttribute(IdASTAttr.class, new IdASTAttr(ctx.ID().getText()));
        ast.addChild(exprVisitor.visit(ctx.expression()));
        ast.addChild(visit(ctx.statement()));
        return ast;
    }

    @Override
    public AST visitChooseStmt(AlkParser.ChooseStmtContext ctx)
    {
        ASTContext adapter = new ParseRuleContextAdapter(ctx);
        AST ast = new ChooseAST(adapter);

        ast.addChild(exprVisitor.visit(ctx.expression(0)));
        ast.addChild(exprVisitor.visit(ctx.expression(1)));
        if (ctx.expression().size() > 2)
        {
            // such that case
            AST stmtSeq = new StmtSeqAST(adapter);
            AST ifAST = new IfThenAST(adapter);

            AST negateAST = UnaryAST.createUnary(Operator.NOT, exprVisitor.visit(ctx.expression(2)));
            ifAST.addChild(negateAST);
            ifAST.addChild(new FailureAST(adapter));

            stmtSeq.addChild(ast);
            stmtSeq.addChild(ifAST);

            return new BlockAST(adapter, stmtSeq);
        }

        return ast;
    }

    @Override
    public AST visitUniformStmt(AlkParser.UniformStmtContext ctx)
    {
        AST ast = new UniformAST(new ParseRuleContextAdapter(ctx));
        ast.addChild(exprVisitor.visit(ctx.expression(0)));
        ast.addChild(exprVisitor.visit(ctx.expression(1)));
        return ast;
    }

    @Override
    public AST visitExpressionStmt(AlkParser.ExpressionStmtContext ctx)
    {
        return new ExprStmtAST(new ParseRuleContextAdapter(ctx), exprVisitor.visit(ctx.expression()));
    }

    @Override
    public AST visitContinueStmt(AlkParser.ContinueStmtContext ctx)
    {
        return new ContinueAST(new ParseRuleContextAdapter(ctx));
    }

    @Override
    public AST visitBreakStmt(AlkParser.BreakStmtContext ctx)
    {
        return new BreakAST(new ParseRuleContextAdapter(ctx));
    }

    @Override
    public AST visitSuccess(AlkParser.SuccessContext ctx)
    {
        return new SuccessAST(new ParseRuleContextAdapter(ctx));
    }

    @Override
    public AST visitFailure(AlkParser.FailureContext ctx)
    {
        return new FailureAST(new ParseRuleContextAdapter(ctx));
    }

    @Override
    public AST visitReturnStmt(AlkParser.ReturnStmtContext ctx)
    {
        AST target = ctx.expression() == null ? null : exprVisitor.visit(ctx.expression());
        return new ReturnAST(new ParseRuleContextAdapter(ctx), target);
    }

    private class FunctionVisitor
    extends AlkBaseVisitor<AST>
    {
        private FunctionDeclAST ast;
        private final ParamASTAttr paramAttr = new ParamASTAttr();

        @Override
        public AST visitFunctionDecl(AlkParser.FunctionDeclContext ctx)
        {
            ast = new FunctionDeclAST(new ParseRuleContextAdapter(ctx));
            String id = ctx.ID().getText();
            ast.addAttribute(IdASTAttr.class, new IdASTAttr(id));

            for (int i = 0; i < ctx.param().size(); i++)
            {
                this.visit(ctx.param(i));
            }

            if (ctx.function_uses_list() != null)
            {
                this.visit(ctx.function_uses_list());
            }

            if (ctx.function_modifies_list() != null)
            {
                this.visit(ctx.function_modifies_list());
            }

            ast.addAttribute(ParamASTAttr.class, paramAttr);

            for (int i = 0; i < ctx.req_expression().size(); i++)
            {
                this.visit(ctx.req_expression(i));
            }

            for (int i = 0; i < ctx.ens_expression().size(); i++)
            {
                this.visit(ctx.ens_expression(i));
            }

            ast.addChild(AlkParseTreeVisitor.this.visit(ctx.statement_sequence()));
            return ast;
        }

        @Override
        public AST visitParamDefinition(AlkParser.ParamDefinitionContext ctx)
        {
            boolean isOut = ctx.OUT() != null;
            String id = ctx.ID().getText();
            paramAttr.addParameter(new Parameter(id, isOut ? ParamType.OUTPUT : ParamType.INPUT, null));
            return ast;
        }

        @Override
        public AST visitReqExpression(AlkParser.ReqExpressionContext ctx)
        {
            AST req = exprVisitor.visit(ctx.expression());
            ast.addRequires(req);
            return null;
        }

        @Override
        public AST visitTypeAssertReq(AlkParser.TypeAssertReqContext ctx)
        {
            for (int i = 0; i < ctx.declarator().size(); i++)
            {
                DeclAST decl = (DeclAST) this.visit(ctx.declarator(i));
                String id = decl.getAttribute(IdASTAttr.class).getId();
                DataTypeAST dataType = (DataTypeAST) decl.getChild(0);
                for (int j = 0; j < paramAttr.getParamCount(); j++)
                {
                    Parameter param = paramAttr.getParameter(j);
                    if (param.getName().equals(id))
                    {
                        param.setDataType(dataType);
                    }
                }
            }

            return null;
        }

        @Override
        public AST visitEnsExpression(AlkParser.EnsExpressionContext ctx)
        {
            AST ens = exprVisitor.visit(ctx.expression());
            ast.addEnsures(ens);
            return null;
        }

        @Override
        public AST visitTypeAssertEns(AlkParser.TypeAssertEnsContext ctx)
        {
            DataTypeAST dataTypeAST = (DataTypeAST) exprVisitor.visit(ctx.dataType());
            ast.setDataType(dataTypeAST);
            return null;
        }

        @Override
        public AST visitFunctionUsesList(AlkParser.FunctionUsesListContext ctx)
        {
            ctx.ID().forEach((id) -> paramAttr.addParameter(new Parameter(id.getText(), ParamType.USES)));
            return null;
        }

        @Override
        public AST visitFunctionModifiesList(AlkParser.FunctionModifiesListContext ctx)
        {
            ctx.ID().forEach((id) -> paramAttr.addParameter(new Parameter(id.getText(), ParamType.MODIFIES)));
            return null;
        }
    }

    private class WhileVisitor
    extends AlkBaseVisitor<AST>
    {
        private final ParamASTAttr paramAttr = new ParamASTAttr();

        @Override
        public AST visitWhileStructure(AlkParser.WhileStructureContext ctx)
        {
            return buildWhile(new ParseRuleContextAdapter(ctx),
                              exprVisitor.visit(ctx.expression()),
                              ctx.while_anno(),
                              AlkParseTreeVisitor.this.visit(ctx.statement()),
                              ctx.loop_assert());
        }

        @Override
        public AST visitForStructure(AlkParser.ForStructureContext ctx)
        {
            ASTContext adapter = new ParseRuleContextAdapter(ctx);
            AST innerAST = new StmtSeqAST(adapter);
            AST incAST = new ExprStmtAST(adapter, exprVisitor.visit(ctx.expression(2)));
            innerAST.addChild(AlkParseTreeVisitor.this.visit(ctx.statement()));
            innerAST.addChild(incAST);

            AST whileAst = buildWhile(adapter,
                                      exprVisitor.visit(ctx.expression(1)),
                                      ctx.while_anno(),
                                      innerAST,
                                      ctx.loop_assert());

            AST fullAST = new StmtSeqAST(adapter);
            AST initAST = new ExprStmtAST(adapter, exprVisitor.visit(ctx.expression(0)));
            fullAST.addChild(initAST);
            fullAST.addChild(whileAst);

            return fullAST;
        }

        @Override
        public AST visitDoWhileStructure(AlkParser.DoWhileStructureContext ctx)
        {
            ASTContext adapter = new ParseRuleContextAdapter(ctx);
            AST whileAst = buildWhile(adapter,
                                      exprVisitor.visit(ctx.expression()),
                                      ctx.while_anno(),
                                      AlkParseTreeVisitor.this.visit(ctx.statement()),
                                      ctx.loop_assert());

            AST fullAST = new StmtSeqAST(adapter);
            fullAST.addChild(AlkParseTreeVisitor.this.visit(ctx.statement()));
            fullAST.addChild(whileAst);

            return fullAST;
        }

        @Override
        public AST visitRepeatStructure(AlkParser.RepeatStructureContext ctx)
        {
            ASTContext adapter = new ParseRuleContextAdapter(ctx);
            AST whileAst = buildWhile(adapter,
                                      UnaryAST.createUnary(Operator.NOT, exprVisitor.visit(ctx.expression())),
                                      ctx.while_anno(),
                                      AlkParseTreeVisitor.this.visit(ctx.statement()),
                                      ctx.loop_assert());

            AST fullAST = new StmtSeqAST(adapter);
            fullAST.addChild(AlkParseTreeVisitor.this.visit(ctx.statement()));
            fullAST.addChild(whileAst);

            return fullAST;
        }

        @Override
        public AST visitLoopAssertAnno(AlkParser.LoopAssertAnnoContext ctx)
        {
            AST ast = new LoopAssertAST(new ParseRuleContextAdapter(ctx));
            ast.addChild(exprVisitor.visit(ctx.expression()));
            return ast;
        }

        @Override
        public AST visitInvariantAnno(AlkParser.InvariantAnnoContext ctx)
        {
            return exprVisitor.visit(ctx.expression());
        }

        @Override
        public AST visitModifiesAnno(AlkParser.ModifiesAnnoContext ctx)
        {
            for (int i = 0; i < ctx.modif_factor().size(); i++)
            {
                visit(ctx.modif_factor(i));
            }
            return null;
        }

        @Override
        public AST visitIdModif(AlkParser.IdModifContext ctx)
        {
            String mid = ctx.ID().getText();
            paramAttr.addParameter(new Parameter(mid, ParamType.MODIFIES));
            return null;
        }

        @Override
        public AST visitSizeModif(AlkParser.SizeModifContext ctx)
        {
            String mid = ctx.ID().getText();
            Parameter param = new Parameter(mid, ParamType.MODIFIES);
            param.setSizeFlag(true);
            paramAttr.addParameter(param);
            return null;
        }

        private WhileAST buildWhile(ASTContext ctx,
                                    AST condition,
                                    List<AlkParser.While_annoContext> whileAnnos,
                                    AST body,
                                    AlkParser.Loop_assertContext loopAssert)
        {
            WhileAST whileAst = new WhileAST(ctx, loopAssert != null);

            whileAst.addChild(condition);

            for (AlkParser.While_annoContext whileAnno : whileAnnos)
            {
                whileAst.addChild(this.visit(whileAnno));
            }

            if (paramAttr.getParamCount() != 0)
            {
                whileAst.addAttribute(ParamASTAttr.class, paramAttr);
            }

            whileAst.addChild(body);

            if (loopAssert != null)
            {
                whileAst.addChild(this.visit(loopAssert));
            }

            return whileAst;
        }
    }
}
