package ro.uaic.info.alk.control;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.dataflow.CFGEdge;
import ro.uaic.info.alk.execution.BaseStatefulInterpreterManager;
import ro.uaic.info.alk.control.parser.*;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.visitor.stateful.StatefulInterpreterManager;

import java.util.*;

public class IntraproceduralCFG
extends ControlFlowGraph
{

    public static IntraproceduralCFG generate(AST root, AlkConfiguration config)
    {
        IntraproceduralCFG cfg = new IntraproceduralCFG();
        CFGStack stack = new CFGStack(config);

        StatefulInterpreterManager<CFGPayload, CFGResult, CFGState> interpreterManager = new BaseStatefulInterpreterManager<>(
                                                                                         new CFGExprInterpreter(),
                                                                                         new CFGStmtInterpreter());
        Edge initialEdge = new Edge(cfg.getInput(), null, null);
        cfg.getInput().appendOutput(initialEdge);
        CFGState state = interpreterManager.interpret(root, new CFGPayload(initialEdge, interpreterManager));
        stack.push(state);
        stack.run();
        List<CFGEdge> allEdges = cfg.getEdges();
        for (CFGEdge edge : allEdges)
        {
            if (edge.getOutput() == null)
            {
                ((Edge) edge).setOutput(cfg.output);
                cfg.output.appendInput((Edge) edge);
            }
        }

        return cfg;
    }


    IntraproceduralCFG()
    {

    }

    @Override
    public String graphData()
    {
        List<String> nodes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.addLast(getInput());
        visited.add(getInput());
        while (!queue.isEmpty())
        {
            Node first = queue.pollFirst();
            nodes.add(first.toString());
            for (Edge edge : first.getPlainOutputs())
            {
                edges.add(edge);
                Node output = (Node) edge.getOutput();

                if (visited.contains(output))
                    continue;
                queue.addLast(output);
                visited.add(output);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String node : nodes)
        {
            sb.append("\"").append(node).append("\"").append('\n');
        }
        for (Edge edge : edges)
        {
            sb.append("\"").append(edge.getInput().toString()).append("\" \"").append(edge.getOutput().toString()).append("\" ");
            if (edge.getEdgeData() != null)
            {
                sb.append(edge.getEdgeData().toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
