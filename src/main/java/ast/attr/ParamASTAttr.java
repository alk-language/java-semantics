package ast.attr;

import util.functions.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ParamASTAttr
extends ASTAttr
{
    private final List<Parameter> params = new ArrayList<>();

    public void addParameter(Parameter param)
    {
        params.add(param);
    }

    public int getParamCount()
    {
        return params.size();
    }

    public Parameter getParameter(int idx)
    {
        return params.get(idx);
    }
}
