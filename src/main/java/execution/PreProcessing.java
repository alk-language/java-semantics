package execution;

import grammar.alkParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.AlkParser;
import parser.exceptions.AlkException;
import util.exception.InternalException;

import java.io.*;
import java.util.*;

/**
 * Helper for AST manipulation prior to visiting.
 */
public class PreProcessing {

    public static void expandIncludes(PreProcessingContext context, ParseTree tree)
    {
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            ParseTree child = tree.getChild(i);
            if (child instanceof alkParser.ToDirectiveContext && child.getChild(0) instanceof alkParser.IncludeContext)
            {
                String path = getPath(child.getChild(0));

                if (context.isLoaded(path))
                    throw new AlkException("Include cycle detected.");

                context.load(path);
                try {
                    replaceInclude(context, tree, i);
                    expandIncludes(context, tree.getChild(i));
                }
                finally {
                    context.unload(path);
                }
            }
            else
            {
                expandIncludes(context, child);
            }
        }
    }

    private static String getPath(ParseTree include)
    {
        alkParser.IncludeContext includeCtx = (alkParser.IncludeContext) include;
        String path = includeCtx.STRING().getText();
        return path.substring(1, path.length() - 1);
    }

    private static void replaceInclude(PreProcessingContext context, ParseTree stmtseq, int idx)
    {
        if (!(stmtseq instanceof alkParser.StatementSeqContext))
            throw new InternalException("Preprocessing failed due to unrecognized include directive wrapped");

        ParseTree include = stmtseq.getChild(idx).getChild(0);
        String path = getPath(include);

        alkParser.StatementSeqContext ctx = (alkParser.StatementSeqContext) stmtseq;

        List<alkParser.StatementContext> backup = new ArrayList<>();
        while (stmtseq.getChildCount() > idx + 1)
        {
            backup.add((alkParser.StatementContext) ctx.getChild(stmtseq.getChildCount() - 1));
            ctx.removeLastChild();
        }
        ctx.removeLastChild();
        Collections.reverse(backup);

        List<alkParser.StatementContext> stmts = getStmts(context, path);
        for (alkParser.StatementContext stmt : stmts)
        {
            ctx.addChild(stmt);
        }

        for(alkParser.StatementContext back : backup)
        {
            ctx.addChild(back);
        }
    }

    private static List<alkParser.StatementContext> getStmts(PreProcessingContext context, String path)
    {
        File file = new File(path);
        ParseTree tree = AlkParser.execute(file, context);
        ParseTree stmtseq = tree.getChild(0);

        List<alkParser.StatementContext> children = new ArrayList<>();
        int childCount = stmtseq.getChildCount();
        for (int i=0; i<childCount; i++)
        {
            children.add((alkParser.StatementContext) stmtseq.getChild(i));
        }
        return children;
    }

    public static PreProcessingContext newContext() {
        return new PreProcessingContext();
    }

    public static class PreProcessingContext {
        private Set<String> loaded = new HashSet<>();

        public boolean isLoaded(String path)
        {
            return loaded.contains(path);
        }

        public void load(String path)
        {
            loaded.add(path);
        }

        public void unload(String path)
        {
            loaded.remove(path);
        }
    }
}
