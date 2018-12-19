grammar expression;

import terminal;


//Set related expressions
set_expression:
    set_atom ((UNION | INTERSECT | SUBSTRACT) set_atom)*
;

set_atom:
    ref_name
    | set
    | LPAR set_expression  RPAR
;


//Arithmetic expressions

expression
:
    logical_or_expression (QUESTION expression DPOINT expression)?
;

logical_or_expression
:
    logical_and_expression (OR logical_and_expression)*
;

logical_and_expression
:
    in_expression (AND in_expression)*
;

in_expression
:
    equality_expression (IN equality_expression)*
;

equality_expression
:
    relational_expression ((ISEQUAL | NOTEQUAL) relational_expression)*
;

relational_expression
:
    bitwise_or ((LOWER | GREATER | LOWEREQ | GREATEREQ) bitwise_or)*
;

bitwise_or
:
    bitwise_and ((VBAR|XOR) bitwise_and)*
;

bitwise_and
:
    shift_expression (BITWISE_AND shift_expression)*
;

shift_expression
:
    additive_expression ((LEFTSHIFT | RIGHTSHIFT) additive_expression)*
;

additive_expression
:
    multiplicative_expression ((PLUS | MINUS | PLUSMOD | MINUSMOD) multiplicative_expression)*                            #AdditiveExpression
;

multiplicative_expression
:
    unary_expression ((MUL | DIV | MOD) unary_expression)*
;

unary_expression
:
    (PLUSPLUS | MINUSMINUS | PLUSPLUSMOD | MINUSMINUSMOD)  unary_expression
    | (MUL | PLUS | MINUS | NOT) unary_expression
    | postfix_expression
;

postfix_expression
:
    factor (PLUSPLUS | MINUSMINUS)*
;

factor
:
    function_call
    | ref_name
    | value
    | LPAR expression RPAR
;

value
:
    scalar_value
    | data_structure
;


scalar_value :
    INT                                                                                                                 #IntValue
    | DOUBLE                                                                                                            #DoubleValue
    | BOOL                                                                                                              #BoolValue
    | STRING                                                                                                            #StringValue
;


//Reference name
ref_name
:
    ref_name_chunk ((POINT|ARROW) ref_name_chunk)*
;

ref_name_chunk
:
    function_call (LBRA expression RBRA)*
    | ID (LBRA expression RBRA)*
;


//Data structures
data_structure
:
    array
    | list
    | set_expression
    | structure
;


//Interval
interval:
    expression POINT POINT expression
;

//Spec
spec:
    expression VBAR ID IN interval
;


//Arrays
array:
    LBRA spec RBRA                                                                                                      #ArrayWithSpec
    | LBRA (expression (COMMA expression)*)? RBRA                                                                       #ArrayWithExpressions
    | LBRA interval RBRA                                                                                                #ArrayWithInterval
;


//Lists
list:
    EMPTYLIST
    | '<' spec '>'
    | '<' (expression (COMMA expression)*)? '>'
    | '<' interval '>'
;


//Structures
structure:
    LCB (component)+ RCB
;

component:
    ID ARROW expression
;


//Sets
set:
    EMPTYSET
    | LCB spec RCB
    | LCB (expression (COMMA expression)*)? RCB
    | LCB interval RCB
;


//Function
function_call
:
    builtin_method
    | ID LPAR (expression (COMMA expression)*)? RPAR
;

builtin_method
:
    method_name LPAR (expression (COMMA expression)*)? RPAR
;

method_name :
    AT
    | DELETE
    | END
    | FIRST
    | INSERT
    | POPBACK
    | POPFRONT
    | PUSHBACK
    | PUSHFRONT
    | REMOVE
    | REMOVEALLEQTO
    | REMOVEAT
    | SINGLETONSET
    | SIZE
    | TOPFRONT
    | TOPBACK
    | TOPFRONT
    | UPDATE
;
