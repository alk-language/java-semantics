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

public class PreProcessing {

    HashSet<String> loaded = new HashSet<>();

    public void exapandIncludes(ParseTree tree) {

        int childCount = tree.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            ParseTree child = tree.getChild(i);
            if (child instanceof alkParser.ToDirectiveContext && child.getChild(0) instanceof alkParser.IncludeContext)
            {
                String path = getPath(child.getChild(0));

                if (loaded.contains(path))
                    throw new AlkException("Include cycle detected.");

                loaded.add(path);
                try {
                    replaceInclude(tree, i);
                    childCount = tree.getChildCount();
                    child = tree.getChild(i);
                    exapandIncludes(child);
                }
                finally {
                    loaded.remove(path);
                }

            }
            else
            {
                exapandIncludes(child);
            }
        }
    }

    private String getPath(ParseTree include)
    {
        alkParser.IncludeContext includeCtx = (alkParser.IncludeContext) include;
        String path = includeCtx.STRING().getText();
        return path.substring(1, path.length() - 1);
    }

    private void replaceInclude(ParseTree stmtseq, int idx)
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

        List<alkParser.StatementContext> stmts = getStmts(path);
        for (alkParser.StatementContext stmt : stmts)
        {
            ctx.addChild(stmt);
        }

        for(alkParser.StatementContext back : backup)
        {
            ctx.addChild(back);
        }
    }

    private List<alkParser.StatementContext> getStmts(String path)
    {
        File file = new File(path);
        try {
            InputStream alkInStr = new FileInputStream(file);
            CharStream alkFile = CharStreams.fromStream(alkInStr);
            AlkParser parser = new AlkParser(alkFile);
            ParseTree tree = parser.execute(this);
            ParseTree stmtseq = tree.getChild(0);

            List<alkParser.StatementContext> children = new ArrayList<>();
            int childCount = stmtseq.getChildCount();
            for (int i=0; i<childCount; i++)
            {
                children.add((alkParser.StatementContext) stmtseq.getChild(i));
            }
            return children;
        } catch (IOException e) {
            throw new AlkException("Can't find requested file.");
        }
    }
}
