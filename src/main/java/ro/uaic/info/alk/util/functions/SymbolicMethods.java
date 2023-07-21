package ro.uaic.info.alk.util.functions;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.attr.BuiltInMethodASTAttr;
import ro.uaic.info.alk.enums.AlkBuiltInMethod;
import ro.uaic.info.alk.ast.expr.FactorPointMethodAST;
import ro.uaic.info.alk.ast.symbolic.SelectAST;
import ro.uaic.info.alk.ast.symbolic.StoreAST;
import ro.uaic.info.alk.execution.AlkExecution;
import ro.uaic.info.alk.storage.Location;
import ro.uaic.info.alk.types.AlkValue;
import ro.uaic.info.alk.symbolic.SymbolicValue;
import ro.uaic.info.alk.util.lambda.LocationGenerator;
import ro.uaic.info.alk.util.types.Storable;

import java.util.List;

public class SymbolicMethods
{
    @BuiltInMethodAnno(paramNumber = 0)
    public static Location topback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.TOP_BACK);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        return generator.generate(new SymbolicValue(tree));
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static Location topfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.TOP_FRONT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        return generator.generate(new SymbolicValue(tree));
    }

    @BuiltInMethodAnno(paramNumber = 2)
    public static Location insert(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        tree.addChild(SymbolicValue.toSymbolic(params.get(0).toRValue()).toAST());
        tree.addChild(SymbolicValue.toSymbolic(params.get(1).toRValue()).toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.INSERT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        loc.setValue(new SymbolicValue(tree));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location removeat(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        tree.addChild(SymbolicValue.toSymbolic(params.get(0).toRValue()).toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.REMOVE_AT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        loc.setValue(new SymbolicValue(tree));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static Location size(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.SIZE);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        return generator.generate(new SymbolicValue(tree));
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location pushback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        tree.addChild(SymbolicValue.toSymbolic(params.get(0).toRValue()).toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.PUSH_BACK);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        loc.setValue(new SymbolicValue(tree));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    public static Location pushfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        tree.addChild(SymbolicValue.toSymbolic(params.get(0).toRValue()).toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.PUSH_FRONT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        loc.setValue(new SymbolicValue(tree));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    @StatefulMethodAnno
    public static Location at(Location loc, List<Storable> params, LocationGenerator generator, AlkExecution exec)
    {
        AST selectAST = new SelectAST(null);
        SymbolicValue root = SymbolicValue.toSymbolic(loc.toRValue());
        selectAST.addChild(root.toAST());
        SymbolicValue position = SymbolicValue.toSymbolic(params.get(0).toRValue());
        selectAST.addChild(position.toAST());

        exec.getPathCondition().pclh.notifySelect(root, position);

        return generator.generate(new SymbolicValue(selectAST));
    }

    @BuiltInMethodAnno(paramNumber = 2)
    @StatefulMethodAnno
    public static Location update(Location loc, List<AlkValue> params, LocationGenerator generator, AlkExecution exec)
    {
        AST storeAST = new StoreAST(null);
        SymbolicValue oldValue = SymbolicValue.toSymbolic(loc.toRValue());
        storeAST.addChild(oldValue.toAST());
        SymbolicValue position = SymbolicValue.toSymbolic(params.get(0).toRValue());
        storeAST.addChild(position.toAST());
        SymbolicValue value = SymbolicValue.toSymbolic(params.get(1).toRValue());
        storeAST.addChild(value.toAST());

        SymbolicValue newValue = new SymbolicValue(storeAST);
        exec.getPathCondition().pclh.notifyStore(oldValue, newValue, position, value);

        return generator.generate(newValue);
    }

    @BuiltInMethodAnno(paramNumber = 0)
    @StatefulMethodAnno
    public static Location popback(Location loc, List<Storable> params, LocationGenerator generator, AlkExecution exec)
    {
        SymbolicValue oldValue = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(oldValue.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.POP_BACK);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        SymbolicValue newValue = new SymbolicValue(tree);
        loc.setValue(newValue);

        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    @StatefulMethodAnno
    public static Location popfront(Location loc, List<Storable> params, LocationGenerator generator, AlkExecution exec)
    {
        SymbolicValue oldValue = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(oldValue.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(AlkBuiltInMethod.POP_FRONT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        SymbolicValue newValue = new SymbolicValue(tree);
        loc.setValue(newValue);

        return loc;
    }
}
