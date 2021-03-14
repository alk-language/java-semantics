package execution;

import execution.parser.exceptions.AlkSyntaxException;
import grammar.alkParser;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;
import org.antlr.v4.runtime.tree.ParseTree;
import execution.parser.AlkParser;
import execution.parser.exceptions.AlkException;
import util.exception.InternalException;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * Helper for AST manipulation prior to visiting.
 */
public class PreProcessing
{

    public static void expandIncludes(PreProcessingContext context, ParseTree tree)
    {
        for (int i = 0; i < tree.getChildCount(); i++)
        {
            ParseTree child = tree.getChild(i);
            if (child instanceof alkParser.ToDirectiveContext && child.getChild(0) instanceof alkParser.IncludeContext)
            {
                String path = getPath(context, child.getChild(0));

                if (context.isLoaded(path))
                    throw new AlkException("Include cycle detected.");

                context.load(path);
                try {
                    replaceInclude(context, tree, i, path);
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

    private static String getPath(PreProcessingContext context, ParseTree include)
    {
        alkParser.IncludeContext includeCtx = (alkParser.IncludeContext) include;
        String path = includeCtx.STRING().getText();
        path = path.substring(1, path.length() - 1);
        File file = new File(path);
        if (file.isAbsolute())
        {
            return file.getAbsolutePath();
        }
        else
        {
            String top = context.peek();
            String nativeDir = top.substring(0, top.lastIndexOf(File.separator));
            return Paths.get(nativeDir, path).toString();
        }
    }

    private static void replaceInclude(PreProcessingContext context, ParseTree stmtseq, int idx, String path)
    {
        if (!(stmtseq instanceof alkParser.StatementSeqContext))
            throw new InternalException("Preprocessing failed due to unrecognized include directive wrapped");

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
        if (tree == null)
        {
            throw new AlkSyntaxException("Syntax error in: " + path);
        }
        ParseTree stmtseq = tree.getChild(0);

        List<alkParser.StatementContext> children = new ArrayList<>();
        int childCount = stmtseq.getChildCount();
        for (int i=0; i<childCount; i++)
        {
            children.add((alkParser.StatementContext) stmtseq.getChild(i));
        }
        return children;
    }

    public static PreProcessingContext newContext(String path) {
        return new PreProcessingContext(path);
    }

    public static class PreProcessingContext {
        private Stack<String> loaded = new Stack<>();

        PreProcessingContext(String path) {
            load(path);
        }

        public String peek()
        {
            return loaded.peek();
        }

        public boolean isLoaded(String path)
        {
            File file = new File(path);
            return loaded.contains(file.getAbsolutePath());
        }

        public void load(String path)
        {
            File file = new File(path);
            loaded.add(file.getAbsolutePath());
        }

        public void unload(String path)
        {
            File file = new File(path);
            loaded.remove(file.getAbsolutePath());
        }
    }
}
