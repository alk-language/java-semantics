package execution;

import ast.AST;
import ast.attr.IdASTAttr;
import ast.attr.ParamASTAttr;
import ast.enums.ParamType;
import ast.expr.SymIDAST;
import ast.stmt.FunctionDeclAST;
import execution.parser.env.*;
import execution.parser.exceptions.AlkException;
import execution.types.alkBool.AlkBool;
import execution.utils.Stepper;
import symbolic.SymbolicValue;
import util.exception.InternalException;
import util.functions.Parameter;
import util.pc.PathCondition;
import util.types.Storable;

import java.util.ArrayList;
import java.util.List;

public class Symbolic
{
    public static void verifyFunction(AlkFunction function, Execution exec)
    {
        String id = function.getName();

        StoreImpl store = new StoreImpl();
        Environment env = new EnvironmentImpl(store);
        PathCondition pc = new PathCondition();

        for (int i = 0; i < function.getParams().size(); i++)
        {
            Parameter param = function.getParam(i);
            AST symAST = SymIDAST.generate(param.getName());
            env.define(param.getName()).setValue(new SymbolicValue(symAST));
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
                    exec.getInterpreterManager());
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
                exec.getInterpreterManager()
        );
        for (ExecutionOutput output : results)
        {
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
                        output.exec.getInterpreterManager());
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
