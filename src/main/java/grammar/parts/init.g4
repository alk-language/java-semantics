grammar init;

import expression;



configuration:
    var_def_seq? EOF                                                                                                    #Config
;

var_def_seq:
    variable+                                                                                                           #VarSeq
;

variable:
    ID TO expression                                                                                                    #Var
;