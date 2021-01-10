package execution.parser.env;

import org.antlr.v4.runtime.tree.ParseTree;
import execution.exhaustive.SplitMapper;
import util.exception.InternalException;
import util.functions.Parameter;

import java.util.ArrayList;
import java.util.List;

public class AlkFunction {

    String name;
    List<Parameter> params;
    List<String> modifies;
    ParseTree tree;

    public AlkFunction(String name, List<Parameter> params, List<String> modifies, ParseTree tree) {
        this.name = name;
        this.params = params;
        this.modifies = modifies;
        this.tree = tree;
    }

    public String getName() {
        return name;
    }

    public Parameter getParam(int idx) {
        if (idx < 0 || idx >= params.size())
            throw new InternalException("Can't retrieve specified parameter");
        return params.get(idx);
    }

    public int countParams() {
        return params.size();
    }

    public ParseTree getBody() {
        return tree;
    }

    public int countModifies() {
        return modifies.size();
    }

    public String getModify(int i) {
        return modifies.get(i);
    }

    public AlkFunction clone(SplitMapper sm) {
        List<Parameter> newParams = new ArrayList<>(params);
        List<String> newModifies = new ArrayList<>(modifies);
        return new AlkFunction(this.name, newParams, newModifies, tree);
    }
}