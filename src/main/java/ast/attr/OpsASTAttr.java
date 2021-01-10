package ast.attr;

import visitor.Operator;

import java.util.ArrayList;
import java.util.List;

public class OpsASTAttr
extends ASTAttr
{
    private final List<Operator> ops = new ArrayList<>();

    public void add(Operator op)
    {
        ops.add(op);
    }

    public Operator getOp(int idx)
    {
        return ops.get(idx);
    }

    public int getOpCount()
    {
        return ops.size();
    }
}
