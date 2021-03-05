package visitor.stateful;

import ast.AST;
import state.Payload;
import state.Result;
import state.State;
import util.Listener;

public interface StatefulInterpreterManager<T extends Payload, S extends Result<?>, U extends State<T, S>>
{
    U interpret(AST tree, T payload);
    void registerListener(Listener<U> listener);
    void notify(U state);
}
