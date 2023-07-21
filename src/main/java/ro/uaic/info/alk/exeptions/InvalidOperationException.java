package ro.uaic.info.alk.exeptions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.enums.Operator;
import ro.uaic.info.alk.types.TypeName;
import ro.uaic.info.alk.util.types.Storable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InvalidOperationException
extends AlkException
{
    public InvalidOperationException(Operator op, AST ast)
    {
        super("Invalid \"" + op.getSyntax() + "\" operation used in  " + ast + ". Data type mismatch!");
    }

    public InvalidOperationException(Operator op, Storable target)
    {
        super("Invalid \"" + op.getSyntax() +
              "\" operation for operand " + target +
              (target.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + target.getClass().getAnnotation(TypeName.class).value() : "") + ".");
    }

    public InvalidOperationException(Operator op, Storable leftOperand, Storable rightOperand)
    {
        super("Invalid \"" + op.getSyntax() +
              "\" operation for operands " + leftOperand +
              (leftOperand.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + leftOperand.getClass().getAnnotation(TypeName.class).value() : "") +
              " and " + rightOperand +
              (rightOperand.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + rightOperand.getClass().getAnnotation(TypeName.class).value() : "") + ".");
    }

    public InvalidOperationException(Operator op,
                                     Storable leftOperand,
                                     Storable rightOperand,
                                     AlkException cause)
    {
        super("Invalid \"" + op.getSyntax() +
              "\" operation for operands " + leftOperand +
              (leftOperand.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + leftOperand.getClass().getAnnotation(TypeName.class).value() : "") +
              " and " + rightOperand +
              (rightOperand.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + rightOperand.getClass().getAnnotation(TypeName.class).value() : "") + ".", cause);
    }

    public InvalidOperationException(AlkBuiltInMethod method, Storable target, Storable... args)
    {
        super("Invalid \"" + method.toString().toLowerCase() +
              "\" built-in method for target " + target +
              (target.getClass().isAnnotationPresent(TypeName.class) ?
              " of type " + target.getClass().getAnnotation(TypeName.class).value() : "") +
              " with " + args.length + " parameter(s): " +
              Arrays.stream(args)
                    .map(Storable::toRValue)
                    .map((value) -> value.toString() +
                        (value.getClass().isAnnotationPresent(TypeName.class) ?
                        " of type " + value.getClass().getAnnotation(TypeName.class).value() : ""))
                    .collect(Collectors.joining(", ")) + ".");
    }

    public static MethodExceptionBuilder builder(AlkBuiltInMethod method)
    {
        return new MethodExceptionBuilder(method);
    }

    public static OperatorExceptionBuilder builder(Operator op)
    {
        return new OperatorExceptionBuilder(op);
    }


    public static class OperatorExceptionBuilder
    {
        private final Operator op;
        private final List<Storable> operands = new ArrayList<>();
        private AlkException cause;

        public OperatorExceptionBuilder(Operator op)
        {
            this.op = op;
        }

        public OperatorExceptionBuilder operand(Storable storable)
        {
            this.operands.add(storable);
            return this;
        }

        public OperatorExceptionBuilder cause(AlkException cause)
        {
            this.cause = cause;
            return this;
        }

        public InvalidOperationException build()
        throws InvalidOperationException
        {
            InvalidOperationException ex = null;
            if (operands.size() == 1)
                ex = new InvalidOperationException(op, operands.get(0));
            else
                ex = new InvalidOperationException(op, operands.get(0), operands.get(1));
            ex.initCause(cause);
            return ex;
        }
    }

    public static class MethodExceptionBuilder
    {
        private final AlkBuiltInMethod method;
        private final List<Storable> params = new ArrayList<>();
        private AlkException cause;
        private Storable target;

        public MethodExceptionBuilder(AlkBuiltInMethod method)
        {
            this.method = method;
        }

        public MethodExceptionBuilder target(Storable target)
        {
            this.target = target;
            return this;
        }

        public MethodExceptionBuilder param(Storable storable)
        {
            this.params.add(storable);
            return this;
        }

        public MethodExceptionBuilder cause(AlkException cause)
        {
            this.cause = cause;
            return this;
        }

        public InvalidOperationException build()
        throws InvalidOperationException
        {
            InvalidOperationException ex = new InvalidOperationException(method,
                                                                         target,
                                                                         params.toArray(new Storable[0]));
            ex.initCause(cause);
            return ex;
        }
    }
}
