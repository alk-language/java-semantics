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
    ref_name (POINT|ARROW) function_call SEMICOLON                   #ToF
    | function_call SEMICOLON                                 #ToFun
    | function_decl                                           #TOFD
    | RETURN expression SEMICOLON                                 #Return

    | choose SEMICOLON                                         #ChooseStm
    | SUCCESS SEMICOLON                                        #Success
    | FAILURE SEMICOLON                                        #Failure

    | assignment SEMICOLON                                    #ToAssignmentStmt
    | increase_decrease SEMICOLON                             #ID
    | statement_block                                         #ToBlock

    | while_struct                                            #ToWhile
    | do_while_struct SEMICOLON                               #DoWhile
    | if_struct                                               #ToIf
    | for_struct                                              #For
    | forall_struct                                           #ForAll
;

statement_block
:
    LCB statement_sequence RCB                                                                                          #Block
;

choose:
    CHOOSE ID IN expression
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
    FORALL ID IN expression statement
;

function_decl
:
    ID LPAR (param (COMMA param)*)? RPAR statement
;

param
:
    (OUT)? ID
;