
export CLASSPATH=".:$PWD/../include/antlr-4.7.1-complete.jar:$CLASSPATH"
alias antlr4="java -jar $PWD/../include/antlr-4.7.1-complete.jar"
alias grun='java org.antlr.v4.gui.TestRig'
antlr4 $PWD/../src/grammar/parts/alg_debug.g4 -no-listener -visitor -o $PWD/../src/debug
javac $PWD/../src/debug/alg_debug*java