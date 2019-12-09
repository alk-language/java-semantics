package execution.state;

import grammar.alkBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;


@Deprecated
public class StateFactory {

    public ExecutionState create(Class<? extends ExecutionState> stateClass,
                                 alkBaseVisitor visitor,
                                 Class<? extends ParseTree> ctxClass,
                                 ParseTree ctx,
                                 Environment env)
    {
        return null;
    }

}
