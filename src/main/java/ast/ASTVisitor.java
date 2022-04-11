package ast;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor<T>
{
    private final List<VisitorListenerKey<T>> pre = new ArrayList<>();
    private final List<VisitorListenerKey<T>> post = new ArrayList<>();
    private final T payload;

    public ASTVisitor(T payload)
    {
        this.payload = payload;
    }

    public void visit(AST root)
    {
        if (root == null)
        {
            return;
        }
        for (VisitorListenerKey<T> key : pre)
        {
            if (key.identifier.accept(root))
            {
                key.code.run(root, payload);
            }
        }
        for (int i = 0; i < root.getChildCount(); i++)
        {
            visit(root.getChild(i));
        }
        for (VisitorListenerKey<T> key : post)
        {
            if (key.identifier.accept(root))
            {
                key.code.run(root, payload);
            }
        }
    }

    public void registerPre(Identifier identifier, VisitorListener<T> code)
    {
        pre.add(new VisitorListenerKey<>(identifier, code));
    }

    void registerPost(Identifier identifier, VisitorListener<T> code)
    {
        post.add(new VisitorListenerKey<>(identifier, code));
    }

    static class VisitorListenerKey<T>
    {
        Identifier identifier;
        VisitorListener<T> code;

        VisitorListenerKey(Identifier identifier, VisitorListener<T> code)
        {
            this.identifier = identifier;
            this.code = code;
        }
    }


}
