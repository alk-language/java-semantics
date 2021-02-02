package visitor.stateful;

import ast.AST;
import state.Payload;
import state.Result;
import state.State;

public interface StatefulInterpreterManager<T extends Payload, S extends Result<?>, U extends State<T, S>>
{
    U interpret(AST tree, T payload);
}
