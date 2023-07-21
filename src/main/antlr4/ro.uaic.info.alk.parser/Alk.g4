grammar Alk;

options { tokenVocab = AlkLexer; }

main
:
    statement_sequence EOF #StartPoint
;

configuration
:
    (ID TO expression)* EOF #Config
;

statement_sequence
:
    (statement)* #StatementSeq
;

statement
:
    function_decl #ToFunctionDecl
    | specification SEMI #ToSpecification
    | RETURN (expression)? SEMI #ReturnStmt

    | CHOOSE expression FROM expression (SOTHAT expression)? SEMI #ChooseStmt
    | UNIFORM expression FROM expression SEMI #UniformStmt
    | SUCCESS SEMI #Success
    | FAILURE SEMI #Failure

    | CONTINUE SEMI #ContinueStmt
    | BREAK SEMI #BreakStmt
    | LCB statement_sequence RCB #Block

    | directive #ToDirective

    | REPEAT statement UNTIL LPAR expression RPAR while_anno* loop_assert? SEMI #RepeatStructure
    | WHILE LPAR expression RPAR while_anno* statement loop_assert? #WhileStructure
    | DO statement WHILE LPAR expression RPAR while_anno* loop_assert? SEMI #DoWhileStructure
    | IF LPAR expression RPAR statement (ELSE statement)? #IfStructure
    | FOR LPAR expression SEMI expression SEMI expression RPAR while_anno* statement loop_assert? #ForStructure
    | FOREACH ID FROM expression while_anno* statement loop_assert? #ForEachStructure

    | expression SEMI #ExpressionStmt
    | SYMBOLIC symbolicDeclarator (COMMA symbolicDeclarator)* #SymbolicDecls
    | HAVOC declarator (COMMA declarator)* #Havoc

    | ASSUME expression SEMI #Assume
    | ASSERT expression SEMI #Assert
    | VAR declarator (COMMA declarator)* #Var
;

specification
:
    REQURIES req_expression #MainReqSpec
    | ENSURES ens_expression #MainEnsSpec
;

declarator
:
    ID DPOINT dataType #Decl
;

symbolicDeclarator
:
    SYM ID DPOINT dataType #SymbolicIdDecl
;

directive
:
    NUMSIGN INCLUDE STRING #Include
;

while_anno
:
    INVARIANT expression SEMI? #InvariantAnno
    | MODIFIES_ANNO modif_factor (COMMA modif_factor)* SEMI? #ModifiesAnno
;

modif_factor
:
    ID #IdModif
    | ID POINT SIZE #SizeModif
;

loop_assert
:
    LOOPASSESRT expression SEMI? #LoopAssertAnno
;

function_uses_list
:
    USES ID (COMMA ID)* #FunctionUsesList
;

function_modifies_list
:
    MODIFIES ID (COMMA ID)* #FunctionModifiesList
;

function_decl
:
    ID LPAR (param (COMMA param)*)? RPAR function_uses_list? function_modifies_list?
    (REQURIES req_expression SEMI?)*
    (ENSURES ens_expression SEMI?)*
    LCB statement_sequence RCB #FunctionDecl
;

    req_expression
:
    expression #ReqExpression
    | declarator (AND declarator)* #TypeAssertReq
;

ens_expression
:
    expression #EnsExpression
    | RESULT DPOINT dataType #TypeAssertEns
;

param
:
    (OUT)? ID #ParamDefinition
;

expression
:
    assign_expression IMPLIES expression #ImpliesExpr
    | assign_expression EQUIV expression #EquivExpr
    | FORALL (declarator (COMMA declarator)*) QUANTIFIER_SEPARATOR expression #ForallExpr
    | EXISTS (declarator (COMMA declarator)*) QUANTIFIER_SEPARATOR expression #ExistsExpr
    | assign_expression #FolToExpr
;

assign_expression
:
    factor ASSIGNMENT_OPERATOR expression #AssignExpression
    | conditional_expression #ToConditionalExpr
;

conditional_expression
:
    logical_or_expression (QUESTION expression DPOINT expression)? #ConditionalExpression
;

logical_or_expression
:
    logical_and_expression (OR logical_or_expression)? #LogicalOrExpression
;

logical_and_expression
:
    in_expression (AND logical_and_expression)? #LogicalAndExpression
;

in_expression
:
    equality_expression (IN in_expression)? #InExpression
;

equality_expression
:
    relational_expression ((IS_EQUAL | NOT_EQUAL) equality_expression)? #EqualityExpression
;

relational_expression
:
    set_expression ((LOWER | GREATER | LOWER_EQ | GREATER_EQ) relational_expression)? #RelationalExpression
;

set_expression
:
    bitwise_or ((UNION | INTERSECT | SUBTRACT) set_expression)? #SetExpression
;

