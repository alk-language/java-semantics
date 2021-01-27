package visitor.ifaces;

import visitor.ifaces.stmt.*;

public interface StmtVisitorIface<T>
extends AssignmentVisitorIface<T>,
        BlockVisitorIface<T>,
        BreakVisitorIface<T>,
        ChooseVisitorIface<T>,
        ContinueVisitorIface<T>,
        DoWhileVisitorIface<T>,
        ExprStmtVisitorIface<T>,
        FailureVisitorIface<T>,
        ForVisitorIface<T>,
        ForEachVisitorIface<T>,
        FunctionDeclVisitorIface<T>,
        IfThenVisitorIface<T>,
        RepeatUntilVisitorIface<T>,
        ReturnStmtVisitorIface<T>,
        StmtSeqVisitorIface<T>,
        SuccessVisitorIface<T>,
        UniformVisitorIface<T>,
        WhileVisitorIface<T>
{
}
