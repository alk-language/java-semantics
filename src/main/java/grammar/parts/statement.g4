grammar statement;

import expression;


//Instructions iteration

statement_sequence
:
    (statement)+                                                                                                        #StatementSeq
;

statement //statement
:
    ref_name (POINT|ARROW) builtin_method SEMICOLON                                                                     #MethodCall
    | function_call SEMICOLON                                                                                           #FunctionCall
    | function_decl                                                                                                     #ToFunctionDecl
    | RETURN (expression)? SEMICOLON                                                                                    #ReturnStmt

    | choose SEMICOLON                                                                                                  #ToChooseStmt
    | SUCCESS SEMICOLON                                                                                                 #Success
    | FAILURE SEMICOLON                                                                                                 #Failure

    | CONTINUE SEMICOLON                                                                                                #ContinueStmt
    | BREAK SEMICOLON                                                                                                   #BreakStmt

    | assignment SEMICOLON                                                                                              #ToAssignmentStmt
    | increase_decrease SEMICOLON                                                                                       #ToIncreaseDecrease
    | statement_block                                                                                                   #ToBlock

    | directive                                                                                                         #ToDirective

    | repeat_struct SEMICOLON                                                                                           #ToRepeat
    | while_struct                                                                                                      #ToWhile
    | do_while_struct SEMICOLON                                                                                         #ToDoWhile
    | if_struct                                                                                                         #ToIf
    | for_struct                                                                                                        #ToFor
    | foreach_struct                                                                                                    #ToForEach
;

directive
:
    NUMSIGN INCLDUE STRING                                                                                              #Include
;

repeat_struct
:
    REPEAT statement UNTIL LPAR expression RPAR                                                                         #RepeatStructure
;

statement_block
:
    LCB statement_sequence RCB                                                                                          #Block
    | LCB RCB                                                                                                           #EmptyBlock
;


choose:
    CHOOSE ID IN expression (SOTHAT expression)?                                                                        #ChooseStmt
    | UNIFORM ID IN expression                                                                                          #UniformStmt
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

foreach_struct
:
    FOREACH ID IN expression statement                                                                                   #ForEachStructure
;

function_decl
:
    ID LPAR (param (COMMA param)*)? RPAR (MODIFIES ID (COMMA ID)*)? statement_block                                     #FunctionDecl
;

param
:
    (OUT)? ID                                                                                                           #ParamDefinition
;