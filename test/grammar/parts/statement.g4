grammar statement;

import expression;


//Instructions iteration

statement_sequence
:
    statement                                                      #ToInstruction
    | statement statement_sequence                                  #InstructionSeq
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

    | assignment SEMICOLON                                    #ToAssign
    | increase_decrease SEMICOLON                               #ID
    | statement_block                                         #ToBlock

    | while_struct                                            #ToWhile
    | do_while_struct SEMICOLON                               #DoWhile
    | if_struct                                               #ToIf
    | for_struct                                              #For
    | forall_struct                                           #ForAll
;

statement_block
:
    LCB statement_sequence RCB                           #Block
;

choose:
    CHOOSE ID IN expression
;

increase_decrease
:
    PLUSPLUS ref_name
    | ref_name PLUSPLUS
    | MINUSMINUS ref_name
    | ref_name MINUSMINUS
    | PLUSPLUSMOD ref_name
    | MINUSMINUSMOD ref_name
;

assignment
:
    ref_name ASSIGNMENT_OPERATOR expression
;

while_struct
:
    WHILE LPAR expression RPAR statement               #While
;

do_while_struct
:
    DO statement WHILE LPAR expression RPAR
;

if_struct
:
    IF LPAR expression RPAR statement (ELSE statement)?
;

for_struct
:
    FOR LPAR assignment? SEMICOLON expression SEMICOLON (assignment | increase_decrease) RPAR statement
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