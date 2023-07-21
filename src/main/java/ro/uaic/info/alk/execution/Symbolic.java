package ro.uaic.info.alk.execution;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.expr.SymIDAST;
import ro.uaic.info.alk.storage.StoreImpl;
import ro.uaic.info.alk.exeptions.AlkException;
import ro.uaic.info.alk.execution.state.symbolic.SymbolicOldState;
import ro.uaic.info.alk.types.AlkBool;
import ro.uaic.info.alk.execution.utils.Stepper;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.exeptions.InternalException;
import ro.uaic.info.alk.util.functions.Parameter;
import ro.uaic.info.alk.util.pc.PathCondition;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class Symbolic
{
    public static void verifyFunction(AlkFunction function, AlkExecution exec)
    {
        String id = function.getName();

        StoreImpl store = new StoreImpl();
        Environment env = new EnvironmentImpl(store);
        PathCondition pc = new PathCondition(exec.getConfig().hasProver());

        for (int i = 0; i < function.getParams().size(); i++)
        {
            Parameter param = function.getParam(i);
            AST symAST = SymIDAST.generate(param.getName());
            SymbolicValue value = new SymbolicValue(symAST);
            env.define(param.getName()).setValue(value);
            env.define(SymbolicOldState.oldName + "(" + param.getName() + ")").setValue(value);
            if (param.getDataType() == null)
            {
                throw new AlkException("Can't verify " + id + " because the type of " + param.getName() + " can't be identified!");
            }
            pc.setType(symAST.getText(), param.getDataType(), true);
        }

        // TODO: implement modifies and uses

        for (AST req : function.getRequires())
        {
            Storable r = Stepper.run(req,
                                     exec.getConfig(),
                                     env,
                                     store,
                                     pc,
                                     exec.getFuncManager(),
                                     exec.getInterpreter());
            if (r instanceof SymbolicValue)
            {
                pc.add((SymbolicValue) r);
            }
            else if (r instanceof AlkBool)
            {
                if (!((AlkBool) r).isTrue())
                {
                    throw new AlkException("Can't add false precondition!");
                }
            }
            else
            {
                throw new InternalException("Can't identify the type of this precondition: " + r);
            }
        }

        List<ExecutionOutput> results = Stepper.runBatch(
                function.getBody(),
                exec.getConfig(),
                env,
                store,
                pc,
                exec.getFuncManager(),
                exec.getInterpreter()
        );

        for (ExecutionOutput output : results)
        {
            if (output.failure)
            {
                continue;
            }
            if (output.hasError)
            {
                throw new AlkException("Function " + id + " can't be verified!");
            }
            for (AST ens : function.getEnsures())
            {
                Storable e = Stepper.run(ens,
                        output.exec.getConfig(),
                        output.exec.getGlobal(),
                        output.exec.getStore(),
                        output.exec.getPathCondition(),
                        output.exec.getFuncManager(),
                        output.exec.getInterpreter());
                if (e instanceof SymbolicValue)
                {
                    if (!output.exec.getPathCondition().asserts((SymbolicValue) e))
                    {
                        throw new AlkException("Ensures condition at line " + ens.getLine() + " doesn't hold: " + e.toString() +
                                ".\nThe current path condition is: " + output.exec.getPathCondition());
                    }
                }
                else if (e instanceof AlkBool)
                {
                    if (!((AlkBool) e).isTrue())
                    {
                        throw new AlkException("Ensures doesn't hold!");
                    }
                }
                else
                {
                    throw new InternalException("Can't identify the type of this precondition: " + e);
                }
            }
        }

        exec.getConfig().getIOManager().write("Successfully verified: " + function.getName());
    }
}
