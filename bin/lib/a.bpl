procedure test() returns (\result: int)
ensures (\result == 4);
{
var a : int,b : int;
a, b := 2, 2;
\result := (a + b);
return ;
}
