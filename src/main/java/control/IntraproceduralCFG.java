package control;

import ast.AST;
import control.parser.*;
import dataflow.CFGNode;
import execution.BaseStatefulInterpreterManager;
import execution.state.ExecutionState;
import parser.ParseTreeGlobals;
import util.Pair;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import util.Configuration;
import util.exception.InternalException;
import visitor.stateful.StatefulInterpreterManager;

import java.util.*;

public class IntraproceduralCFG
extends ControlFlowGraph
{

    public static IntraproceduralCFG generate(ParseTree tree, Configuration config)
    {
        if (!(tree instanceof alkParser.StartPointContext))
        {
            throw new InternalException("The entry-point for intra-procedural CFG generation is invalid");
        }

        IntraproceduralCFG cfg = new IntraproceduralCFG();
        CFGStack stack = new CFGStack(config);
        AST root = ParseTreeGlobals.PARSE_TREE_VISITOR.visit(tree);

        StatefulInterpreterManager<CFGPayload, CFGResult, CFGState> interpreterManager = new BaseStatefulInterpreterManager<>(
                                                                                         new CFGExprInterpreter(),
                                                                                         new CFGStmtInterpreter());
        CFGState state = interpreterManager.interpret(root, new CFGPayload(cfg.getInput(), interpreterManager));
        stack.push(state);
        stack.run();
        List<CFGNode> lasts = cfg.getNodes();
        for (CFGNode node : lasts)
        {
            if (node.getOutputs().size() == 0)
            {
                ((Node) node).appendOutput(cfg.output);
                cfg.output.appendInput((Node) node);
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
