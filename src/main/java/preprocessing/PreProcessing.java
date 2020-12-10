package preprocessing;

import grammar.alkLexer;
import grammar.alkParser;
import execution.parser.exceptions.AlkException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import preprocessing.visitors.PreMainVisitor;

import java.io.*;
import java.util.ArrayList;

import static execution.parser.exceptions.AlkException.ERR_INCLUDE;
import static execution.parser.exceptions.AlkException.ERR_INCLUDE_CYCLE;

public class PreProcessing {

    ParseTree tree;
    ArrayList<PreProcessing> dependencies = new ArrayList<>();

    public PreProcessing(File file, ArrayList<String> previous_includes) throws AlkException {
        try {
            previous_includes.add(file.getAbsolutePath());
            CharStream alkFile;
            try {
                InputStream alkInStr= new FileInputStream(file);
                alkFile = CharStreams.fromStream(alkInStr);
            }
            catch (IOException e) {
                InputStream alkInStr= new FileInputStream(new File(file.getAbsoluteFile()+".alk"));
                alkFile = CharStreams.fromStream(alkInStr);
            }
            alkLexer lexerAlk = new alkLexer(alkFile);
            CommonTokenStream tokensAlk = new CommonTokenStream(lexerAlk);
            alkParser parserAlk = new alkParser(tokensAlk);
            ParseTree tree = parserAlk.main();
            this.tree=tree;

            ArrayList<String> includes = new ArrayList<>();
            PreMainVisitor preMainVisitor = new PreMainVisitor(includes);
            preMainVisitor.visit(tree);

            for (String i : includes)
                if (previous_includes.contains(new File(i).getAbsolutePath()))
                    throw new AlkException(ERR_INCLUDE_CYCLE);

            for (String i : includes)
            {
                PreProcessing pre = new PreProcessing(new File(i), previous_includes);
                dependencies.add(pre);
            }

        } catch (IOException e) {
            throw new AlkException(ERR_INCLUDE + file.toString());
        }
    }
}
