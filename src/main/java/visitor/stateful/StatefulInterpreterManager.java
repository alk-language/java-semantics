package visitor.stateful;

import ast.AST;
import ast.Payload;
import ast.Result;
import ast.State;

public interface StatefulInterpreterManager<T extends Payload, S extends Result<?>, U extends State<T, S>>
{
    U interpret(AST tree, T payload);
}
