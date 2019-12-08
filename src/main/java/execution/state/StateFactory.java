package execution.state;

import execution.state.statement.ChooseStmtState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.env.Environment;
import util.EnvironmentManager;


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
