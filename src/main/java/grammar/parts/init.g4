grammar init;

import expression;

configuration:
    (variable)*                                                                                                         #Config
;

variable:
    ID TO expression                                                                                                    #Var
;