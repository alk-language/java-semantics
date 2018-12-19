#!/bin/bash

export CLASSPATH=".:$PWD/../include/antlr-4.7.1-complete.jar:$CLASSPATH"
alias antlr4="java -jar $PWD/../include/antlr-4.7.1-complete.jar"
alias grun='java org.antlr.v4.gui.TestRig'
antlr4 $PWD/../src/grammar/parts/alk.g4 -no-listener -visitor -o $PWD/../src/grammar
javac $PWD/../src/grammar/alk*java
