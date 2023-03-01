package dataflow.dtype;

import ast.type.DataTypeAST;

public interface DataTypeSet
{
   DataTypeSet union(DataTypeSet value);

   boolean includes(DataTypeSet now);

   DataTypeSet intersect(DataTypeSet next);

   DataTypeAST unique();
}
