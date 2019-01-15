grammar terminal;


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


//Keywords

IF : 'if';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
FOR : 'for';
FORALL : 'forall';
IN : 'in';
OUT : 'out';
CHOOSE : 'choose';
RETURN : 'return';
SUCCESS : 'success';
FAILURE : 'failure';

EMPTYSET : 'emptySet';
EMPTYLIST : 'emptyList';

XOR : 'xor';

//Builtin Functions
AT : 'at';
BELONGSTO : 'belongsTo';
DELETE : 'delete';
EMPTY : 'empty';
END : 'end';
FIRST : 'first';
INSERT : 'insert';
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
TOPBACK : 'topBack';
TOPFRONT : 'topFront';
UPDATE : 'update';

RANDOM : 'random';

//Structure
ARROW : '->';


//Set Operators
UNION : 'U';
INTERSECT : '^';
SUBSTRACT : '\\';



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
/*EQUAL : '=';
PLUSEQUAL : '+=';
MINUSEQUAL : '-=';
MULEQUAL : '*=';
DIVEQUAL : '/=';
MODEQUAL : '%=';
SHIFTLEFTEQUAL : '<<=';
SHIFTRIGHTEQUAL : '>>=';
ANDEQUAL : '&=';
XOREQUAL : '^=';
OREQUAL : '|=';*/


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