grammar expression;

import terminal;

//Arithmetic expressions

expression
:
    assign_expression IMPLIES expression                                                                                #ImpliesExpr
    | assign_expression EQUIV expression                                                                                #EquivExpr
    | FORALL (ID DPOINT dataType (COMMA ID DPOINT dataType)*) QUANTIFIER_SEPARATOR expression                           #ForallExpr
    | EXISTS (ID DPOINT dataType (COMMA ID DPOINT dataType)*) QUANTIFIER_SEPARATOR expression                           #ExistsExpr
    | assign_expression                                                                                                 #FolToExpr
;

assign_expression
:
    factor ASSIGNMENT_OPERATOR expression                                                                               #AssignExpression
    | conditional_expression                                                                                            #ToConditionalExpr
;

conditional_expression
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
    (PLUSPLUS | MINUSMINUS | PLUSPLUSMOD | MINUSMINUSMOD) unary_expression                                              #PrefixExpression
    | (MUL | PLUS | MINUS | NOT) unary_expression                                                                       #UnaryExpression
    | postfix_expression                                                                                                #ToPostfixExpression
;

postfix_expression
:
    factor (PLUSPLUS | MINUSMINUS)*                                                                                     #PostfixExpression
;

factor
:
    factor POINT builtin_method                                                                                         #FactorPointMethod
    | factor POINT ID                                                                                                   #FactorPointID
    | factor LBRA expression RBRA                                                                                       #FactorArray
    | base_factor                                                                                                       #ToBaseFactor
;

base_factor
:
    RESULT                                                                                                              #ResultFactor
    | OLD LPAR ID RPAR                                                                                                  #OldFactor
    | ref_name                                                                                                          #RefNameFactor
    | value                                                                                                             #ValueFactor
    | LPAR expression RPAR                                                                                              #ParanthesesFactor
    | ANNO anno LPAR expression RPAR                                                                                    #AnnoFactor
;

anno
:
    COUNT                                                                                                               #CountAnno
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
    | QUESTION                                                                                                          #UnknownValue
;


//Reference name
ref_name
:
    function_call                                                                                                       #RefFunctionCall
    | ID                                                                                                                #RefID
    | SYM ID                                                                                                            #SymID
;



//Data structures
data_structure
:
    array                                                                                                               #ArrayValue
    | list                                                                                                              #ListValue
    | set                                                                                                               #SetValue
    | structure                                                                                                         #StructureValue
    | mapping                                                                                                           #MappingValue
;


//Interval
interval:
    expression POINT POINT expression                                                                                   #IntervalDefinition
;

//Spec
spec:
    ID FROM expression VBAR expression                                                                                  #FilterSpecDefinition
    | expression VBAR ID FROM expression                                                                                #SelectSpecDefinition
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
    | (EMPTYSTRUCTURE | LCB ARROW RCB)                                                                                  #EmptyStructure
;

component:
    ID ARROW expression                                                                                                 #ComponentDefinition
;


//Sets
set:
    EMPTYSET (LOWER dataType GREATER)?                                                                                  #EmptySet
    | LCB spec RCB                                                                                                      #SetWithSpec
    | LCB (expression (COMMA expression)*)? RCB                                                                         #SetWithExpressions
    | LCB interval RCB                                                                                                  #SetWithInterval
;

mapping:
    (EMPTYMAP | LCB TO RCB)                                                                                             #EmptyMapping
    | LCB (mapping_component)+ RCB                                                                                      #MappingWithComponents
;

mapping_component:
    expression TO expression                                                                                            #MappingComponentDefinition
;

//Function
function_call
:
    builtin_function                                                                                                    #ToBuiltinFunction
    | ID LPAR (expression (COMMA expression)*)? RPAR                                                                    #DefinedFunctionCall
;

builtin_function
:
    function_name LPAR (expression (COMMA expression)*)? RPAR                                                           #BuiltinFunction
;

builtin_method
:
    method_name LPAR (expression (COMMA expression)*)? RPAR                                                             #BuiltinMethod
;

// Data type
dataType
:
    INTEGER                                                                                                             #IntType
    | BOOLEAN                                                                                                           #BoolType
    | FLOAT                                                                                                             #FloatType
    | ARRAY LOWER dataType GREATER                                                                                      #ArrayType
    | LIST LOWER dataType GREATER                                                                                       #ListType
    | SET LOWER dataType GREATER                                                                                        #SetType
;

//Also builtin function names
function_name :
    ABS
    | ASIN
    | ACOS
    | ATAN
    | COS
    | FLIP
    | FLOAT
    | INTEGER
    | LEN
    | LOG
    | PI
    | PRINT
    | POW
    | SIN
    | SINGLETONSET
    | SQRT
    | TAN
    | UNIFORMFLOAT
    | UNIFORMNAT
    | UNIFORMPERM
;

//Also builtin function names
method_name :
    AT
    | DELETE
    | END
    | FIRST
    | INSERT
    | KEYS
    | POPBACK
    | POPFRONT
    | PUSHBACK
    | PUSHFRONT
    | REMOVE
    | REMOVEALLEQTO
    | REMOVEAT
    | SIZE
    | SPLIT
    | TOPBACK
    | TOPFRONT
    | UPDATE
;
