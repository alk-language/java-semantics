package control.extractor;

import org.antlr.v4.runtime.tree.ParseTree;

public interface Extractor
{
    void execute(ParseTree tree);
}
