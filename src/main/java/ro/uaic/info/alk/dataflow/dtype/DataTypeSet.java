package ro.uaic.info.alk.dataflow.dtype;

import ro.uaic.info.alk.ast.type.DataTypeAST;

public interface DataTypeSet
{
   DataTypeSet union(DataTypeSet value);

   boolean includes(DataTypeSet now);

   DataTypeSet intersect(DataTypeSet next);

   DataTypeAST unique();
}
