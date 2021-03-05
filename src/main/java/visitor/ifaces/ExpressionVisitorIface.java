package visitor.ifaces;

import visitor.ifaces.expr.*;
import visitor.ifaces.stmt.AssignmentVisitorIface;

public interface ExpressionVisitorIface<T>
extends AdditiveVisitorIface<T>,
        ArrayVisitorIface<T>,
        AssignmentVisitorIface<T>,
        BitwiseAndVisitorIface<T>,
        BitwiseOrVisitorIface<T>,
        BoolVisitorIface<T>,
        BracketVisitorIface<T>,
        BuiltInFunctionVisitorIface<T>,
        ConditionalExprVisitorIface<T>,
        EqualityVisitorIface<T>,
        FactorPointIdIface<T>,
        FactorPointMethodVisitorIface<T>,
        FloatVisitorIface<T>,
        FunctionCallVisitorIface<T>,
        InExprVisitorIface<T>,
        IntVisitorIface<T>,
        ListVisitorIface<T>,
        LogicalAndVisitorIface<T>,
        LogicalOrVisitorIface<T>,
        MultiplicativeVisitorIface<T>,
        PostfixVisitorIface<T>,
        PrefixVisitorIface<T>,
        RefIDVisitorIface<T>,
        RelationalVisitorIface<T>,
        SetVisitorIface<T>,
        SetExprVisitorIface<T>,
        ShiftVisitorIface<T>,
        StringVisitorIface<T>,
        StructVisitorIface<T>,
        SymIDVisitorIface<T>,
        UnaryVisitorIface<T>
{

}