bitwise_or
:
    bitwise_and ((VBAR | BITWISE_XOR) bitwise_or)? #BitwiseOrExpression
;

bitwise_and
:
    shift_expression (BITWISE_AND bitwise_and)? #BitwiseAndExpression
;

shift_expression
:
    additive_expression ((LEFT_SHIFT | RIGHT_SHIFT) shift_expression)? #ShiftExpression
;

additive_expression
:
    multiplicative_expression ((PLUS | MINUS) additive_expression)? #AdditiveExpression
;

multiplicative_expression
:
    unary_expression ((MUL | DIV | MOD) multiplicative_expression)? #MultiplicativeExpression
;

unary_expression
:
    (PLUSPLUS | MINUSMINUS) unary_expression #PrefixExpression
    | (PLUS | MINUS | NOT) unary_expression #UnaryExpression
    | postfix_expression #ToPostfixExpression
;

postfix_expression
:
    factor (PLUSPLUS | MINUSMINUS)* #PostfixExpression
;

factor
:
    factor POINT builtin_method #FactorPointMethod
    | factor POINT ID #FactorPointID
    | factor LBRA expression RBRA #FactorArray
    | base_factor #ToBaseFactor
;

base_factor
:
    RESULT #ResultFactor
    | OLD LPAR ID RPAR #OldFactor
    | ref_name #RefNameFactor
    | value #ValueFactor
    | LPAR expression RPAR #ParanthesesFactor
    | ANNO anno LPAR expression RPAR #AnnoFactor
;

anno
:
    COUNT #CountAnno
;

value
:
    scalar_value
    | data_structure
;


scalar_value :
    INT #IntValue
    | FLOAT #FloatValue
    | BOOL #BoolValue
    | STRING #StringValue
;

ref_name
:
    function_call #RefFunctionCall
    | ID #RefID
    | SYM ID #SymID
;

data_structure
:
    array #ArrayValue
    | list #ListValue
    | mapping #MappingValue
    | set #SetValue
    | structure #StructureValue
;

interval:
    expression POINT POINT expression #IntervalDefinition
;

spec:
    ID FROM expression VBAR expression #FilterSpecDefinition
    | expression VBAR ID FROM expression #SelectSpecDefinition
;

component:
    ID ARROW expression #ComponentDefinition
;

mapping_component:
    expression TO expression #MappingComponentDefinition
;

array:
    EMPTYARRAY (LOWER dataType GREATER)? #EmptyArray
    | LBRA (expression (COMMA expression)*)? RBRA #ArrayWithExpressions
    | LBRA interval RBRA #ArrayWithInterval
    | LBRA spec RBRA #ArrayWithSpec
;

list:
    EMPTYLIST (LOWER dataType GREATER)? #EmptyList
    | LOWER (expression (COMMA expression)*)? GREATER #ListWithExpressions
    | LOWER interval GREATER #ListWithInterval
    | LOWER spec GREATER #ListWithSpec
;

// TODO: allow hinting data type with empty map
mapping:
    (EMPTYMAP | LCB TO RCB) #EmptyMapping
    | LCB (mapping_component)+ RCB #MappingWithComponents
;

set:
    EMPTYSET (LOWER dataType GREATER)? #EmptySet
    | LCB (expression (COMMA expression)*)? RCB #SetWithExpressions
    | LCB interval RCB #SetWithInterval
    | LCB spec RCB #SetWithSpec
;

// TODO: allow hinting data type with empty structure
structure:
    (EMPTYSTRUCTURE | LCB ARROW RCB) #EmptyStructure
    | LCB (component)+ RCB #StructureWithComponents
;

function_call
:
    builtin_function #ToBuiltinFunction
    | ID LPAR (expression (COMMA expression)*)? RPAR #DefinedFunctionCall
;

builtin_function
:
    function_name LPAR (expression (COMMA expression)*)? RPAR #BuiltinFunction
;

builtin_method
:
    method_name LPAR (expression (COMMA expression)*)? RPAR #BuiltinMethod
;

dataType
:
    BOOL_TYPE #BoolType
    | INT_TYPE #IntType
    | FLOAT_TYPE #FloatType
    | STRING_TYPE #StringType
    | ARRAY_TYPE LOWER dataType GREATER #ArrayType
    | LIST_TYPE LOWER dataType GREATER #ListType
    | MAP_TYPE LOWER dataType COMMA dataType GREATER #MapType
    | SET_TYPE LOWER dataType GREATER #SetType
    | STRUCT_TYPE LOWER ID ARROW dataType (COMMA ID ARROW dataType)* GREATER #StructType
;

function_name :
    ABS
    | ASIN
    | ACOS
    | ATAN
    | COS
    | FLIP
    | FLOAT_TYPE
    | INT_TYPE
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

method_name :
    AT
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
