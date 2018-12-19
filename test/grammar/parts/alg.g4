grammar alg;

@header {
    package grammar;
}

import statement;

main
:
    statement_sequence? EOF
;