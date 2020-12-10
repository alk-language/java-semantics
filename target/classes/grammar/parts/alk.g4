grammar alk;

@header {
    package grammar;
}

import statement, init;

main
:
    statement_sequence? EOF                                                                                             #StartPoint
;
