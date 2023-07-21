package ro.uaic.info.alk.preproc;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.stmt.IncludeAST;
import ro.uaic.info.alk.ast.stmt.StmtSeqAST;
import ro.uaic.info.alk.exeptions.AlkSyntaxException;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.exeptions.InternalException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Helper for AST manipulation prior to visiting.
 */
public class AlkIncludePreprocessor
implements Preprocessor
{
    private final Stack<String> loaded = new Stack<>();

    @Override
    public AST preprocess(AST tree)
    {
        if (tree instanceof IncludeAST)
        {
            String path = getPath((IncludeAST) tree);

            if (isLoaded(path))
            {
                // TODO improve message including stack
                throw new AlkException("Include cycle detected: " + tree);
            }

            load(path);

            try
            {
                tree = parse(path);
                return preprocess(tree);
            }
            finally
            {
                unload();
            }
        }
        else
        {
            for (int i = 0; i < tree.getChildCount(); i++)
            {
                AST child = tree.getChild(i);
                AST result = preprocess(child);
                if (child != result)
                {
                    tree.deleteChild(i);
                    tree.addChild(i, result);
                }
            }

            return tree;
        }
    }

    private String getPath(IncludeAST include)
    {
        String includeStr = include.getChild(0).toString();
        String path = includeStr.substring(0, includeStr.length() - 1);
        File file = new File(path);
        if (file.isAbsolute())
        {
            return file.getAbsolutePath();
        }
        else
        {
            String top = getCurrentlyLoaded();
            String nativeDir = top.substring(0, top.lastIndexOf(File.separator));
            return Paths.get(nativeDir, path).toString();
        }
    }

    private StmtSeqAST parse(String path)
    {
        path = new File(path).getAbsolutePath();
        AST tree;
        try
        {
            tree = new SimpleAlkParser().parse(new String(Files.readAllBytes(Paths.get(path))));

            if (tree == null)
            {
                throw new AlkSyntaxException("Syntax error in: " + path);
            }

            if (!(tree instanceof StmtSeqAST))
            {
                throw new InternalException("Unexpected type of AST after parsing: " + path);
            }

            return (StmtSeqAST) tree;
        }
        catch (IOException e)
        {
            throw new AlkException("File not found: " + path);
        }
    }

    private String getCurrentlyLoaded()
    {
        return loaded.peek();
    }

    private boolean isLoaded(String path)
    {
        File file = new File(path);
        return loaded.contains(file.getAbsolutePath());
    }

    private void load(String path)
    {
        File file = new File(path);
        loaded.add(file.getAbsolutePath());
    }

    private void unload()
    {
        loaded.pop();
    }
}
