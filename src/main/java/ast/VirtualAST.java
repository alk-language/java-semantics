package ast;

import java.util.HashMap;
import java.util.Map;

public class VirtualAST
extends AST
{
    private static int astId = 0;
    private static final Map<AST, Integer> astIdMapping = new HashMap<>();

    public static int getASTId(AST tree)
    {
        if (astIdMapping.get(tree) == null)
        {
            astIdMapping.put(tree, astId++);
        }
        return astIdMapping.get(tree);
    }

    public static String getMappingAsString()
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<AST, Integer> entry : astIdMapping.entrySet())
        {
            sb.append("line ").append(entry.getKey().ctx.getStart().getLine()).append(" ");
            sb.append(entry.getKey().getText()).append(" -> l_").append(entry.getValue()).append('\n');
        }
        return sb.toString();
    }

    public static boolean hasLoop(AST tree)
    {
        return astIdMapping.containsKey(tree);
    }

    String id;
    boolean omega;
    AST tree;

    public VirtualAST(String id, AST tree, boolean omega)
    {
        super(null);
        this.id = id;
        this.tree = tree;
        this.omega = omega;
    }

    @Override
    public String toString()
    {
        return id + "_l" + getASTId(tree) + "(" + (omega ? "w" : "t") + "_l" + getASTId(tree) + ")";
    }
}