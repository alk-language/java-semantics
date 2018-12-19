package impl;
import grammar.*;
import impl.env.Environment;
import impl.visitors.AssignmentVisitor;
import impl.visitors.expression.ExpressionVisitor;
import impl.visitors.function.FunctionVisitor;

import java.math.BigDecimal;

public class VisitorBaseImpl extends alkBaseVisitor {

    private Environment env = new Environment();



}