lexer grammar AlkLexer;

// SKIPPED CHARACTERS
WS : [ \t\r\n]+ -> skip;
COMMENT
:
    '/*' .*? '*/' -> skip
;
LINE_COMMENT
:
   '//' ~[\r\n]* -> skip
;

fragment NONDIGIT: [a-zA-Z_];
fragment DIGIT: [0-9];
fragment NONZERODIGIT: [1-9];

ASSERT: '@assert';
ASSUME: '@assume';
ENSURES: '@ensures';
HAVOC: '@havoc';
INVARIANT: '@invariant';
LOOPASSESRT: '@loopassert';
MODIFIES_ANNO: '@modifies';
REQURIES: '@requires';
SYMBOLIC: '@symbolic';
VAR:  '@var';

RESULT: '\\result';
OLD: '\\old';

IMPLIES: '==>';
EQUIV: '<==>';
FORALL: 'forall';
EXISTS: 'exists';
QUANTIFIER_SEPARATOR: '::';

//Cofiguration
TO: '|->';

//Keywords
BREAK: 'break';
CHOOSE : 'choose';
CONTINUE: 'continue';
FOR : 'for';
FOREACH : 'foreach';
FROM : 'from';
DO : 'do';
ELSE : 'else';
FAILURE : 'failure';
IF : 'if';
IN : 'in';
OUT : 'out';
REPEAT : 'repeat';
RETURN : 'return';
SUCCESS : 'success';
UNIFORM : 'uniform';
UNTIL : 'until';
WHILE : 'while';


EMPTYARRAY : 'emptyArray';
EMPTYLIST : 'emptyList';
EMPTYMAP : 'emptyMap';
EMPTYSET : 'emptySet';
EMPTYSTRUCTURE : 'emptyStructure';

MODIFIES : 'modifies';
USES : 'uses';
INCLUDE : 'include';

BITWISE_XOR : 'xor';

//Math Functions
ABS : 'abs';
ACOS : 'acos';
ASIN : 'asin';
ATAN : 'atan';
COS : 'cos';
LOG : 'log';
PI : 'pi';
POW : 'pow';
SIN : 'sin';
SQRT : 'sqrt';
TAN : 'tan';

//String Functions
LEN : 'len';

//Data types
BOOL_TYPE : 'boolean';
INT_TYPE : 'int';
FLOAT_TYPE : 'float';
STRING_TYPE : 'string';
ARRAY_TYPE : 'array';
LIST_TYPE  : 'list';
MAP_TYPE  : 'map';
SET_TYPE : 'set';
STRUCT_TYPE : 'struct';

//Builtin Functions
AT : 'at';
EMPTY : 'empty';
INSERT : 'insert';
KEYS : 'keys';
PRINT : 'print';
POPBACK : 'popBack';
POPFRONT : 'popFront';
PUSHBACK : 'pushBack';
PUSHFRONT : 'pushFront';
REMOVE : 'remove';
REMOVEALLEQTO : 'removeAllEqTo';
REMOVEAT : 'removeAt';
SINGLETONSET : 'singletonSet';
SIZE : 'size';
SPLIT : 'split';
TOPBACK : 'topBack';
TOPFRONT : 'topFront';
UPDATE : 'update';

// Probabilistic functions
UNIFORMNAT : 'uniformNat';
FLIP : 'flip';
UNIFORMFLOAT : 'uniformFloat';
UNIFORMPERM : 'uniformPerm';

SOTHAT : 's.t.';

// Symbolic marker
SYM : '$';

//Structure
ARROW : '->';
NUMSIGN : '#';
ANNO : '@';

//Anno Count
COUNT : 'Count';

//Set Operators
UNION : 'U';
INTERSECT : '^';
SUBTRACT : '\\';

//Data types
INT : [0-9]+;
FLOAT : [0-9]+ POINT [0-9]+;
BOOL : 'true'| 'false';
ID : NONDIGIT (DIGIT | NONDIGIT)*;

//Unary Operators
PLUSPLUS : '++';
MINUSMINUS : '--';

//Bitwise Operators
BITWISE_AND : '&';

//Relational Operators
LOWER : '<';
GREATER : '>';
LOWER_EQ : '<=';
GREATER_EQ : '>=';
IS_EQUAL : '==';
NOT_EQUAL : '!=';

//Assignment Operators
ASSIGNMENT_OPERATOR: '=' | '+=' | '-=' | '*=' | '/=' | '%=' | '<<=' | '>>=' | '&=' | '|=';

//Arithmetic Operators
MINUS : '-';
PLUS : '+';
MUL : '*';
DIV : '/';
MOD : '%';
LPAR : '(';
RPAR : ')';

//Shifts
LEFT_SHIFT : '<<';
RIGHT_SHIFT : '>>';

//Boolean Operators
OR : '||';
AND : '&&';
NOT : '!';

//Other
SEMI : ';';
DPOINT : ':';
VBAR : '|';
LCB : '{';
RCB : '}';
COMMA : ',';
POINT : '.';
LBRA : '[';
RBRA : ']';
QUOTE : '"';
QUESTION : '?';

STRING : '"' ~('\r' | '\n' | '"')* '"' ;