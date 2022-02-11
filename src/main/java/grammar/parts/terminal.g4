grammar terminal;

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

ASSERT: 'assert';
ASSUME: 'assume';
SYMBOLIC: 'symbolic';
INVARIANT : 'invariant';
REQURIES : 'requires';
ENSURES : 'ensures';
RESULT : 'result';

IMPLIES: '==>';
EQUIV: '<==>';
FORALL: 'forall';
EXISTS: 'exists';
QUANTIFIER_SEPARATOR: '::';


//Cofiguration
TO: '|->';

//Keywords
IF : 'if';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
FOR : 'for';
FOREACH : 'foreach';
IN : 'in';
FROM : 'from';
OUT : 'out';
HAVOC : 'havoc';
CHOOSE : 'choose';
UNIFORM : 'uniform';
REPEAT : 'repeat';
RETURN : 'return';
SUCCESS : 'success';
UNTIL : 'until';
FAILURE : 'failure';

CONTINUE: 'continue';
BREAK: 'break';

EMPTYMAP : 'emptyMap';
EMPTYSET : 'emptySet';
EMPTYLIST : 'emptyList';
EMPTYSTRUCTURE : 'emptyStructure';

MODIFIES : 'modifies';
USES : 'uses';
INCLDUE : 'include';

XOR : 'xor';

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
ARRAY : 'array';
SET : 'set';

//Builtin Functions
AT : 'at';
BELONGSTO : 'belongsTo';
DELETE : 'delete';
EMPTY : 'empty';
END : 'end';
FIRST : 'first';
FLOAT : 'float';
INSERT : 'insert';
KEYS : 'keys';
INTEGER : 'int';
BOOLEAN : 'boolean';
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
DOUBLE : [0-9]+ POINT [0-9]+;
BOOL : 'true'| 'false';
ID : NONDIGIT (DIGIT | NONDIGIT)*;

//Unary Operators
PLUSPLUS : '++';
MINUSMINUS : '--';

//Bitwise Operators
BITWISE_AND : '&';

//Iterator Operators
PLUSMOD : '+%';
MINUSMOD : '-%';
PLUSPLUSMOD : '++%';
MINUSMINUSMOD : '--%';

//Relational Operators
LOWER : '<';
GREATER : '>';
LOWEREQ : '<=';
GREATEREQ : '>=';
ISEQUAL : '==';
NOTEQUAL : '!=';

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
LEFTSHIFT : '<<';
RIGHTSHIFT : '>>';

//Boolean Operators
OR : '||';
AND : '&&';
NOT : '!';

//Other
SEMICOLON : ';';
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