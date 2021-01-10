package visitor;

import visitor.ifaces.expr.*;

public interface ExpressionVisitorIface<T>
extends AdditiveVisitorIface<T>,
        ArrayVisitorIface<T>,
        BitwiseAndVisitorIface<T>,
        BitwiseOrVisitorIface<T>,
        BoolVisitorIface<T>,
        BracketVisitorIface<T>,
        ComponentVisitorIface<T>,
        ConditionalExprVisitorIface<T>,
        EqualityVisitorIface<T>,
        FloatVisitorIface<T>,
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
        UnaryVisitorIface<T>
{

}
