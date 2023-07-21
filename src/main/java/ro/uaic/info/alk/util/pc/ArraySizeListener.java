package ro.uaic.info.alk.util.pc;

import ro.uaic.info.alk.ast.symbolic.ValidSelectAST;
import ro.uaic.info.alk.ast.symbolic.ValidStoreAST;
import ro.uaic.info.alk.symbolic.SymbolicValue;

public class ArraySizeListener
implements PathConditionListener
{
    private final PathCondition pc;

    ArraySizeListener(PathCondition pc)
    {
        this.pc = pc;
    }

    @Override
    public void notifySelect(SymbolicValue root, SymbolicValue position)
    {
        ValidSelectAST tree = new ValidSelectAST(null);
        tree.addChild(root.toAST());
        tree.addChild(position.toAST());
        pc.add(new SymbolicValue(tree));
    }

    @Override
    public void notifyStore(SymbolicValue oldValue,
                            SymbolicValue newValue,
                            SymbolicValue position,
                            SymbolicValue value)
    {
        ValidStoreAST tree = new ValidStoreAST(null);
        tree.addChild(oldValue.toAST());
        tree.addChild(position.toAST());
        tree.addChild(value.toAST());
        pc.add(new SymbolicValue(tree));
    }
}
