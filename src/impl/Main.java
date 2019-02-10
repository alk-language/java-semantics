package impl;

import impl.env.Environment;
import impl.visitors.MainVisitor;
import impl.visitors.StmtVisitor;
import impl.visitors.expression.ExpressionVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.tree.*;
import grammar.*;

import java.io.IOException;

public class Main {

    public static void testExpression(ParseTree tree)
    {
        ExpressionVisitor exprVis = new ExpressionVisitor(new Environment());
        System.out.print(exprVis.visit(tree).toString());
    }

    public static void main( String[] args )
    {
        try
        {
            //Windows
            //CharStream input = CharStreams.fromFileName("E:/workspace/ANTLR/Expresii_aritmetice/expr/src/test.in");

            //Linux
            CharStream input = CharStreams.fromFileName("/home/alex/work/Alk/input/test.in");

            alkLexer lexer = new alkLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            alkParser parser = new alkParser(tokens);

            //testExpression(parser.expression());
            ParseTree tree = parser.main();
            MainVisitor alkVisitor = new MainVisitor(new Environment());
            alkVisitor.visit(tree);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
