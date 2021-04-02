package dataflow.worklist;

import dataflow.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorklistFlow<T extends Domain>
extends Dataflow<T>
{
    Worklist worklist;
    Map<CFGNode, T> mapping;

    public WorklistFlow(Lattice<T> lattice, CFG cfg, Iota<T> iota, TransferFunction<T> fun)
    {
        super(lattice, cfg, iota, fun);

        worklist = new Worklist();
        mapping = new HashMap<>();
    }

    @Override
    public void execute()
    {
        worklist.addAll(cfg.getEdges());
        cfg.getNodes().forEach((node) -> mapping.put(node, lattice.getBottom()));
        mapping.put(cfg.getInput(), iota.get());

        while (!worklist.isEmpty())
        {
            CFGEdge head = worklist.pollFirst();
            CFGNode from = head.getInput();
            CFGNode to = head.getOutput();
            T fromValue = fun.get(head, mapping.get(from));
            if (!lattice.compare(fromValue, mapping.get(to)))
            {
                Set<T> set = new HashSet<>();
                set.add(mapping.get(to));
                set.add(fromValue);
                mapping.put(to, lattice.getLUB(set));

                to.getOutputs().forEach((edge) -> {
                    if (!worklist.contains(edge))
                    {
                        worklist.add(edge);
                    }
                });
            }
        }
    }

    @Override
    public Map<CFGNode, T> getMapping()
    {
        return mapping;
    }
}
