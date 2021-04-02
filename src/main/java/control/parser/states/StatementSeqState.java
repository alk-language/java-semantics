package control.parser.states;

import ast.AST;
import control.Edge;
import state.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import util.exception.InternalException;

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
