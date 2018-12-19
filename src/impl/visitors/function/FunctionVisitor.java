package impl.visitors.function;
import grammar.alkBaseVisitor;
import impl.env.Environment;
import impl.visitors.expression.ExpressionVisitor;
import impl.visitors.structure.ListVisitor;

import java.math.BigDecimal;
import java.util.Scanner;
import static impl.constants.Constants.DEBUG;

public class FunctionVisitor extends alkBaseVisitor {

    private Environment env;

    public FunctionVisitor(Environment env) {
        this.env = env;
    }


}