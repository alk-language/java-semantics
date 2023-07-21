package ro.uaic.info.alk.ast;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor<T>
{
    private final List<VisitorTrigger<T>> pre = new ArrayList<>();
    private final List<VisitorTrigger<T>> post = new ArrayList<>();
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

        for (VisitorTrigger<T> trigger : pre)
        {
            if (trigger.identifier.accept(root))
            {
                trigger.code.run(root, payload);
            }
        }
        for (int i = 0; i < root.getChildCount(); i++)
        {
            visit(root.getChild(i));
        }
        for (VisitorTrigger<T> trigger : post)
        {
            if (trigger.identifier.accept(root))
            {
                trigger.code.run(root, payload);
            }
        }
    }

    public void registerPre(ASTIdentifier identifier, VisitorListener<T> code)
    {
        pre.add(new VisitorTrigger<>(identifier, code));
    }

    public void registerPost(ASTIdentifier identifier, VisitorListener<T> code)
    {
        post.add(new VisitorTrigger<>(identifier, code));
    }

    private static class VisitorTrigger<T>
    {
        ASTIdentifier identifier;
        VisitorListener<T> code;

        VisitorTrigger(ASTIdentifier identifier, VisitorListener<T> code)
        {
            this.identifier = identifier;
            this.code = code;
        }
    }


}
