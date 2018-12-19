grammar alg;

@header {
    package grammar;
}

import expression;


main
:
    instruction_sequence? EOF
;



//Instructions iteration

instruction_sequence
:
    instruction SEMICOLON                                    #ToInstruction
    | instruction SEMICOLON instruction_sequence             #InstructionSeq
;



//Instructions

instruction
:
    assignment                                              #ToAssign
    | print                                                 #ToPrint
;

assignment
:
    VAR EQUAL expression                                    #Assign
;

print
:
   PRINT expression RPAR                                    #PrintF
;



//Arithmetic Operations

expression:
    plus_or_minus                                   #ToPlusMinus
;

plus_or_minus
:
    plus_or_minus PLUS mul_or_div                   # Plus
    | plus_or_minus MINUS mul_or_div                # Minus
    | mul_or_div                                    # ToMulDiv
;

mul_or_div
:
    mul_or_div MUL unary_minus                      # Mul
    | mul_or_div DIV unary_minus                    # Div
    | unary_minus                                   # ToUnaryMinus
;

unary_minus
:
    MINUS unary_minus                               #ChangeSign
    | atom                                          #ToAtom
;

atom
:
    INT                                             # Int
    | VAR                                           # Var
    | LPAR plus_or_minus RPAR                       # Braces
;



//Predefined symbols

INT : NONZERODIGIT DIGIT* | ZERO;
VAR: NONDIGIT (DIGIT | NONDIGIT)*;

fragment NONDIGIT: [a-zA-Z_];
fragment DIGIT: [0-9];
fragment NONZERODIGIT: [1-9];

ZERO: '0';
MINUS : '-';
PLUS : '+';
MUL : '*';
DIV : '/';
LPAR : '(';
RPAR : ')';
EQUAL : '=';
SEMICOLON : ';';
WS : [ \t\r\n]+ -> skip;


//Predefined functions
PRINT: 'print(';