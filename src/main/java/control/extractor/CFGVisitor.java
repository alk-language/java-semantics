package control.extractor;

import ast.AST;
import dataflow.CFG;
import dataflow.CFGNode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;
import java.util.function.Supplier;

public class CFGVisitor
{

    Map<Class<? extends ParseTree>, List<Extractor>> extractors = new IdentityHashMap<>();

    public void extract(CFG cfg)
    {
        Deque<CFGNode> queue = new ArrayDeque<>();
        Set<CFGNode> visited = new HashSet<>();

        queue.addLast(cfg.getInput());
        visited.add(cfg.getInput());
        while (!queue.isEmpty())
        {
            CFGNode first = queue.pollFirst();

            AST tree = first.getTree();
            if (tree != null)
            {
                List<Extractor> tmp = extractors.getOrDefault(tree.getClass(), new ArrayList<>());
                tmp.addAll(extractors.get(null));
                for (Extractor extractor : tmp)
                {
                    extractor.execute(tree);
                }
            }

            for (CFGNode output : first.getOutputs())
            {
                if (visited.contains(output))
                    continue;
                queue.addLast(output);
                visited.add(output);
            }
        }
    }

    public void register(Class<? extends ParseTree> clazz, Extractor extractor)
    {
        extractors.computeIfAbsent(clazz, k -> new ArrayList<>()).add(extractor);
    }
}
