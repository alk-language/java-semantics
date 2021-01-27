package control.parser.states;

import ast.AST;
import ast.State;
import control.ControlFlowGraph;
import control.parser.CFGPayload;
import control.parser.CFGResult;
import control.parser.CFGState;
import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import util.exception.InternalException;

import java.util.List;

public class StatementSeqState extends CFGState
{
    private final List<AST> dependencies;
    private List<ControlFlowGraph.Node> currentTerminals;
    private int step = 0;

    public StatementSeqState(AST tree,
                             List<AST> dependencies,
                             CFGPayload payload)
    {
        super(tree, payload);
        this.dependencies = dependencies;
        this.currentTerminals = payload.getInputs();
    }

    @Override
    public State<CFGPayload, CFGResult> makeStep()
    {
        if (step == dependencies.size())
        {
            setResult(new CFGResult(this.currentTerminals));
            return null;
        }

        return request(dependencies.get(step++), new CFGPayload(currentTerminals));
    }

    @Override
    public void assign(CFGResult result)
    {
        List<ControlFlowGraph.Node> outputs = result.getValue();
        if (outputs == null)
        {
            throw new InternalException("Null is not a valid value for the CFG.Node outputs");
        }
        this.currentTerminals = outputs;
    }
}
