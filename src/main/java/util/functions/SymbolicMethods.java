package util.functions;

import ast.AST;
import ast.attr.BuiltInMethodASTAttr;
import ast.enums.BuiltInMethod;
import ast.expr.FactorPointMethodAST;
import ast.symbolic.SelectAST;
import ast.symbolic.StoreAST;
import execution.Execution;
import execution.parser.env.Location;
import execution.types.AlkValue;
import execution.types.alkArray.AlkArray;
import symbolic.SymbolicValue;
import util.exception.SMTUnexpectedException;
import util.exception.SMTUnimplementedException;
import util.lambda.LocationGenerator;
import util.types.Storable;

import java.util.List;

public class SymbolicMethods
{
    @BuiltInMethodAnno(paramNumber = 0)
    public static Location topback(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.TOPBACK);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        return generator.generate(new SymbolicValue(tree));
    }

    @BuiltInMethodAnno(paramNumber = 0)
    public static Location topfront(Location loc, List<Storable> params, LocationGenerator generator)
    {
        SymbolicValue sym = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(sym.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.TOPFRONT);
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
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.INSERT);
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
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.REMOVEAT);
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
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.SIZE);
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
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.PUSHBACK);
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
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.PUSHFRONT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        loc.setValue(new SymbolicValue(tree));
        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 1)
    @StatefulMethodAnno
    public static Location at(Location loc, List<Storable> params, LocationGenerator generator, Execution exec)
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
    public static Location update(Location loc, List<AlkValue> params, LocationGenerator generator, Execution exec)
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
    public static Location popback(Location loc, List<Storable> params, LocationGenerator generator, Execution exec)
    {
        SymbolicValue oldValue = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(oldValue.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.POPBACK);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        SymbolicValue newValue = new SymbolicValue(tree);
        loc.setValue(newValue);

        return loc;
    }

    @BuiltInMethodAnno(paramNumber = 0)
    @StatefulMethodAnno
    public static Location popfront(Location loc, List<Storable> params, LocationGenerator generator, Execution exec)
    {
        SymbolicValue oldValue = SymbolicValue.toSymbolic(loc.toRValue());
        AST tree = new FactorPointMethodAST(null);
        tree.addChild(oldValue.toAST());
        BuiltInMethodASTAttr attr = new BuiltInMethodASTAttr(BuiltInMethod.POPFRONT);
        tree.addAttribute(BuiltInMethodASTAttr.class, attr);
        SymbolicValue newValue = new SymbolicValue(tree);
        loc.setValue(newValue);

        return loc;
    }
}
