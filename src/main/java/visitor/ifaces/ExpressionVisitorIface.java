package visitor.ifaces;

import visitor.ifaces.expr.*;
import visitor.ifaces.stmt.AssignmentVisitorIface;
import visitor.ifaces.stmt.IdDeclVisitorIface;

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
        EquivVisitorIface<T>,
        ExistsVisitorIface<T>,
        FactorPointIdIface<T>,
        FactorPointMethodVisitorIface<T>,
        FloatVisitorIface<T>,
        ForAllVisitorIface<T>,
        FunctionCallVisitorIface<T>,
        ImpliesVisitorIface<T>,
        InExprVisitorIface<T>,
        IntVisitorIface<T>,
        ListVisitorIface<T>,
        LogicalAndVisitorIface<T>,
        LogicalOrVisitorIface<T>,
        MapVisitorIface<T>,
        MultiplicativeVisitorIface<T>,
        PostfixVisitorIface<T>,
        PrefixVisitorIface<T>,
        RefIDVisitorIface<T>,
        RelationalVisitorIface<T>,
        ResultVisitorIface<T>,
        OldVisitorIface<T>,
        SetVisitorIface<T>,
        SetExprVisitorIface<T>,
        ShiftVisitorIface<T>,
        StringVisitorIface<T>,
        StructVisitorIface<T>,
        SymIDVisitorIface<T>,
        UnaryVisitorIface<T>,
        UnknownVisitorIface<T>
{

}
