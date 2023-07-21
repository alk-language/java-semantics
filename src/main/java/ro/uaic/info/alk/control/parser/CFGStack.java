package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.execution.StatefulStack;
import ro.uaic.info.alk.util.AlkConfiguration;

public class CFGStack
extends StatefulStack<CFGState, CFGResult>
{
    public CFGStack(AlkConfiguration config)
    {
        super(config);
    }
}
