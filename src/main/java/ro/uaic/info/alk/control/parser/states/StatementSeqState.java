package ro.uaic.info.alk.control.parser.states;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.control.Edge;
import ro.uaic.info.alk.control.parser.CFGPayload;
import ro.uaic.info.alk.control.parser.CFGResult;
import ro.uaic.info.alk.control.parser.CFGState;
import ro.uaic.info.alk.state.State;
import ro.uaic.info.alk.exeptions.InternalException;

import java.util.List;

public class StatementSeqState
   extends CFGState
{
    private List<Edge> currentTerminals;
    private int step = 0;

    public StatementSeqState(AST tree, CFGPayload payload)
    {
        super(tree, payload);
        this.currentTerminals = payload.getInputs();
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (step == tree.getChildCount())
        {
            setResult(new CFGResult(this.currentTerminals));
            return null;
        }

        return request(tree.getChild(step++), new CFGPayload(currentTerminals, payload.getInterpreterManager()));
    }

    @Override
    public void assign(CFGResult result)
    {
        List<Edge> outputs = result.getValue();
        if (outputs == null)
        {
            throw new InternalException("Null is not a valid value for the CFG.Node outputs");
        }
        this.currentTerminals = outputs;
    }
}
