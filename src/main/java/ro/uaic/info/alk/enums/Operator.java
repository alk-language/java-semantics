package ro.uaic.info.alk.enums;

public enum Operator
{
    IFELSE("?:"),
    LOGICAL_OR("||"),
    LOGICAL_AND("&&"),
    IN("in"),
    EQUAL("=="),
    NOT_EQUAL("!="),
    LOWER("<"),
    LOWER_EQ("<="),
    GREATER(">"),
    GREATER_EQ(">="),
    UNION("U"),
    INTERSECT("^"),
    SET_SUBTRACT("\\"),
    BITWISE_OR("|"),
    BITWISE_AND("&"),
    BITWISE_XOR("^"),
    SHIFT_LEFT("<<"),
    SHIFT_RIGHT(">>"),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%"),
    PLUSPLUSLEFT("++"),
    MINUSMINUSLEFT("--"),
    POSITIVE("+"),
    NEGATIVE("-"),
    NOT("!"),
    PLUSPLUSRIGHT("++"),
    MINUSMINUSRIGHT("--"),
    BRACKET("[]"),
    DOT("."),

    ASSIGN("="),
    PLUS_ASSIGN("+="),
    MINUS_ASSIGN("-="),
    MULTIPLY_ASSIGN("*="),
    DIVIDE_ASSIGN("/="),
    MOD_ASSIGN("%="),
    LEFT_SHIFT_ASSIGN("<<="),
    RIGHT_SHIFT_ASSIGN(">>="),
    BITWISE_OR_ASSIGN("|="),
    BITWISE_AND_ASSIGN("&=");

    private final String syntax;

    Operator(String syntax)
    {
        this.syntax = syntax;
    }

    public String getSyntax()
    {
        return syntax;
    }
}
