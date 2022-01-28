grammar statement;

import expression;

statement_sequence
:
    (statement)+                                                                                                        #StatementSeq
;

statement
:
    function_decl                                                                                                       #ToFunctionDecl
    | RETURN (expression)? SEMICOLON                                                                                    #ReturnStmt

    | choose SEMICOLON                                                                                                  #ToChooseStmt
    | SUCCESS SEMICOLON                                                                                                 #Success
    | FAILURE SEMICOLON                                                                                                 #Failure

    | CONTINUE SEMICOLON                                                                                                #ContinueStmt
    | BREAK SEMICOLON                                                                                                   #BreakStmt
    | statement_block                                                                                                   #ToBlock

    | directive                                                                                                         #ToDirective

    | repeat_struct SEMICOLON                                                                                           #ToRepeat
    | while_struct                                                                                                      #ToWhile
    | do_while_struct SEMICOLON                                                                                         #ToDoWhile
    | if_struct                                                                                                         #ToIf
    | for_struct                                                                                                        #ToFor
    | foreach_struct                                                                                                    #ToForEach

    | expression SEMICOLON                                                                                              #ExpressionStmt
    | symbolicStmt SEMICOLON                                                                                            #SymbolicDeclStmt
    | havocStmt SEMICOLON                                                                                               #ToHavocStmt

    | assumeStmt SEMICOLON                                                                                              #ToAssumeStmt
    | assertStmt SEMICOLON                                                                                              #ToAssertStmt
;

assumeStmt
:
    ASSUME expression                                                                                                   #Assume
;

assertStmt
:
    ASSERT expression                                                                                                   #Assert
;

havocStmt
:
    HAVOC ID (COMMA ID)*                                                                                                #Havoc
;

symbolicStmt
:
    SYMBOLIC symbolicDeclarator (COMMA symbolicDeclarator)*                                                             #SymbolicDecls
;

symbolicDeclarator
:
    SYM ID DPOINT dataType                                                                                              #SymbolicIdDecl
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
    LCB (statement_sequence)? RCB                                                                                       #Block
;


choose:
    CHOOSE expression FROM expression (SOTHAT expression)?                                                              #ChooseStmt
    | UNIFORM expression FROM expression                                                                                #UniformStmt
;

while_struct
:
    WHILE LPAR expression RPAR (INVARIANT expression)* ((MODIFIES | USES) ID (COMMA ID)*)? statement                    #WhileStructure
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
    FOR LPAR expression SEMICOLON expression SEMICOLON expression RPAR statement                                        #ForStructure
;

foreach_struct
:
    FOREACH ID FROM expression statement                                                                                #ForEachStructure
;

function_decl
:
    ID LPAR (param (COMMA param)*)? RPAR (DPOINT dataType)? ((MODIFIES | USES) ID (COMMA ID)*)?
    (REQURIES req_expression)*
    (ENSURES ens_expression)*
    statement_block                                                                                                     #FunctionDecl
;

req_expression
:
    expression                                                                                                          #ReqExpression
;

ens_expression
:
    expression                                                                                                          #EnsExpression
;

param
:
    (OUT)? ID (DPOINT dataType)?                                                                                        #ParamDefinition
;