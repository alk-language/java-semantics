package execution.types.alkNotAValue;

import ast.AST;
import ast.expr.UnknownAST;
import execution.parser.env.LocationMapper;
import execution.parser.exceptions.AlkException;
import execution.parser.exceptions.InterpretorException;
import execution.parser.exceptions.NotImplementedException;
import execution.types.AlkValue;
import execution.types.alkBool.AlkBool;
import util.lambda.LocationGenerator;


public class AlkNotAValue extends AlkValue
{

    @Override
    public String toString() {
        return "?";
    }

    @Override
    public AlkBool equal(AlkValue operand) throws AlkException, InterpretorException {
        return new AlkBool(false);
    }

    @Override
    public AlkBool lower(AlkValue operand) throws AlkException, InterpretorException {
        return new AlkBool(false);
    }

    @Override
    public AlkValue weakClone(LocationMapper locMapping) {
        return clone(null);
    }

    @Override
    public AlkValue clone(LocationGenerator generator) {
        return new AlkNotAValue();
    }

    @Override
    public AlkValue toRValue()
    {
        return this;
    }

    @Override
    public AST toAST()
    {
        return new UnknownAST(null);
    }

    @Override
    public boolean isFullConcrete()
    {
        return true;
    }
}
