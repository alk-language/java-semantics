package impl.constants;

import java.util.HashMap;
import java.util.HashSet;

public class Constants {
    public final static int MAX_DECIMALS = 100;
    public final static int MAX_ARRAY = 1000000000;
    public final static boolean DEBUG = false;

    public final static HashSet builtin_methods_name = new HashSet() { // TODO de transformat in set
        {
            add("at");
            add("end");
            add("delete");
            add("first");
            add("insert");
            add("popBack");
            add("popFront");
            add("pushBack");
            add("pushFront");
            add("remove");
            add("removeAllEqTo");
            add("removeAt");
            add("size");
            add("topBack");
            add("topFront");
            add("update");
        }
    };
}
