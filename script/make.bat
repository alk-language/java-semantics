set PATH="%PATH%;"g:\facultate\ALK\java-semnatics\script\"
java -jar ./antlr-4.7.1-complete.jar ./../src/main/java/grammar/parts/alk.g4 -no-listener -visitor -o ./../src/main/java/grammar
javac ./../src/main/java/grammar/alk*java
