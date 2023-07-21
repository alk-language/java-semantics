package execution.state.statement;

import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.execution.ExecutionInterpreter;
import ro.uaic.info.alk.execution.ExecutionPayload;
import ro.uaic.info.alk.execution.ExecutionStack;
import ro.uaic.info.alk.execution.Environment;
import ro.uaic.info.alk.execution.EnvironmentImpl;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.parser.SimpleAlkParser;
import ro.uaic.info.alk.types.AlkInt;
import ro.uaic.info.alk.exeptions.InvalidAssumptionException;
import ro.uaic.info.alk.exeptions.InvalidStatementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.AlkConfiguration;
import ro.uaic.info.alk.util.pc.PathCondition;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssumeStateTest
{
    @Nested
    class ConcreteAssumeStateTest {

        @Mock
        private AlkConfiguration config;

        @Mock
        private AlkExecution execution;

        @Mock
        private ExecutionPayload payload;

        @BeforeEach
        public void init()
        {
            when(execution.getConfig()).thenReturn(config);
            when(execution.getInterpreter()).thenReturn(new ExecutionInterpreter(false));

            when(payload.getExecution()).thenReturn(execution);
        }

        @Test
        public void assumeConcreteTrue()
        {
            ExecutionStack stack = new ExecutionStack(execution);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse("@assume true;"), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertDoesNotThrow(stack::run);
            Assertions.assertTrue(stack.empty());
        }

        @Test
        public void assumeConcreteFalse()
        {
            ExecutionStack stack = new ExecutionStack(execution);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse("@assume false;"), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertThrows(InvalidAssumptionException.class, stack::run);
        }

        @Test
        public void assumeConcreteComplexTrue()
        {
            when(execution.getStore()).thenReturn(new StoreImpl());

            ExecutionStack stack = new ExecutionStack(execution);
            Environment env = new EnvironmentImpl(execution.getStore());
            env.define("a").setValue(AlkInt.ZERO);
            when(payload.getEnv()).thenReturn(env);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse("@assume a == 0;"), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertDoesNotThrow(stack::run);
            Assertions.assertTrue(stack.empty());
        }

        @Test
        public void assumeConcreteComplexFalse()
        {
            when(execution.getStore()).thenReturn(new StoreImpl());

            ExecutionStack stack = new ExecutionStack(execution);
            Environment env = new EnvironmentImpl(execution.getStore());
            env.define("a").setValue(AlkInt.ZERO);
            when(payload.getEnv()).thenReturn(env);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse("@assume a == 1;"), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertThrows(InvalidAssumptionException.class, stack::run);
        }

        @Test
        public void assumeConcreteInvalidType()
        {
            ExecutionStack stack = new ExecutionStack(execution);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse("@assume 0;"), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertThrows(InvalidStatementException.class, stack::run);
        }
    }


    @Nested
    class SymbolicAssumeStateTest {

        @Mock
        private AlkConfiguration config;

        @Mock
        private AlkExecution execution;

        @Mock
        private ExecutionPayload payload;

        @BeforeEach
        public void init()
        {
            when(execution.getConfig()).thenReturn(config);
            when(execution.getPathCondition()).thenReturn(new PathCondition(false));
            when(execution.getInterpreter()).thenReturn(new ExecutionInterpreter(true));

            when(payload.getExecution()).thenReturn(execution);
        }

        @Test
        public void assumeSymbolicTrue()
        {
            String code = "@symbolic $a : boolean; @assume $a;";
            ExecutionStack stack = new ExecutionStack(execution);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse(code), payload));

            Assertions.assertDoesNotThrow(stack::run);
            Assertions.assertTrue(stack.empty());
        }

        @Test
        public void assumeSymbolicComplexTrue()
        {
            String code = "@symbolic $a : boolean; @assume a == $a;";
            when(execution.getStore()).thenReturn(new StoreImpl());

            ExecutionStack stack = new ExecutionStack(execution);
            Environment env = new EnvironmentImpl(execution.getStore());
            env.define("a").setValue(new SymbolicValue(SimpleAlkParser.parseExpr("$a")));
            when(payload.getEnv()).thenReturn(env);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse(code), payload));

            Assertions.assertDoesNotThrow(stack::run);
            Assertions.assertTrue(stack.empty());
        }

        @Test
        public void assumeSymbolicInvalidType()
        {
            String code = "@symbolic $a : int; @assume $a;";
            ExecutionStack stack = new ExecutionStack(execution);
            stack.push(execution.getInterpreter().interpret(SimpleAlkParser.parse(code), payload));

            Assertions.assertEquals(1, stack.size());
            Assertions.assertThrows(InvalidStatementException.class, stack::run);
        }
    }
}