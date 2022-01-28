package ast;

public interface VisitorListener<T>
{
    void run(AST ast, T payload);
}
