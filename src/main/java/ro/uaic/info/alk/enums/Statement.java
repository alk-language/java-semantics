package ro.uaic.info.alk.enums;

public enum Statement
{
    ASSUME("@assume"),
    ASSERT("@assert");

    private final String syntax;

    Statement(String syntax)
    {
        this.syntax = syntax;
    }

    public String getSyntax()
    {
        return syntax;
    }
}
