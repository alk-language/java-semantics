package ast.stmt;

import ast.AST;
import ast.attr.*;
import ast.type.DataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ifaces.VisitorIface;
import visitor.ifaces.stmt.FunctionDeclVisitorIface;

import java.util.ArrayList;
import java.util.List;

public class FunctionDeclAST
extends StmtAST
{
    private final List<AST> requires = new ArrayList<>();
    private final List<AST> ensures = new ArrayList<>();
    private AST dataType;

    public FunctionDeclAST(ParserRuleContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FunctionDeclVisitorIface)
            return ((FunctionDeclVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    @Override
    public String toString()
    {
        return getAttribute(IdASTAttr.class).getId() + "(...) {\n" + getChild(0) + "}";
    }

    public List<AST> getRequires()
    {
        return requires;
    }

    public void addRequires(AST expr)
    {
        AST body = getBody();
        this.children.remove(body);
        addChild(expr);
        this.children.add(body);
        requires.add(expr);
    }

    public void addEnsures(AST expr)
    {
        AST body = getBody();
        this.children.remove(body);
        addChild(expr);
        this.children.add(body);
        ensures.add(expr);
    }

    public void setDataType(AST dataType)
    {
        addChild(dataType);
        this.dataType = dataType;
    }

    public AST  getBody()
    {
        return getChild(getChildCount() - 1);
    }

    public List<AST> getEnsures()
    {
        return ensures;
    }

    public DataTypeAST getDataType()
    {
        return (DataTypeAST) dataType;
    }
}
