package execution.helpers;

import ast.AST;

import java.util.IdentityHashMap;
import java.util.Map;

public class AnnoHelper
{
    private final Map<AST, Integer> counter = new IdentityHashMap<>();

    public void count(AST ast)
    {
        counter.put(ast, counter.getOrDefault(ast, 0) + 1);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<AST, Integer> entry : counter.entrySet())
        {
            sb.append("@Count(").append(entry.getKey()).append(") -> ").append(entry.getValue()).append('\n');
        }
        return sb.toString();
    }
}
