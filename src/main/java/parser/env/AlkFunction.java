package parser.env;

import grammar.alkParser;
import parser.Pair;
import parser.types.alkNotAValue.AlkNotAValue;
import parser.visitors.MainVisitor;
import parser.visitors.StmtVisitor;
import parser.exceptions.AlkException;
import parser.types.AlkValue;
import parser.types.alkInt.AlkInt;

import java.util.ArrayList;
import java.util.TreeMap;

import static parser.exceptions.AlkException.*;

public class AlkFunction {
    private static TreeMap<Pair<String, Integer>, AlkFunction> functions = new TreeMap<>(); // nume si nr argumente -> functie

    private ArrayList<Pair<String, Boolean>> params;
    private ArrayList<String> modifies;
    private alkParser.Statement_blockContext stmt;

    public static void reset()
    {
        functions.clear();
    }


    public AlkFunction(String name, ArrayList<Pair<String, Boolean>> params, ArrayList<String> modifies, alkParser.Statement_blockContext stmt) throws AlkException {
        this.params = params;
        this.modifies = modifies;
        this.stmt = stmt;
        if (functions.containsKey(new Pair<>(name, params.size())) )
            throw new AlkException(ERR_FUNCTION_REDEFINITION);
        for (int i=0; i<params.size(); i++)
        {
            for (int j=0; j<params.size(); j++)
            {
                if (i==j) continue;
                if (params.get(i).x.equals(params.get(j).x))
                    throw new AlkException(ERR_MULTIPLE_PARAM);
            }
            for (String modify : modifies) {
                if (params.get(i).x.equals(modify))
                    throw new AlkException(ERR_MULTIPLE_PARAM);
            }
        }
        functions.put(new Pair<>(name, params.size()), this);
    }

    public static AlkFunction get(String name, int nr_params) throws AlkException {
        if (functions.containsKey(new Pair<>(name, nr_params)))
            return functions.get(new Pair<>(name, nr_params));
        throw new AlkException(ERR_FUNCTION_UNDEFINED);
    }

    public boolean isOut(int location)
    {
        Pair<String, Boolean> pair = params.get(location);
        return pair.y;
    }


    //daca este vorba de parametrii de intrare-iesire, se va primi un AlkInt cu valoarea locatii in store
    public AlkValue call(ArrayList<AlkValue> params) throws AlkException
    {
        /*
        Environment env = new Environment(new Store());

        for (int i=0; i<params.size(); i++)
        {
            if (isOut(i))
                env.add(this.params.get(i).x, ((AlkInt)params.get(i)).value.intValueExact());
            else
                env.update(this.params.get(i).x, params.get(i));
        }

        Environment globals = MainVisitor.global;
        for (String modify : modifies) {
            if (!globals.has(modify))
                throw new AlkException(ERR_MODIFIES);
            env.add(modify, globals.getLocation(modify));
        }

        MainVisitor.stack.push(env);
        StmtVisitor visitor = new StmtVisitor(env, true);
        visitor.visit(stmt);
        MainVisitor.stack.pop();
        if (visitor.returnValue == null)
            return new AlkNotAValue(AlkNotAValue.NO_RETURN);
        return visitor.returnValue;

        */
        return null;
    }
}
