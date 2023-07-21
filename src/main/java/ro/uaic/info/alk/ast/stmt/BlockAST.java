package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.BlockVisitorIface;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BlockAST
extends StmtAST
{
    public BlockAST(ASTContext ctx, AST body)
    {
        super(ctx);
        children.add(body);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof BlockVisitorIface)
            return ((BlockVisitorIface<T>) visitor).visit(this);

        return super.accept(visitor);
    }

    public AST getBody()
    {
        return getChild(0);
    }

    @Override
    public String toString()
    {
        String ls = System.lineSeparator();
        String inner = Arrays.stream(getBody().toString().split(ls))
                             .map((line) -> "   " + line)
                             .collect(Collectors.joining(ls));
        return "{" + ls + inner  + "}" + ls;
    }
}
