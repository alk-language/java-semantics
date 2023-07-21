package ro.uaic.info.alk.boogie;

import ro.uaic.info.alk.enums.*;
import ro.uaic.info.alk.util.Pair;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.visitor.interpreter.SmallStepExpressionInterpreter;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class BoogieExpressionInterpreter
implements SmallStepExpressionInterpreter<String>
{
   private final HashMap<String, String> renamer;

   public BoogieExpressionInterpreter(HashMap<String, String> renamer)
   {
      this.renamer = renamer;
   }

   @Override
   public String interpretVariable(String id)
   {
      return renamer.getOrDefault(id, id);
   }

   @Override
   public String interpretSymId(String id)
   {
      throw new InternalException("Can't convert symbolic id to Boogie: " + id);
   }

   @Override
   public String interpretContextVar(ContextVar old, String id)
   {
      return "\\old_" + id;
   }

   @Override
   public String interpretPrimitive(Primitive primitive, String value)
   {
      switch (primitive)
      {
         case STRING:
            return "\"" + value + "\"";
         case INT:
         case FLOAT:
         case BOOL:
            return value;
      }

      throw new InternalException("Can't convert primitive to Boogie: " + value);
   }

   @Override
   public String interpretComposite(Primitive primitive, List<String> values)
   {
      return null;
   }

   @Override
   public String interpretCompositeInterval(Primitive primitive, String left, String right)
   {
      return null;
   }

   @Override
   public String interpretCompositeFilterSpec(Primitive primitive, String id, String fromExpr,
                                              Function<String, Object> suchThat)
   {
      return null;
   }

   @Override
   public String interpretCompositeSelectSpec(Primitive primitive, String id, String fromExpr,
                                              Function<String, Object> suchThat)
   {
      return null;
   }

   @Override
   public String interpretCompositeComponents(Primitive primitive, List<Pair<String, String>> comps)
   {
      return null;
   }


   @Override
   public String evaluate(FOL op, List<String> values)
   {
      switch (op)
      {
         case IMPLIES:
            return String.join(" ==> ", values);
         case EQUIV:
            return String.join(" <==> ", values);
      }
      throw new InternalException("Can't convert operator to Boogie: " + op);
   }

   @Override
   public String evaluate(Operator op, List<String> values)
   {
      String result = null;
      switch (op)
      {
         case IFELSE:
            break;
         case LOGICAL_OR:
            result = String.join(" || ", values); break;
         case LOGICAL_AND:
            result = String.join(" && ", values); break;
         case IN:
            break;
         case EQUAL:
            result = String.join(" == ", values); break;
         case NOT_EQUAL:
            result = String.join(" != ", values); break;
         case LOWER:
            result = String.join(" < ", values); break;
         case LOWER_EQ:
            result = String.join(" <= ", values); break;
         case GREATER:
            result = String.join(" > ", values); break;
         case GREATER_EQ:
            result = String.join(" >= ", values); break;
         case UNION:
            break;
         case INTERSECT:
            break;
         case SET_SUBTRACT:
            break;
         case BITWISE_OR:
            break;
         case BITWISE_AND:
            break;
         case BITWISE_XOR:
            break;
         case SHIFT_LEFT:
            break;
         case SHIFT_RIGHT:
            break;
         case ADD:
            result = String.join(" + ", values); break;
         case SUBTRACT:
            result = String.join(" - ", values); break;
         case MULTIPLY:
            result = String.join(" * ", values); break;
         case DIVIDE:
            result = String.join(" div ", values); break;
         case MOD:
            result = String.join(" mod ", values); break;
         case PLUSPLUSLEFT:
            break;
         case MINUSMINUSLEFT:
            break;
         case POSITIVE:
            break;
         case NEGATIVE:
            result = "-" + values.get(0); break;
         case NOT:
            result = "!" + values.get(0); break;
         case PLUSPLUSRIGHT:
            break;
         case MINUSMINUSRIGHT:
            break;
         case BRACKET:
            break;
         case DOT:
            break;
         case ASSIGN:
            return String.join(" := ", values);
         case PLUS_ASSIGN:
            break;
         case MINUS_ASSIGN:
            break;
         case MULTIPLY_ASSIGN:
            break;
         case DIVIDE_ASSIGN:
            break;
         case MOD_ASSIGN:
            break;
         case LEFT_SHIFT_ASSIGN:
            break;
         case RIGHT_SHIFT_ASSIGN:
            break;
         case BITWISE_OR_ASSIGN:
            break;
         case BITWISE_AND_ASSIGN:
            break;
      }
      if (result != null)
         return "(" + result + ")";
      throw new InternalException("Can't convert primitive to Boogie: " + op);
   }

   @Override
   public String evaluateBuiltIn(AlkBuiltInMethod op, String factor, List<String> params)
   {
      return null;
   }

   @Override
   public String evaluateResult()
   {
      return "\\result";
   }
}
