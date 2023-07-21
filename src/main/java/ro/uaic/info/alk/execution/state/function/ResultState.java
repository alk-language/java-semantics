package ro.uaic.info.alk.execution.state.function;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.util.types.Storable;

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

