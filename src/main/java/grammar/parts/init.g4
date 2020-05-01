grammar init;

import expression;

configuration:
    (variable)*                                                                                                         #Config
;

variable:
    ref_name TO expression                                                                                              #Var
;