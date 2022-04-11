package execution.state.function;

import ast.*;
import execution.*;
import execution.exhaustive.*;
import execution.parser.exceptions.*;
import execution.state.*;
import execution.state.symbolic.*;
import util.types.*;

public class ResultState
extends PrimitiveState
{
   public static final String resultName = "\\result";

   public ResultState(AST tree, ExecutionPayload executionPayload)
   {
      super(tree, executionPayload);
   }

   @Override
   protected Storable requireResult()
   {
      if (!getEnv().has(resultName))
      {
         super.handle(new AlkException("Invalid use of result context variable: " +
            "\\result is not used in a post-condition or the function doesn't return!"));
      }
      return getEnv().getLocation(resultName);
   }

   @Override
   public ExecutionState clone(SplitMapper sm)
   {
      ResultState copy = new ResultState(tree, payload.clone(sm));
      return super.decorate(copy, sm);
   }
}

