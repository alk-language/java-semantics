package impl.visitors;

import grammar.alkBaseVisitor;
import impl.env.Environment;
import impl.visitors.expression.ExpressionVisitor;
import impl.visitors.structure.ListVisitor;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AssignmentVisitor extends alkBaseVisitor {

    private Environment env;
    private Object value_to_assign;
    private ArrayList indexes = new ArrayList(); // cazul in care partea stanga reprezinta un element dintr-o lista (eventual nested)

    public AssignmentVisitor(Environment env) {
        this.env = env;
    }

}
