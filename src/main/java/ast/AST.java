package ast;

import ast.attr.ASTAttr;
import ast.attr.OpsASTAttr;
import ast.type.ArrayDataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import util.exception.InternalException;
import ast.enums.Operator;
import visitor.ifaces.Visitable;
import visitor.ifaces.VisitorIface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AST
implements Visitable
{
    protected List<AST> children = new ArrayList<>();
    protected Map<Class<? extends ASTAttr>, ASTAttr> attrs = new HashMap<>();
    protected ParserRuleContext ctx;
    protected String text;

    public AST(ParserRuleContext ctx)
    {
        this.ctx = ctx;
    }

    protected static <T extends AST> T addOpsASTAttr(T ast, Operator op)
    {
        OpsASTAttr attr = new OpsASTAttr();
        attr.add(op);
        ast.addAttribute(OpsASTAttr.class, attr);
        return ast;
    }

    protected static String getBinaryOperationString(AST ast)
    {
        StringBuilder sb = new StringBuilder();
        OpsASTAttr attr = ast.getAttribute(OpsASTAttr.class);
        for (int i = 0; i < ast.getChildCount(); i++)
        {
            sb.append(ast.getChild(i).toString());
            if (i < ast.getChildCount() - 1)
                sb.append(OperatorUtils.toString(attr.getOp(i)));
        }
        return "(" + sb.toString() + ")";
    }

    protected static String getCSV(AST ast)
    {
        return getSV(ast, ",");
    }

    protected static String getSV(AST ast, String separator)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ast.getChildCount(); i++)
        {
            sb.append(ast.getChild(i).toString());
            if (i < ast.getChildCount() - 1)
                sb.append(separator);
        }
        return sb.toString();
    }

    public Map<Class<? extends ASTAttr>, ASTAttr> getAttrs()
    {
        return new HashMap<>(attrs);
    }

    public void addChild(AST child)
    {
        children.add(child);
    }

    public <T extends ASTAttr> void addAttribute(Class<T> attrClazz, T attr)
    {
        attrs.put(attrClazz, attr);
    }

    public AST getChild(int idx)
    {
        return children.get(idx);
    }

    public List<AST> getChildren()
    {
        return children;
    }

    public <T> T getAttribute(Class<T> clazz)
    {
        if (!attrs.containsKey(clazz))
        {
            throw new InternalException("Can't find the required AST attribute.");
        }
        return (T) attrs.get(clazz);
    }

    public int getChildCount()
    {
        return children.size();
    }

    public String getText()
    {
        if (text != null)
        {
            return text;
        }

        if (ctx == null || ctx.getText() == null)
        {
            throw new InternalException("Can't get a string representation for this AST");
        }

        return ctx.getText();
    }

    public int getLine()
    {
        return ctx.getStart().getLine();
    }

    public int getColumn()
    {
        return ctx.getStart().getCharPositionInLine();
    }

    @Override
    public abstract String toString();

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        throw new InternalException("Can't visit with unspecialized visitor or an unspecialized state!");
    }

    public boolean hasAttribute(Class<?> clazz)
    {
        return attrs.containsKey(clazz);
    }

    public ParserRuleContext getCtx()
    {
        return ctx;
    }

    public void setAttrs(Map<Class<? extends ASTAttr>, ASTAttr> attrs)
    {
        this.attrs = attrs;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public boolean hasText()
    {
        return text != null || (ctx != null && ctx.getText() != null);
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof AST)) return false;
        return this.toString().equals(o.toString());
    }
}
