package ro.uaic.info.alk.ast;

import ro.uaic.info.alk.ast.attr.ASTAttr;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.ifaces.Visitable;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AST
implements Visitable
{
    protected final ASTContext ctx;
    protected final List<AST> children = new ArrayList<>();
    protected final Map<Class<? extends ASTAttr>, ASTAttr> attrs = new HashMap<>();
    protected String text;

    public AST(ASTContext ctx)
    {
        this.ctx = ctx;
    }

    public Map<Class<? extends ASTAttr>, ASTAttr> getAttrs()
    {
        return new HashMap<>(attrs);
    }

    public void addChild(AST child)
    {
        children.add(child);
    }

    public void addChild(int pos, AST stmt)
    {
        children.add(pos, stmt);
    }

    public void deleteChild(int i)
    {
        this.children.remove(i);
    }

    public AST getChild(int idx)
    {
        return children.get(idx);
    }

    public List<AST> getChildren()
    {
        // TODO: not safe
        return children;
    }

    public int getChildCount()
    {
        return children.size();
    }

    public boolean hasAttribute(Class<?> clazz)
    {
        return attrs.containsKey(clazz);
    }

    public <T extends ASTAttr> void addAttribute(Class<T> attrClazz, T attr)
    {
        attrs.put(attrClazz, attr);
    }

    public <T> T getAttribute(Class<T> clazz)
    {
        if (!attrs.containsKey(clazz))
        {
            throw new InternalException("Can't find the required AST attribute.");
        }
        return (T) attrs.get(clazz);
    }

    public void overrideAttrs(Map<Class<? extends ASTAttr>, ASTAttr> attrs)
    {
        this.attrs.clear();
        this.attrs.putAll(attrs);
    }

    public String getText()
    {
        if (text != null)
        {
            return text;
        }

        if (ctx == null || ctx.getText() == null)
        {
            // TODO maybe replace with toString
            return null;
        }

        return ctx.getText();
    }

    public Integer getLine()
    {
        return ctx == null ? null : ctx.getLine();
    }

    public Integer getColumn()
    {
        return ctx == null ? null : ctx.getCol();
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        throw new InternalException("Can't visit with unspecialized visitor or an unspecialized state!" +
           "Using " + visitor.getClass() + " visitor with " + this.getClass() + ".");
    }

    public ASTContext getCtx()
    {
        // TODO: not good
        return ctx;
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
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof AST))
        {
            return false;
        }

        // TODO: improve equals to analyze in-depth
        return this.toString().equals(o.toString());
    }

    @Override
    public abstract String toString();
}
