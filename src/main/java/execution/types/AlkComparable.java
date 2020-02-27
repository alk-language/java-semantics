package execution.types;

import execution.types.alkBool.AlkBool;

public interface AlkComparable<T>
{
    AlkBool equal(T operand);
    AlkBool lower(T operand);
}
