package ro.uaic.info.alk.control.parser;

import ro.uaic.info.alk.state.State;

public class CFGProxyState extends CFGState
{
    State<CFGPayload, CFGResult> target;

    public CFGProxyState(State<CFGPayload, CFGResult> target)
    {
        super(target.getTree(), target.getPayload());
        this.target = target;
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        setResult(target.getResult());
        return target.makeStep();
    }

    @Override
    public void assign(CFGResult result)
    {
        target.assign(result);
    }
}
