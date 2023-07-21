package ro.uaic.info.alk.visitor.stateful;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.state.Payload;
import ro.uaic.info.alk.state.Result;
import ro.uaic.info.alk.state.State;

public interface StatefulInterpreterManager<T extends Payload, S extends Result<?>, U extends State<T, S>>
{
    U interpret(AST tree, T payload);
    StatefulInterpreterManager<T, S, U> makeClone();
}
