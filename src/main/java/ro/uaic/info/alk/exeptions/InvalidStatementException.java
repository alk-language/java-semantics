package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.enums.Statement;

public class InvalidStatementException
extends AlkException
{
    public InvalidStatementException(Statement stmt, AlkException cause)
    {
        super("Invalid statement! Can't execute \"" + stmt.getSyntax() + "\" statement!", cause);
    }
}
