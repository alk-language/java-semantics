grammar init;

import expression;

configuration:
    (ID TO expression)* EOF                                                                                             #Config
;