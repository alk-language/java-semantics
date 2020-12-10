package control.parser;

import ast.ASTStack;
import util.Configuration;

public class CFGStack extends ASTStack<CFGState>
{
    public CFGStack(Configuration config)
    {
        super(config);
    }
}
