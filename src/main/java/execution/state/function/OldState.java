package execution.state.function;

import ast.*;
import ast.attr.*;
import execution.*;
import execution.exhaustive.*;
import execution.parser.exceptions.*;
import execution.state.*;
import execution.state.symbolic.*;
import util.types.*;

public class OldState
extends PrimitiveState
{
   public static final String oldName = "\\old";

   public OldState(AST tree, ExecutionPayload executionPayload)
   {
      super(tree, executionPayload);
   }

   @Override
   protected Storable requireResult()
   {
      String varName = oldName + "(" + tree.getAttribute(IdASTAttr.class).getId() + ")";
      if (!getEnv().has(varName))
      {
         super.handle(new AlkException("Invalid use of " + varName + " context variable: " +
            "\\old should be used in a post-condition!"));
      }
      return getEnv().getLocation(varName);
   }

   @Override
   public ExecutionState clone(SplitMapper sm)
   {
      OldState copy = new OldState(tree, payload.clone(sm));
      return super.decorate(copy, sm);
   }
}
