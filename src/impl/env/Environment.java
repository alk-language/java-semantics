package impl.env;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Environment {

    private HashMap<String, Object> variables = new HashMap<>();

    public Object get(String str)
    {
        return variables.get(str);
    }

    public boolean put(String id, Object value) // pentru variabile
    {
        variables.put(id, value);
        return true;
    }

    public Integer put(String id, ArrayList indexes, Object value) // pentru liste, eventual multiple
    {
        ArrayList ar = (ArrayList)variables.get(id);
        for (int i=indexes.size()-1; i>=1; i--)
            ar = (ArrayList)ar.get((Integer)indexes.get(i));
        ar.set((Integer)indexes.get(0), value);
        return 1;
    }

    public Object get(String id, Object index) // pentru liste
    {
        Object ar = variables.get(id);
        return ((ArrayList)ar).get(((BigDecimal)index).intValue());
    }
}
