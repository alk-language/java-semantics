package ro.uaic.info.alk.execution.state.function;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.exhaustive.SplitMapper;
import ro.uaic.info.alk.execution.state.ExecutionState;
import ro.uaic.info.alk.execution.state.PrimitiveState;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.util.types.Storable;

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
