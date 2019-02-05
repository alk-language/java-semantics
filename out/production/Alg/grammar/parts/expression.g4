grammar expression;

import terminal;


//Arithmetic expressions

expression
:
    logical_or_expression (QUESTION expression DPOINT expression)?                                                      #ConditionalExpression
;

logical_or_expression
:
    logical_and_expression (OR logical_and_expression)*                                                                 #LogicalOrExpression
;

logical_and_expression
:
    in_expression (AND in_expression)*                                                                                  #LogicalAndExpression
;

in_expression
:
    equality_expression (IN equality_expression)*                                                                       #InExpression
;

equality_expression
:
    relational_expression ((ISEQUAL | NOTEQUAL) relational_expression)*                                                 #EqualityExpression
;

relational_expression
:
    set_expression ((LOWER | GREATER | LOWEREQ | GREATEREQ) set_expression)*                                            #RelationalExpression
;

set_expression:
    bitwise_or ((UNION | INTERSECT | SUBTRACT) bitwise_or)*                                                             #SetExpression
;

bitwise_or
:
    bitwise_and ((VBAR|XOR) bitwise_and)*                                                                               #BitwiseOrExpression
;

bitwise_and
:
    shift_expression (BITWISE_AND shift_expression)*                                                                    #BitwiseAndExpression
;

shift_expression
:
    additive_expression ((LEFTSHIFT | RIGHTSHIFT) additive_expression)*                                                 #ShiftExpression
;

additive_expression
:
    multiplicative_expression ((PLUS | MINUS | PLUSMOD | MINUSMOD) multiplicative_expression)*                          #AdditiveExpression
;

multiplicative_expression
:
    unary_expression ((MUL | DIV | MOD) unary_expression)*                                                              #MultiplicativeExpression
;

unary_expression
:
    (PLUSPLUS | MINUSMINUS | PLUSPLUSMOD | MINUSMINUSMOD)  unary_expression                                             #PrefixExpression
    | (MUL | PLUS | MINUS | NOT) unary_expression                                                                       #UnaryExpression
    | postfix_expression                                                                                                #ToPostfixExpression
;

postfix_expression
:
    factor (PLUSPLUS | MINUSMINUS)*                                                                                     #PostfixExpression
;

factor
:
    function_call                                                                                                       #FunctionCallFactor
    | ref_name                                                                                                          #RefNameFactor
    | value                                                                                                             #ValueFactor
    | LPAR expression RPAR                                                                                              #ParanthesesFactor
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
    ref_name_chunk ((POINT|ARROW) ref_name_chunk)*                                                                      #RefName
;

ref_name_chunk
:
    function_call (LBRA expression RBRA)*                                                                               #FunctionChunk
    | ID (LBRA expression RBRA)*                                                                                        #IDChunk
;


//Data structures
data_structure
:
    array                                                                                                               #ArrayValue
    | list                                                                                                              #ListValue
    | set                                                                                                               #SetValue
    | structure                                                                                                         #StructureValue
;


//Interval
interval:
    expression POINT POINT expression                                                                                   #IntervalDefinition
;

//Spec
spec:
    expression VBAR ID IN interval                                                                                      #SpecDefinition
;


//Arrays
array:
    LBRA spec RBRA                                                                                                      #ArrayWithSpec
    | LBRA (expression (COMMA expression)*)? RBRA                                                                       #ArrayWithExpressions
    | LBRA interval RBRA                                                                                                #ArrayWithInterval
;


//Lists
list:
    EMPTYLIST                                                                                                           #EmptyList
    | '<' spec '>'                                                                                                      #ListWithSpec
    | '<' (expression (COMMA expression)*)? '>'                                                                         #ListWithExpressions
    | '<' interval '>'                                                                                                  #ListWithInterval
;


//Structures
structure:
    LCB (component)+ RCB                                                                                                #StructureWithComponents
;

component:
    ID ARROW expression                                                                                                 #ComponentDefinition
;


//Sets
set:
    EMPTYSET                                                                                                            #EmptySet
    | LCB spec RCB                                                                                                      #SetWithSpec
    | LCB (expression (COMMA expression)*)? RCB                                                                         #SetWithExpressions
    | LCB interval RCB                                                                                                  #SetWithInterval
;


//Function
function_call
:
    builtin_method
    | ID LPAR (expression (COMMA expression)*)? RPAR
;

builtin_method
:
    method_name LPAR (expression (COMMA expression)*)? RPAR                                                             #BuiltinMethod
;

method_name :
    AT
    | DELETE
    | END
    | FIRST
    | INSERT
    | PRINT
    | POPBACK
    | POPFRONT
    | PUSHBACK
    | PUSHFRONT
    | REMOVE
    | REMOVEALLEQTO
    | REMOVEAT
    | SINGLETONSET
    | SIZE
    | TOPBACK
    | TOPFRONT
    | UPDATE
;
