grammar statement;

import expression;


//Instructions iteration

statement_sequence
:
    statement
    | statement statement_sequence
;

statement //statement
:
    ref_name (POINT|ARROW) builtin_method SEMICOLON                                                                     #MethodCall
    | function_call SEMICOLON                                                                                           #FunctionCall
    | function_decl                                                                                                     #ToFunctionDecl
    | RETURN (expression)? SEMICOLON                                                                                    #ReturnStmt

    | choose SEMICOLON                                         #ChooseStm
    | SUCCESS SEMICOLON                                        #Success
    | FAILURE SEMICOLON                                        #Failure

    // de adaugat break, continue

    | assignment SEMICOLON                                                                                              #ToAssignmentStmt
    | increase_decrease SEMICOLON                                                                                       #ToIncreaseDecrease
    | statement_block                                                                                                   #ToBlock

    | while_struct                                                                                                      #ToWhile
    | do_while_struct SEMICOLON                                                                                         #ToDoWhile
    | if_struct                                                                                                         #ToIf
    | for_struct                                                                                                        #ToFor
    | forall_struct                                                                                                     #ToForAll
;

statement_block
:
    LCB statement_sequence RCB                                                                                          #Block
;

choose:
    CHOOSE ID IN expression (SOTHAT expression)?                                                                        #ChooseStmt
;

increase_decrease
:
    PLUSPLUS ref_name                                                                                                   #PlusPlusStmt
    | ref_name PLUSPLUS                                                                                                 #StmtPlusPlus
    | MINUSMINUS ref_name                                                                                               #MinusMinusStmt
    | ref_name MINUSMINUS                                                                                               #StmtMinusMinus
    | PLUSPLUSMOD ref_name                                                                                              #PlusPlusModStmt
    | MINUSMINUSMOD ref_name                                                                                            #MinusMinusModStmt
;

assignment
:
    ref_name ASSIGNMENT_OPERATOR expression                                                                             #AssignmentStmt
;

while_struct
:
    WHILE LPAR expression RPAR statement                                                                                #WhileStructure
;

do_while_struct
:
    DO statement WHILE LPAR expression RPAR                                                                             #DoWhileStructure
;

if_struct
:
    IF LPAR expression RPAR statement (ELSE statement)?                                                                 #IfStructure
;

for_struct
:
    FOR LPAR start_assignment? SEMICOLON expression SEMICOLON (assignment | increase_decrease) RPAR statement           #ForStructure
;

start_assignment:
    assignment                                                                                                          #ForStart
;

forall_struct
:
    FORALL ID IN expression statement                                                                                   #ForAllStructure
;

function_decl
:
    ID LPAR (param (COMMA param)*)? RPAR (MODIFIES ID (COMMA ID)*)?statement_block                                      #FunctionDecl
;

param
:
    (OUT)? ID                                                                                                           #ParamDefinition
;