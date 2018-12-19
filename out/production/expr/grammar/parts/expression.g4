//Arithmetic Operations
grammar expression;

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