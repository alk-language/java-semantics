package preprocessing.visitors;

import analysis.Analysis;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import preprocessing.PreProcessing;

import java.util.ArrayList;

public class PreMainVisitor extends alkBaseVisitor {

    ArrayList<String> includes;

    public PreMainVisitor(ArrayList includes)
    {
        this.includes = includes;
    }

    @Override public Object visitInclude(alkParser.IncludeContext ctx) {
        String value = ctx.STRING().toString();
        value = value.substring(1, value.length()-1);
        includes.add(value);
        return null;
    }
}
