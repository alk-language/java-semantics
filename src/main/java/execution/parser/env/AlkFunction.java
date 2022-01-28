package execution.parser.env;

import ast.AST;
import ast.type.DataTypeAST;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.functions.Parameter;

import java.util.ArrayList;
import java.util.List;

public class AlkFunction
{
    private final String name;
    private final List<Parameter> params;
    private final List<String> modifies;
    private final AST tree;
    private final List<AST> reqs;
    private final List<AST> ens;
    private final DataTypeAST dataType;

    public AlkFunction(String name,
                       List<Parameter> params,
                       List<String> modifies,
                       AST tree,
                       List<AST> reqs,
                       List<AST> ens,
                       DataTypeAST dataType)
    {
        this.name = name;
        this.params = params;
        this.modifies = modifies;
        this.tree = tree;
        this.reqs = reqs;
        this.ens = ens;
        this.dataType = dataType;
    }

    public List<AST> getRequires()
    {
        return reqs;
    }

    public List<AST> getEnsures()
    {
        return ens;
    }

    public String getName()
    {
        return name;
    }

    public Parameter getParam(int idx)
    {
        if (idx < 0 || idx >= params.size())
        {
            throw new InternalException("Can't retrieve specified parameter");
        }
        return params.get(idx);
    }

    public List<Parameter> getParams()
    {
        return params;
    }

    public int countParams()
    {
        return params.size();
    }

    public AST getBody()
    {
        return tree;
    }

    public int countModifies()
    {
        return modifies.size();
    }

    public String getModify(int i)
    {
        return modifies.get(i);
    }

    public AlkFunction clone(SplitMapper sm)
    {
        List<Parameter> newParams = new ArrayList<>(params);
        List<String> newModifies = new ArrayList<>(modifies);
        List<AST> newReqs = new ArrayList<>(reqs);
        List<AST> newEns = new ArrayList<>(ens);
        return new AlkFunction(this.name, newParams, newModifies, tree, newReqs, newEns, dataType);
    }

    public DataTypeAST getDataType()
    {
        return dataType;
    }
}
