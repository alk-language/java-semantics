package util.functions;

import execution.helpers.MathHelper;
import execution.types.AlkValue;
import parser.env.Location;
import util.lambda.LocationGenerator;

import java.util.List;

public class Methods {

    @BuiltInMethod(paramNumber = 1)
    public static Location pushBack(Location loc, List<AlkValue> params, LocationGenerator generator)
    {
        loc.toRValue().pushBack(generator.generate(params.get(0).clone(generator)));
        return loc;
    }
}
