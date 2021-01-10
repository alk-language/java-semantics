package symbolic;

import ast.AST;
import ast.SimpleToken;
import execution.parser.env.Location;
import execution.parser.env.LocationMapper;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import util.lambda.LocationGenerator;
import util.types.Value;

public class SymbolicValue
implements SymbolicValueIface
{
    AST ast;

    public SymbolicValue(AST ast) {
        this.ast = ast;
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return null;
    }

    @Override
    public Value clone(LocationGenerator generator) {
        return null;
    }

    @Override
    public Value toRValue() {
        return null;
    }

    @Override
    public Location toLValue() {
        return null;
    }

    public AST getAst()
    {
        return ast;
    }

    @Override
    public String toString()
    {
        return ast.toString();
    }
}
