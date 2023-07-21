package ro.uaic.info.alk.ast;

public interface VisitorListener<T>
{
    void run(AST ast, T payload);
}
