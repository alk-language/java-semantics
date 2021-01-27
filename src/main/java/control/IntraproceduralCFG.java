package control;

import control.parser.CFGPayload;
import control.parser.CFGStack;
import control.parser.CFGState;
import util.Pair;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Configuration;
import util.exception.InternalException;

import java.util.*;

public class IntraproceduralCFG
extends ControlFlowGraph
{

    public static IntraproceduralCFG generate(ParseTree root, Configuration config)
    {
        if (!(root instanceof alkParser.StartPointContext))
        {
            throw new InternalException("The entry-point for intra-procedural CFG generation is invalid");
        }

        IntraproceduralCFG cfg = new IntraproceduralCFG();

        CFGStack stack = new CFGStack(config);

        // TODO properly implement

        /*
        CFGState state = visitor.visit(root);
        stack.push(state);
        stack.run();
        for (Node node : visitor.getTerminals())
        {
            node.appendOutput(cfg.output);
            cfg.output.appendInput(node);
        }*/

        return cfg;
    }


    IntraproceduralCFG()
    {

    }

    @Override
    public String graphData()
    {
        List<String> nodes = new ArrayList<>();
        List<Pair<String, String> > edges = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.addLast(getInput());
        visited.add(getInput());
        while (!queue.isEmpty())
        {
            Node first = queue.pollFirst();
            nodes.add(first.toString());
            for (Node output : first.getPlainOutputs())
            {
                edges.add(new Pair<>(first.toString(), output.toString()));

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
        for (Pair<String, String> edge : edges)
        {
            sb.append("\"").append(edge.x).append("\" \"").append(edge.y).append("\"\n");
        }

        return sb.toString();
    }
}
