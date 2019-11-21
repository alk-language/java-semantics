package parser.types;

import parser.types.alkBool.AlkBool;

public interface AlkComparable<T>
{
    AlkBool equal(T operand);
    AlkBool lower(T operand);
}
