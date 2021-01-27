package ast.attr;

import ast.enums.ParamType;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ParamASTAttr
extends ASTAttr
{
    private final List<Pair<ParamType, String>> params = new ArrayList<>();

    public void addParameter(ParamType type, String id)
    {
        params.add(new Pair<>(type, id));
    }

    public int getParamCount()
    {
        return params.size();
    }

    public Pair<ParamType, String> getParameter(int idx)
    {
        return params.get(idx);
    }
}
