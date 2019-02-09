package impl.env;

import grammar.alkParser;
import impl.Pair;
import impl.VisitorBaseImpl;
import impl.exceptions.AlkException;
import impl.types.AlkValue;
import impl.types.alkArray.AlkArray;
import impl.types.alkBool.AlkBool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static impl.exceptions.AlkException.ERR_FUNCTION_REDEFINITION;
import static impl.exceptions.AlkException.ERR_FUNCTION_UNDEFINED;

public class AlkFunction {
    private static TreeMap<Pair<String, Integer>, AlkFunction> functions = new TreeMap<>(); // nume si nr argumente -> functie

    private ArrayList<Pair<String, Boolean>> params;
    private ArrayList<String> modifies;
    private alkParser.Statement_blockContext stmt;


    public AlkFunction(String name, ArrayList<Pair<String, Boolean>> params, ArrayList<String> modifies, alkParser.Statement_blockContext stmt) throws AlkException {
        this.params = params;
        this.modifies = modifies;
        this.stmt = stmt;
        if (functions.containsKey(new Pair<>(name, params.size())) )
            throw new AlkException(ERR_FUNCTION_REDEFINITION);
        functions.put(new Pair<>(name, params.size()), this);
    }

    public static AlkFunction get(String name, int nr_params) throws AlkException {
        if (functions.containsKey(new Pair<>(name, nr_params)))
            return functions.get(new Pair<>(name, nr_params));
        throw new AlkException(ERR_FUNCTION_UNDEFINED);
    }

    public AlkValue call(ArrayList<AlkValue> params)
    {
        // de pus parametrii
        VisitorBaseImpl visitor = new VisitorBaseImpl();
        visitor.visit(stmt);
        return new AlkBool(false);
    }
}
