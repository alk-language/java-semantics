package impl.constants;

import java.util.HashMap;

public class Constants {
    public final static int MAX_DECIMALS = 20;
    public final static boolean DEBUG = true;

    public final static HashMap param_number = new HashMap() {
        {
            put("at", 1);
            put("end", 0);
            put("delete", 0);
            put("first", 0);
            put("insert", 2);
            put("popBack", 0);
            put("popFront", 0);
            put("pushBack", 1);
            put("pushFront", 1);
            //put("remove", 2); TODO de inteles ce face functia
            put("removeAllEqTo", 1);
            put("removeAt", 1);
            put("size", 0);
            put("topBack", 0);
            put("topFront", 0);
            put("update", 2);
        }
    };
}
