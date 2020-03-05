package util.functions;

import execution.types.AlkValue;

public @interface Parameter {

    Class<? extends AlkValue> type();

}
