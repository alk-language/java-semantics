package ast;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor<T>
{
    private final List<VisitorListenerKey<T>> listeners = new ArrayList<>();
    private final T payload;

    public ASTVisitor(T payload)
    {
        this.payload = payload;
    }

    void visit(AST root)
    {
        if (root == null)
        {
            return;
        }
        for (VisitorListenerKey<T> key : listeners)
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
    }

    void register(Identifier identifier, VisitorListener<T> code)
    {
        listeners.add(new VisitorListenerKey<>(identifier, code));
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
