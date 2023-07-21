package ro.uaic.info.alk.visitor.ifaces;

import ro.uaic.info.alk.visitor.ifaces.stmt.*;

public interface StmtVisitorIface<T>
   extends AssumeVisitorIface<T>,
           AssertVisitorIface<T>,
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
           HavocVisitorIface<T>,
           RepeatUntilVisitorIface<T>,
           ReturnStmtVisitorIface<T>,
           StmtSeqVisitorIface<T>,
           SuccessVisitorIface<T>,
           SymbolicDeclsVisitorIface<T>,
           IdDeclVisitorIface<T>,
           UniformVisitorIface<T>,
           VarVisitorIface<T>,
           WhileVisitorIface<T>
{
}
